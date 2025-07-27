package org.example.cart_management.controller;

import org.example.cart_management.entity.Product;
import org.example.cart_management.service.IProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
@RequestMapping("/product")
public class ProductController {
    @Autowired
    private IProductService productService;
    
    @GetMapping
    public String list(Model model){
        model.addAttribute("products", productService.findAll());
        return "list";
    }

    @GetMapping("/{id}/detail")
    public String detail(@PathVariable Long id, Model model, RedirectAttributes redirectAttributes){
        Product product = productService.findById(id);
        if (product == null) {
            redirectAttributes.addFlashAttribute("error", "Sản phẩm không tồn tại");
            return "redirect:/product";
        }
        model.addAttribute("product", product);
        return "detail";
    }
}
