package com.example.demo.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

@Service
public class DemoService {

    private static Logger logger = LoggerFactory.getLogger(DemoService.class);

    public String query(int b){
        logger.info("Hello DemoService query");
        return "success";
    }

    public String update(int c){
        logger.info("Hello DemoService update");
        return "false";
    }
}