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

    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private Date time;

    private String user_name;//出卷人

    private int outed=0;


    public Paper() {}
    public Integer getId(){return id;}
    public void setId(Integer id_){id=id_;}
    public String getName(){return name;}
    public void setName(String name_){name=name_;}
    public String getUser_name(){return user_name;}
    public void setUser(String user_name_){user_name=user_name_;}
    public Date getTime(){return time;}
    public void setTime(Date time_){time=time_;}
    public int getOuted(){return outed;}
    public void setOuted(){outed=1;}
}
