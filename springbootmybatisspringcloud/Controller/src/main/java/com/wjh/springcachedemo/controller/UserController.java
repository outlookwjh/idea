package com.wjh.springcachedemo.controller;

import com.wjh.commons.ResultEntity;
import com.wjh.commons.SpringCache;
import com.wjh.openinterface.Userinterface;
import com.wjh.springcachedemo.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@Controller
@ResponseBody
@RequestMapping("/user")
public class UserController implements Userinterface {

    @Autowired
    private UserService userService;
    @Value("${server.port}")
    private String port;
    /**
     * 插入一条数据
     * @param id
     * @param name
     * @param age
     * @return
     */
    @GetMapping("/insert/{id}/{name}/{age}")
    public ResultEntity insert(@PathVariable("id") Integer id,
                               @PathVariable("name") String name,
                               @PathVariable("age") Integer age){

        SpringCache sc=new SpringCache();
        sc.setId(id);
        sc.setName(name);
        sc.setAge(age);
        try {
            userService.insert(sc);
            return new ResultEntity("插入数据库成功！"+port,true);
        }catch (Exception e){
            return new ResultEntity("插入数据库失败！"+port,true);
        }
    }

    /**
     * 查找所有记录
     * @return
     */
    @GetMapping("/get")
    public ResultEntity get(){

        ResultEntity re=new ResultEntity();

        try {
            List<SpringCache> list=userService.get();
            re.setIssuccess(true);
            re.setMsg("查询数据成功"+port);
            re.setSc(list);
        }catch (Exception e){
            re.setMsg("查询数据失败"+port);
            re.setIssuccess(false);
            re.setSc(null);
        }

        return  re;
    }

    /**
     * 查找一条数据
     * @param id
     * @return
     */
    @GetMapping("/get/{id}")
    public ResultEntity findOne(@PathVariable("id") int id){

        SpringCache springCache = new SpringCache();
        springCache.setId(id);
        List<SpringCache> list=new ArrayList<>();

        ResultEntity re=new ResultEntity();

        try {
            SpringCache sc=userService.findById(springCache);
            list.add(sc);
            re.setIssuccess(true);
            re.setMsg("查找一条数据成功");
            re.setSc(list);
        }catch (Exception e){
            re.setMsg("查询一条数据失败");
            re.setIssuccess(false);
            re.setSc(null);
        }

        return  re;
    }

    @GetMapping("/update/{id}/{name}/{age}")
    public ResultEntity update(@PathVariable("id") Integer id,
                               @PathVariable("name") String name,
                               @PathVariable("age") Integer age){
        SpringCache sc=new SpringCache();
        sc.setId(id);
        sc.setName(name);
        sc.setAge(age);

        try {
            userService.update(sc);
            return new ResultEntity("修改成功",true);
        }catch (Exception e){
            return new ResultEntity("修改成功",true);
        }
    }

    @GetMapping("/delete/{id}")
    public ResultEntity delete(@PathVariable("id") Integer id){
        SpringCache sc=new SpringCache();
        sc.setId(id);

        try {
            userService.delete(sc);
            return new ResultEntity("修改成功",true);
        }catch (Exception e){
            return new ResultEntity("修改成功",true);
        }
    }
}
