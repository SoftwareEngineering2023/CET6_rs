package com.zrq.entity;

import org.springframework.format.annotation.DateTimeFormat;

import java.util.Date;

/**
 * Created by hyx on 2023.
 * 试卷类
 */

public class Paper {
    private Integer id;
    private String name;

    private String user_name;//出卷人

    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private Date time;


    public Paper(String n, String un, Date t) {
        name = n;
        user_name = un;
        time = t;
    }
    public Integer getId(){return id;}
    public String getName(){return name;}
    public String getUser(){return user_name;}

}
