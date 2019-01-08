package com.example.demo;

import com.example.demo.util.ComplexCalculation;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class ComplexCalculationTest {

    @Autowired
    ComplexCalculation cc;

    @Test
    public void DivisionTest() {

        int c = cc.Division(100, 5);

        Assert.assertEquals(20, c);
    }

    @Test
    public void MultiplyTest() {

        int c = cc.Multiply(100, 5);

        Assert.assertEquals(500, c);
    }
}