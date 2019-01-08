package com.example.demo;

import com.example.demo.util.SimpleCalculation;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class SimpleCalculationTest {

    @Autowired
    SimpleCalculation sc;

    @Test
    public void AddTest() {

        int c = sc.Add(3, 5);

        Assert.assertEquals(8, c);
    }

    @Test
    public void SubtrationTest() {

        int c = sc.Subtration(20, 5);

        Assert.assertEquals(15, c);
    }
}