package com.zrq.dao;

import com.zrq.entity.*;
import org.apache.ibatis.annotations.*;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

import java.util.List;

public interface AnswerDao {
    /**
     * 查询所有试卷
     * @return 试卷列表
     */
//    @Select("select * from selectquestions")
//    public List<SelectQuestion> findAllSelect();
//
//    @Select("select * from fillquestions")
//    public List<FillQuestion> findAllFill();

    @Select("select * from selectanswers where studentid=#{userid}")
    public List<SelectAnswer> findSelectByUser(Integer userid);

    @Select("select * from fillquestions where paperid=#{paperid}")
    public List<FillAnswer> findFillByUser(Integer paperid);

    /**
     * 根据id更新考试信息
     * @param paper
     * @return
     */
//    @Update("update paper set name=#{name},time=#{time} where id=#{id}")
//    public int updatePaper(Paper paper);

    /**
     * 新增考试信息
     * @param question
     * @return
     */
    @Insert("insert selectanswers(paperid, studentid,  questionid, answer) values(#{paperid}, #{studentid}, #{questionid},#{answer})")
    @Options(useGeneratedKeys=true, keyProperty="id", keyColumn="id")
    public int saveSelect(SelectAnswer selectanswers);

//    @Insert("insert fillquestions(paperid, question, answer) values(#{paperid}, #{question},#{answer})")
//    @Options(useGeneratedKeys=true, keyProperty="id", keyColumn="id")
//    public int saveFill(FillQuestion fillquestions);

//    @Select("select * from paper where id=#{id}")
//    public Paper findById(Integer id);
}
