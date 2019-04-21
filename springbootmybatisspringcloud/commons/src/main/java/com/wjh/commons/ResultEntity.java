package com.wjh.commons;

import lombok.Data;
import lombok.ToString;

import java.io.Serializable;
import java.util.List;
@ToString
@Data
public class ResultEntity implements Serializable{

    private String msg;

    private boolean issuccess;

    private List<SpringCache> sc;



    public ResultEntity(String msg, boolean issuccess, List<SpringCache> sc) {
        this.msg = msg;
        this.issuccess = issuccess;
        this.sc = sc;
    }

    public ResultEntity(String msg, boolean issuccess) {
        this.msg = msg;
        this.issuccess = issuccess;
    }

    public ResultEntity() {
    }
}
