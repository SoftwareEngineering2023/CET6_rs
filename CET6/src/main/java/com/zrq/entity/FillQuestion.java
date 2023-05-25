package com.zrq.entity;

import org.springframework.format.annotation.DateTimeFormat;

/**
 * Created by hyx on 2023.
 * 试卷类
 */

public class FillQuestion {
    private int id;
    private int paperid;
    private String question;
    private String answer;


    public FillQuestion() {}
    public int getId(){return id;}
    public void setPaper(Integer pid){paperid=pid;}
    public String getQuestion(){return question;}
    public void setQuestion(String question_){question=question_;}
    public String getAnswer(){return answer;}
    public void setAnswer(String answer_){answer=answer_;}


}
