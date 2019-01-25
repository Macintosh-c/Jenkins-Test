package com.example.demo.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

@Service
public class DockerService {

    private static Logger logger = LoggerFactory.getLogger(DockerService.class);

    public String query(int d){
        logger.info("Hello DockerService query");
        return "success";
    }

    public String update(int e){
        logger.info("Hello DockerService update");
        return "false";
    }
}