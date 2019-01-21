package com.example.demo.controller;

import com.example.demo.entity.AccountInfo;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api")
public class DockerController {

    private static Logger logger = LoggerFactory.getLogger(DockerController.class);
    @PostMapping("/docker")
    public String account(){
        logger.info("Hello Docker World");
        return "Hello Docker World";
    }

    @PostMapping("/jenkins")
    public AccountInfo accountQuery(@RequestBody AccountInfo accountInfo){
        logger.info("Hello jenkins World:{}",accountInfo.getName());
        return accountInfo;
    }
    @PostMapping("/test")
    public AccountInfo test(@RequestBody AccountInfo accountInfo){
        logger.info("Hello test World:{}",accountInfo.getName());
        return accountInfo;
    }
    @PostMapping("/haha")
    public AccountInfo haha(@RequestBody AccountInfo accountInfo){
        logger.info("Hello haha World:{}",accountInfo.getName());
        return accountInfo;
    }
}