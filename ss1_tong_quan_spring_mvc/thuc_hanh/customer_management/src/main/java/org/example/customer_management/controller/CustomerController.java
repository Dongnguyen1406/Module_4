package org.example.customer_management.controller;

import org.example.customer_management.entity.Customer;
import org.example.customer_management.service.impl.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

@Controller
@RequestMapping("/customers")
public class CustomerController {
    @Autowired
    private CustomerService customerService;
    
    @GetMapping
    public String showList(Model model){
        model.addAttribute("customers", customerService.findAll());
        return "list";
    }

    @GetMapping("/info")
    public String showCustomerInfo(@RequestParam("id") int id, Model model) {
        List<Customer> customers = customerService.findAll();
        Customer selectedCustomer = null;

        for (Customer c : customers) {
            if (c.getCodeCus() == id) {
                selectedCustomer = c;
                break;
            }
        }

        if (selectedCustomer != null) {
            model.addAttribute("customer", selectedCustomer);
            return "info"; 
        } else {
            return "redirect:/customers"; 
        }
    }

}
