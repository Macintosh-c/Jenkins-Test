package com.example.demo.util;

import org.springframework.stereotype.Component;

@Component
public class SimpleCalculation {
    public int Add(int a,int b){
        return (a+b);
    }

    public int Subtration(int a,int b){
        return(a-b);
    }
}