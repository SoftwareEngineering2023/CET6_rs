package com.zrq.service;

import com.github.pagehelper.PageHelper;
import com.zrq.dao.PaperDao;
import com.zrq.entity.Exam;
import com.zrq.entity.Paper;
import com.zrq.entity.Statistics;
import com.zrq.util.PageBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class PaperService {
    @Autowired
    private PaperDao paperDao;

    public List<Paper> findAll(){
//        System.out.println("findAll");
        return paperDao.findAll();
    }
}
