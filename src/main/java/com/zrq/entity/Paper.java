package com.zrq.entity;

import org.springframework.format.annotation.DateTimeFormat;

import java.util.Date;

/**
 * Created by hyx on 2023.
 * 试卷类
 */

public class Paper {
    private Integer num;
    private String name;
    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private Date time;

    private int user_id;//出卷人
    private int exam_id;

    public Integer getId(){return num;}
    public String getName(){return name;}
    public Integer getUserId(){return user_id;}
    public Integer getExamId(){return exam_id;}

}
