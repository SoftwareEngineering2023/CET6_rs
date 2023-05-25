package com.zrq.service;

import com.github.pagehelper.PageHelper;
import com.zrq.dao.PaperDao;
import com.zrq.dao.AnswerDao;
import com.zrq.entity.Exam;
import com.zrq.entity.Paper;
import com.zrq.entity.SelectAnswer;
import com.zrq.entity.FillAnswer;
import com.zrq.entity.Statistics;
import com.zrq.util.PageBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class AnswerService {
    @Autowired
    private AnswerDao answerDao;

//    public List<SelectQuestion> findAllSelect(){
////        System.out.println("findAll");
//        return answerDao.findAllSelect();
//    }
//    public List<FillQuestion> findAllFill(){
////        System.out.println("findAll");
//        return answerDao.findAllFill();
//    }
    /**
     * 根据id更新考试信息
     * @param paper
     * @return
     */
//    public int updatePaper(Paper paper) {
//        return paperDao.updatePaper(paper);
//    }

    public int saveSelect(SelectAnswer a) {
        return answerDao.saveSelect(a);
    }

    public int saveFill(FillAnswer a) {
        return answerDao.saveFill(a);
    }

    public List<SelectAnswer> findSelectByUserAndPaper(Integer userid, Integer paperid) {
        return answerDao.findSelectByUserAndPaper(userid, paperid);
    }
    public List<SelectAnswer> findCorrectSelectByUserAndPaper(Integer userid, Integer paperid) {
        return answerDao.findCorrectSelectByUserAndPaper(userid, paperid);
    }

    public List<FillAnswer> findFillByUserAndPaper(Integer userid, Integer paperid) {
        return answerDao.findFillByUserAndPaper(userid, paperid);
    }

//    public Paper findById(Integer id){
//        return paperDao.findById(id);
//    }
}
