package com.zrq.dao;

import com.zrq.entity.*;
import org.apache.ibatis.annotations.*;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

import java.util.List;

public interface PaperDao {
    /**
     * 查询所有试卷
     * @return 试卷列表
     */
    @Select("select * from paper")
    public List<Paper> findAll();

    @Select("select * from paper, mypaper where paper.id=mypaper.paperid and userid = #{userid} and mypaper.outed=0")
    public List<Paper> findAllmy(Integer userid);

    @Select("select * from paper, mypaper where paper.id=mypaper.paperid and userid = #{userid} and mypaper.outed=1 and score is not NULL")
    public List<MyPaper> findAllMyScored(Integer userid);

    /**
     * 根据id更新考试信息
     * @param paper
     * @return
     */
    @Update("update paper set name=#{name},time=#{time} where id=#{id}")
    public int updatePaper(Paper paper);

    /**
     * 新增考试信息
     * @param paper
     * @return
     */
    @Insert("insert paper(name,user_name,time) values(#{name},#{user_name},#{time})")
    @Options(useGeneratedKeys=true, keyProperty="id", keyColumn="id")
    public int savePaper(Paper paper);

    @Select("select * from paper where id=#{id}")
    public Paper findById(Integer id);

    @Select("select * from user,mypaper where mypaper.userid=user.id and mypaper.paperid=#{paperid} and score is NULL")
    public List<User> findAllStudentByPaper(Integer paperid);

//    @Update("update mypaper set score=#{score} where userid=#{userid} and paperid=#{paperid} and questionid=#{questionid}")
//    public void setFillScore(Integer userid, Integer paperid, Integer questionid, Integer score);

}
