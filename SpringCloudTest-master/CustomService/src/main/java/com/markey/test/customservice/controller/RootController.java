package com.markey.test.customservice.controller;

import com.markey.test.customservice.api.AuthenticationServiceApi;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class RootController {

    @Autowired
    AuthenticationServiceApi authenticationServiceApi;

    @GetMapping("/hello")
    public String hello() {
        //调用服务提供者的接口
        return "hello, " + authenticationServiceApi.getUser();
    }
}
