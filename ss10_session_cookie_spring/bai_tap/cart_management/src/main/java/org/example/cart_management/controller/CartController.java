package org.example.cart_management.controller;

import org.example.cart_management.entity.CartItem;
import org.example.cart_management.entity.Order;
import org.example.cart_management.entity.OrderDetail;
import org.example.cart_management.entity.Product;
import org.example.cart_management.service.IOrderDetailService;
import org.example.cart_management.service.IOrderService;
import org.example.cart_management.service.IProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.bind.support.SessionStatus;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.time.LocalDate;
import java.util.HashMap;
import java.util.Map;

@Controller
@RequestMapping("/cart")
@SessionAttributes("cart")
public class CartController {

    @Autowired
    private IProductService productService;
    
    @Autowired
    private IOrderService orderService;

    @Autowired
    private IOrderDetailService orderDetailService;

    @ModelAttribute("cart")
    public Map<Long, CartItem> initCart() {
        return new HashMap<>();
    }

    @PostMapping("/add")
    public String addToCart(@RequestParam Long productId,
                            @RequestParam(defaultValue = "1") Integer quantity,
                            @ModelAttribute("cart") Map<Long, CartItem> cart,
                            RedirectAttributes redirect) {
        Product product = productService.findById(productId);
        if (product == null) {
            redirect.addFlashAttribute("error", "Sản phẩm không tồn tại.");
            return "redirect:/cart/view";
        }
        CartItem item = cart.get(productId);
        if (item == null){
            item = new CartItem();
            item.setProduct(product);
            item.setQuantity(quantity);
        }else {
            int currentQty = item.getQuantity() == null ? 0 : item.getQuantity();
            item.setQuantity(currentQty + quantity);
        }
       
        cart.put(productId, item);
        
        redirect.addFlashAttribute("message", "Đã thêm vào giỏ hàng");
        return "redirect:/cart/view";
    }
    
    @GetMapping("/view")
    public String viewCart(@ModelAttribute("cart") Map<Long, CartItem> cart, Model model){
        double total = cart.values().stream().mapToDouble(CartItem::getTotal).sum();
        model.addAttribute("total", total);
        return "view";
    }

    @PostMapping("/update")
    public String updateQuantity(@RequestParam Long productId,
                                 @RequestParam int quantity,
                                 @ModelAttribute("cart") Map<Long, CartItem> cart) {
        if (cart.containsKey(productId)) {
            cart.get(productId).setQuantity(quantity);
        }
        return "redirect:/cart/view";
    }

    @PostMapping("/remove")
    public String removeItem(@RequestParam Long productId,
                             @ModelAttribute("cart") Map<Long, CartItem> cart) {
        cart.remove(productId);
        return "redirect:/cart/view";
    }

    @PostMapping("/checkout")
    public String checkout(@ModelAttribute("cart") Map<Long, CartItem> cart,
                           SessionStatus status) {
        Order order = new Order();
        order.setCreateAt(LocalDate.now());
        orderService.save(order);

        for (CartItem item : cart.values()) {
            OrderDetail detail = new OrderDetail();
            detail.setOrder(order);
            detail.setProduct(item.getProduct());
            detail.setQuantity(item.getQuantity());
            detail.setPrice(item.getProduct().getPrice());
            orderDetailService.save(detail);
        }

        status.setComplete(); // xóa session
        return "redirect:/cart/success";
    }

    @GetMapping("/success")
    public String successPage() {
        return "success";
    }
}
