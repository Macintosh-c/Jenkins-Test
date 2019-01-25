package com.example.demo.dao;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

@Component
public class UserMapper {

    private static Logger logger = LoggerFactory.getLogger(UserMapper.class);
    public String insert(int a){
        logger.info("Hello UserMapper insert");
        return "success";
    }
}