package com.zrq.dao;

import com.zrq.entity.Paper;
import com.zrq.entity.Statistics;
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
}
