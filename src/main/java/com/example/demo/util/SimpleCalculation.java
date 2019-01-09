package com.example.demo.util;

import org.springframework.stereotype.Component;

@Component
public class SimpleCalculation {
    public int add(int a, int b) {
        return (a + b);
    }

    public int subtration(int a, int b) {
        return (a - b);
    }
}