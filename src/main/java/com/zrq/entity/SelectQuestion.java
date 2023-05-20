package com.zrq.entity;

import org.springframework.format.annotation.DateTimeFormat;

/**
 * Created by hyx on 2023.
 * 试卷类
 */

public class SelectQuestion {
    int id;
    int paperid;
    private String question;
    private Integer answer;
    String selectA;
    String selectB;
    String selectC;
    String selectD;


    public void setPaper(Integer pid){paperid=pid;}
    public SelectQuestion() {}
    public String getQuestion(){return question;}
    public void setQuestion(String question_){question=question_;}
    public Integer getAnswer(){return answer;}
    public void setAnswer(Integer answer_){answer=answer_;}
    public void setA(String A){selectA=A;}
    public void setB(String B){selectB=B;}
    public void setC(String C){selectC=C;}
    public void setD(String D){selectD=D;}

}
