package com.wjh.consumer.controller;

import com.wjh.commons.FeignService;
import com.wjh.commons.ResultEntity;
import org.slf4j.LoggerFactory;
import org.slf4j.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
@RequestMapping("/consumer")
public class consumerController {
    /**
    @Autowired
    private RestTemplate restTemplate;


    private static  final String url="http://CONTROLLER";


    @GetMapping("/resttemp/get")
    public String resttemp(){

        return restTemplate.getForObject(url+"/user/get",String.class);

    }

    @GetMapping("/resttemp/insert/{id}/{name}/{age}")
    public String resttemp1(@PathVariable("id") int id,
                            @PathVariable("name") String name,
                            @PathVariable("age") int age){

        return restTemplate.getForObject(url+"/user/insert/"+id+"/"+name+"/"+age,String.class);

    }
     **/


    @Autowired
    private FeignService client;

    @GetMapping("/resttemp/get")
    public ResultEntity resttemp(){



        ResultEntity resultEntity = client.get();
        return resultEntity;

    }

    @GetMapping("/test")
    public String test(){

        return "helloword";

    }

}
