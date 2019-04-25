package com.markey.test.customservice.api;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;

@FeignClient(value = "AuthenticationService")
@Service
public interface AuthenticationServiceApi {

    @GetMapping("/user")
    String getUser();
}
