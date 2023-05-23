package com.zrq.entity;

import org.springframework.format.annotation.DateTimeFormat;

/**
 * Created by hyx on 2023.
 * 试卷类
 */

public class FillAnswer {
    private int id;
    private int studentid;
    private int paperid;
    private int questionid;
    private String answer;



    public FillAnswer() {}
    public int getId(){return id;}
    public int getStudentId(){return studentid;}
    public void setStudentId(Integer i){studentid = i;}
    public int getPaperId(){return paperid;}
    public void setPaperId(Integer i){paperid = i;}
    public int getQuestionId(){return questionid;}
    public void setQuestionId(Integer i){questionid = i;}
    public String getAnswer(){return answer;}
    public void setAnswer(String i){answer = i;}

}
