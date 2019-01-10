package com.example.demo.util;

import org.springframework.stereotype.Component;

@Component
public class ComplexCalculation {

    public int division(int a, int b) {
        return (a / b);
    }

    public int multiply(int a, int b) {
        return (a * b);
    }
}