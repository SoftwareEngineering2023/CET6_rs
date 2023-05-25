package com.zrq.entity;

import org.springframework.format.annotation.DateTimeFormat;

/**
 * Created by hyx on 2023.
 * 试卷类
 */

public class SelectQuestion {
    private int id;
    private int paperid;
    private String question;
    private Integer answer;
    private String selectA;
    private String selectB;
    private String selectC;
    private String selectD;



    public SelectQuestion() {}
    public int getId(){return id;}
    public void setPaper(Integer pid){paperid=pid;}
    public String getQuestion(){return question;}
    public void setQuestion(String question_){question=question_;}
    public Integer getAnswer(){return answer;}
    public void setAnswer(Integer answer_){answer=answer_;}
    public String getSelectA(){return selectA;}
    public void setA(String A){selectA=A;}
    public String getSelectB(){return selectB;}
    public void setB(String B){selectB=B;}
    public String getSelectC(){return selectC;}
    public void setC(String C){selectC=C;}
    public String getSelectD(){return selectD;}
    public void setD(String D){selectD=D;}

}
