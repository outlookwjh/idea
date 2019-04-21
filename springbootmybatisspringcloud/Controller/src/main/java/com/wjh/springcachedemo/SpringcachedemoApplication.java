package com.wjh.springcachedemo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan("com.wjh")
@EntityScan("com.wjh.commons")
@EnableEurekaClient
@EnableDiscoveryClient
public class SpringcachedemoApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringcachedemoApplication.class, args);
	}

}
