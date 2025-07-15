package org.example.mycomputer.service.impl;

import org.example.mycomputer.service.ICalculatorService;
import org.springframework.stereotype.Service;

@Service
public class CalculatorService implements ICalculatorService {
    @Override
    public double calculate(double first, double second, String operator) throws ArithmeticException {
        switch (operator) {
            case "+":
                return first + second;
            case "-":
                return first - second;
            case "*":
                return first * second;
            case "/":
                if (second == 0) throw new ArithmeticException("Cannot divide by zero");
                return first / second;
            default:
                throw new IllegalArgumentException("Invalid operator");
        }
    }
}
