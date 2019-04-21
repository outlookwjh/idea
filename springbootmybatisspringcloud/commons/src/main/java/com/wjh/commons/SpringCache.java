package com.wjh.commons;


import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import java.io.Serializable;
@ToString
@Data
@NoArgsConstructor
public class SpringCache implements Serializable{
    int id;
    String name;
    int age;


}
