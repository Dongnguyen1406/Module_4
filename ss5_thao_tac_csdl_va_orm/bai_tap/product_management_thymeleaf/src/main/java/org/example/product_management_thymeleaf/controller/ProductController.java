package org.example.product_management_thymeleaf.controller;

import org.example.product_management_thymeleaf.model.Product;
import org.example.product_management_thymeleaf.service.IProductService;
import org.example.product_management_thymeleaf.service.ProductService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.List;

@Controller
@RequestMapping("/products")
public class ProductController {

    private static final IProductService productService = new ProductService();

    @GetMapping("")
    public String index(Model model) {
        List<Product> productList = productService.findAll();
        model.addAttribute("products", productList);
        return "/index";
    }

    @GetMapping("/create")
    public String create(Model model) {
        model.addAttribute("product", new Product());
        return "/create";
    }

    @GetMapping("/{id}/edit")
    public String update(@PathVariable int id, Model model) {
        model.addAttribute("product", productService.findById(id));
        return "/update";
    }

    @GetMapping("/{id}/view")
    public String view(@PathVariable int id, Model model, RedirectAttributes redirect) {
        if (productService.findById(id) != null) {
            model.addAttribute("product", productService.findById(id));
            return "/view";
        }
        redirect.addFlashAttribute("message", "khong tim thay!");
        return "redirect:/products";
    }

    @GetMapping("/{id}/delete")
    public String delete(@PathVariable int id, Model model) {
        model.addAttribute("product", productService.findById(id));
        return "/delete";
    }

    @GetMapping("/search")
    public String search(String name, Model model, RedirectAttributes redirect) {
        List<Product> products = productService.searchByName(name);
        if (products.size() != 0) {
            model.addAttribute("products", productService.searchByName(name));
            return "/index";
        } else {
            model.addAttribute("message", "Không tìm thấy!");
            return "/index";
        }
    }

    @PostMapping("/save")
    public String save(Product product) {
//        product.setId((int) (Math.random() * 10000));
        productService.save(product);
        return "redirect:/products";
    }

    @PostMapping("/update")
    public String update(Product product, RedirectAttributes redirect) {
        productService.update(product.getId(), product);
        redirect.addFlashAttribute("success", "Update product successfully");
        return "redirect:/products";
    }

    @PostMapping("/delete")
    public String delete(Product product, RedirectAttributes redirect) {
        productService.remove(product.getId());
        redirect.addFlashAttribute("success", "Removes product successfully");
        return "redirect:/products";
    }

}
