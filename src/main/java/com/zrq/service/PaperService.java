package com.zrq.service;

import com.zrq.dao.PaperDao;
import com.zrq.entity.*;
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

    public List<MyPaper> findAllMyScored(Integer userid){
//        System.out.println("findAll");
        return paperDao.findAllMyScored(userid);
    }

    public List<Paper> findAllmy(Integer userid){
//        System.out.println("findAll");
        return paperDao.findAllmy(userid);
    }

    public List<User> findAllStudentByPaper(Integer paperid){
        return paperDao.findAllStudentByPaper(paperid);
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
