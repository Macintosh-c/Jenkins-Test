package com.example.demo;

import com.example.demo.service.DockerService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class DockerServiceTest {

    @Autowired
    DockerService dockerService;

    @Test
    public void queryTest() {
        dockerService.query(3);
    }

    @Test
    public void updateTest() {
        dockerService.update(4);
    }
}