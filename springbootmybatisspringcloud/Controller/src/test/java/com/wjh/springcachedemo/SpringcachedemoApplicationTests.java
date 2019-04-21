package com.wjh.springcachedemo;

import com.wjh.commons.SpringCache;
import com.wjh.springcachedemo.respository.Dao;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class SpringcachedemoApplicationTests {

	@Autowired
	Dao dao;

	@Test
	public void contextLoads() {
	}
	@Test
	public void dao() {

		SpringCache springCache = new SpringCache();
		springCache.setId(1);
		springCache.setName("wjh");
		springCache.setAge(20);

		dao.insert(springCache);

	}

}
