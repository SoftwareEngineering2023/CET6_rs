package com.zrq.entity;

import com.zrq.entity.examinee.Examinee;

/**
 * Created by zrq on 2018-5-2.
 */
public class MyPaper {
    private Integer id;
    private Integer userid;
    private Integer paperid;
    private Integer score;
//    private Integer time;
//    private String examNum;
//    private String roomNum;
//    private Address address;
    private Integer pay = 0;

    private Integer outed = 0;

    public MyPaper() {
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getUser() {
        return userid;
    }

    public void setUser(Integer user) {
        this.userid = user;
    }

    public Integer getPaperid() {
        return paperid;
    }

    public void setPaperid(Integer pid) {
        this.paperid = pid;
    }

    public Integer getScore() {
        return score;
    }

    public void setScore(Integer score) {
        this.score = score;
    }

//    public Integer getTime() {
//        return time;
//    }
//
//    public void setTime(Integer time) {
//        this.time = time;
//    }

//    public String getExamNum() {
//        return examNum;
//    }
//
//    public void setExamNum(String examNum) {
//        this.examNum = examNum;
//    }
//
//    public String getRoomNum() {
//        return roomNum;
//    }
//
//    public void setRoomNum(String roomNum) {
//        this.roomNum = roomNum;
//    }

//    public Address getAddress() {
//        return address;
//    }
//
//    public void setAddress(Address address) {
//        this.address = address;
//    }

    public Integer getPay() {
        return pay;
    }

    public void setPay(Integer pay) {
        this.pay = pay;
    }

    public Integer getOuted() {
        return outed;
    }

    public void setOuted(Integer outed) {
        this.outed = outed;
    }
}
