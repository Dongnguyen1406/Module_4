package org.example.mycomputer.service.impl;

import org.example.mycomputer.service.ICalculatorService;
import org.springframework.stereotype.Service;

@Service
public class CalculatorService implements ICalculatorService {
    @Override
    public double calculate(String firstNumberStr, String secondNumberStr, String operator) throws ArithmeticException {
        try {
            double firstNumber = Double.parseDouble(firstNumberStr);
            double secondNumber = Double.parseDouble(secondNumberStr);
            
            switch (operator) {
                case "+":
                    return firstNumber + secondNumber;
                case "-":
                    return firstNumber - secondNumber;
                case "*":
                    return firstNumber * secondNumber;
                case "/":
                    if (secondNumber == 0) throw new ArithmeticException("Cannot divide by zero");
                    return firstNumber / secondNumber;
                default:
                    throw new IllegalArgumentException("Invalid operator");
            }
        }catch (NumberFormatException e){
            throw new NumberFormatException();
        }
    }
}
