package com.wjh.springcachedemo.service;

import com.wjh.commons.SpringCache;
import com.wjh.springcachedemo.respository.Dao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class UserService {
    @Autowired
    private Dao dao;
    @Autowired
    private RedisTemplate redisTemplate;

    //@CachePut(key = "#sc.getId()",value ="sc" )
    public void insert(SpringCache sc){

        dao.insert(sc);

        redisTemplate.opsForValue().set(sc.getId(),sc);

    }

    public List<SpringCache> get(){

        List<SpringCache> list = dao.get();

        return list;
    }

    //@Cacheable(key = "#sc.getId()",value ="sc" )
    public SpringCache findById(SpringCache sc){

        //先从redis查，如果没有就从数据库查
        int id = sc.getId();
       SpringCache springCache= (SpringCache) redisTemplate.opsForValue().get(sc.getId());
        if (springCache!=null){
            return springCache;
        }
        return dao.findById(sc);

    }

    public void update(SpringCache sc){
        dao.update(sc);
    }

    public void delete(SpringCache sc){
        dao.delete(sc);
    }

}
