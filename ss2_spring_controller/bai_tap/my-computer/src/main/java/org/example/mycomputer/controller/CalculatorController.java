package org.example.mycomputer.controller;

import org.example.mycomputer.service.impl.CalculatorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class CalculatorController {
    
    @Autowired
    private CalculatorService calculatorService;

    @GetMapping("/")
    public String showForm() {
        return "index";
    }

    @PostMapping("/calculate")
    public String calculate(@RequestParam String number1,
                            @RequestParam String number2,
                            @RequestParam String operator,
                            Model model) {
        try {
            double result = calculatorService.calculate(number1, number2, operator);
            model.addAttribute("result", result);
        } catch (NumberFormatException e) {
            model.addAttribute("error", "Vui lòng nhập số!");
        } catch (IllegalArgumentException e) {
            model.addAttribute("error", "Vui lòng chọn toán tử để tính!");
        } catch (ArithmeticException e){
            model.addAttribute("error", "Không thể chia cho 0!");
        }
        return "result";
    }
}
