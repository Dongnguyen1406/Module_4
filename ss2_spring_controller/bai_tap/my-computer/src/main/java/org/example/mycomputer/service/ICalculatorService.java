package org.example.mycomputer.service;

public interface ICalculatorService {
    double calculate(double first, double second, String operator) throws ArithmeticException;
}
