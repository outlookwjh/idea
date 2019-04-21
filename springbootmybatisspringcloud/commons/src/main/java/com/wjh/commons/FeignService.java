package com.wjh.commons;

import com.wjh.commons.ResultEntity;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient("CONTROLLER")
public interface FeignService {

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
                               @PathVariable("age") Integer age);


    /**
     * 查找所有记录
     * @return
     */
    @GetMapping("/get")
    public ResultEntity get();

    /**
     * 查找一条数据
     * @param id
     * @return
     */
    @GetMapping("/get/{id}")
    public ResultEntity findOne(@PathVariable("id") int id);

    @GetMapping("/update/{id}/{name}/{age}")
    public ResultEntity update(@PathVariable("id") Integer id,
                               @PathVariable("name") String name,
                               @PathVariable("age") Integer age);

    @GetMapping("/delete/{id}")
    public ResultEntity delete(@PathVariable("id") Integer id);


}
