package com.zrq.dao;

import com.zrq.entity.Exam;
import com.zrq.entity.Paper;
import com.zrq.entity.SelectQuestion;
import com.zrq.entity.FillQuestion;
import com.zrq.entity.Statistics;
import org.apache.ibatis.annotations.*;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

import java.util.List;

public interface QuestionDao {
    /**
     * 查询所有试卷
     * @return 试卷列表
     */
    @Select("select * from selectquestions")
    public List<SelectQuestion> findAllSelect();

    @Select("select * from fillquestions")
    public List<FillQuestion> findAllFill();

    @Select("select * from selectquestions where paperid=#{paperid}")
    public List<SelectQuestion> findSelectByPaper(Integer paperid);

    @Select("select * from fillquestions where paperid=#{paperid}")
    public List<FillQuestion> findFillByPaper(Integer paperid);

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
    @Insert("insert selectquestions(paperid, question,  answer, selectA, selectB, selectC, selectD) values(#{paperid}, #{question},#{answer},#{selectA},#{selectB},#{selectC},#{selectD})")
    @Options(useGeneratedKeys=true, keyProperty="id", keyColumn="id")
    public int saveSelect(SelectQuestion selectquestions);

    @Insert("insert fillquestions(paperid, question, answer) values(#{paperid}, #{question},#{answer})")
    @Options(useGeneratedKeys=true, keyProperty="id", keyColumn="id")
    public int saveFill(FillQuestion fillquestions);

//    @Select("select * from paper where id=#{id}")
//    public Paper findById(Integer id);
}
