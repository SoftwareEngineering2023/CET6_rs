package com.zrq.service;

import com.github.pagehelper.PageHelper;
import com.zrq.dao.PaperDao;
import com.zrq.dao.QuestionDao;
import com.zrq.entity.Exam;
import com.zrq.entity.Paper;
import com.zrq.entity.SelectQuestion;
import com.zrq.entity.FillQuestion;
import com.zrq.entity.Statistics;
import com.zrq.util.PageBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class QuestionService {
    @Autowired
    private QuestionDao questionDao;

    public List<SelectQuestion> findAllSelect(){
//        System.out.println("findAll");
        return questionDao.findAllSelect();
    }
    public List<FillQuestion> findAllFill(){
//        System.out.println("findAll");
        return questionDao.findAllFill();
    }
    /**
     * 根据id更新考试信息
     * @param paper
     * @return
     */
//    public int updatePaper(Paper paper) {
//        return paperDao.updatePaper(paper);
//    }

    public int saveSelect(SelectQuestion q) {
        return questionDao.saveSelect(q);
    }

    public int saveFill(FillQuestion q) {
        return questionDao.saveFill(q);
    }

//    public Paper findById(Integer id){
//        return paperDao.findById(id);
//    }
}
