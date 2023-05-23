package com.zrq.entity;

import org.springframework.format.annotation.DateTimeFormat;

/**
 * Created by hyx on 2023.
 * 试卷类
 */

public class SelectAnswer {
    private int id;
    private int studentid;
    private int paperid;
    private int questionid;
    private Integer answer;



    public SelectAnswer() {}
    public int getId(){return id;}
    public int getStudentId(){return studentid;}
    public void setStudentId(Integer i){studentid = i;}
    public int getPaperId(){return paperid;}
    public void setPaperId(Integer i){paperid = i;}
    public int getQuestionId(){return questionid;}
    public void setQuestionId(Integer i){questionid = i;}
    public int getAnswer(){return answer;}
    public void setAnswer(Integer i){answer = i;}

}
