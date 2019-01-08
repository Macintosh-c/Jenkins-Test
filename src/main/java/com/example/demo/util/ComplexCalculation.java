package com.example.demo.util;

import org.springframework.stereotype.Component;

@Component
public class ComplexCalculation {

    public int Division(int a,int b){
        return (a/b);
    }

    public int Multiply(int a,int b){
        return (a*b);
    }
}