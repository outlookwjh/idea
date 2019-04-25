package com.wjh.openinterface;

import com.wjh.commons.ResultEntity;
import io.swagger.annotations.Api;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;

@Api(value="cms页面管理接口",description="cms页面管理接口，提供页面的增、删、改、查")
@FeignClient("controller")
@Service
public interface Userinterface {


    /**
     * 插入一条数据
     * @param id
     * @param name
     * @param age
     * @return
     */

    public ResultEntity insert(Integer id,
                               String name,
                               Integer age);

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

    public ResultEntity findOne( int id);


    public ResultEntity update( Integer id,
                                String name,
                                Integer age);


    public ResultEntity delete( Integer id);



}
