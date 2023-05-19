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

    /**
     * 根据id更新考试信息
     * @param paper
     * @return
     */
    public int updatePaper(Paper paper) {
        return paperDao.updatePaper(paper);
    }

    public int savePaper(Paper paper) {
        return paperDao.savePaper(paper);
    }

    public Paper findById(Integer id){
        return paperDao.findById(id);
    }
}
