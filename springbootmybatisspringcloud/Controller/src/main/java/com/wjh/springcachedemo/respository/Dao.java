package com.wjh.springcachedemo.respository;

import com.wjh.commons.SpringCache;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface Dao {

    /**
     * 插入一条记录
     * @param sc
     */
    public void insert(SpringCache sc);

    /**
     * 查询所有
     * @return
     */
    public List<SpringCache> get();

    /**
     * 修改一条记录
     * @param sc
     */
    public void update(SpringCache sc);

    /**
     * 根据主键查询
     * @param sc
     */
    public SpringCache findById(SpringCache sc);

    /**
     * 删除一条记录
     * @param sc
     */
    public void delete(SpringCache sc);
}
