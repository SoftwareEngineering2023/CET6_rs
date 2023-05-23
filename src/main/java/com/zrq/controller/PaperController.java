package com.zrq.controller;

import com.zrq.entity.*;
import com.zrq.service.PaperService;
import com.zrq.service.QuestionService;
import com.zrq.util.PageBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import java.util.List;
import java.util.Map;

/**
 * Created by hyx on 2023-5-18.
 */
@Controller
@RequestMapping("paper")
public class PaperController extends BaseController{
    @Autowired
    private PaperService paperService;
    @Autowired
    private QuestionService questionService;

    @RequestMapping("paperList")
    @ResponseBody
    public List<Paper> paperList(){
        List<Paper> paperList=paperService.findAll();
        return paperList;
    }

    @RequestMapping("sqList")
    @ResponseBody
    public List<SelectQuestion> sqList(HttpServletRequest request){
        Paper paper = (Paper)(request.getSession().getAttribute("currentAnswerPaper"));
        List<SelectQuestion> sqlist = questionService.findSelectByPaper(paper.getId());
        request.getSession().setAttribute("sqlength",sqlist.size());
        System.out.println("sqlist???");
        System.out.println(sqlist.size());
        return sqlist;
    }
    @RequestMapping("fqList")
    @ResponseBody
    public List<FillQuestion> fqList(HttpServletRequest request){
        Paper paper = (Paper)(request.getSession().getAttribute("currentAnswerPaper"));
        List<FillQuestion> fqlist = questionService.findFillByPaper(paper.getId());
        request.getSession().setAttribute("fqlength",fqlist.size());
        System.out.println("fqlist???");
        System.out.println(fqlist.size());
        return fqlist;
    }

    @RequestMapping("list")
    public String list(){
//        PageBean<Exam> examPage=paperService.findByPage(Integer.parseInt(currentPage),pageSize);
//        System.out.println("pageSize:"+examPage.getTotalNum()+currentPage.toString()+pageSize);
//        System.out.println("pageSize:"+examPage.getItems().get(1).getName());
//        map.put("examPage",examPage);
        return "paper-list";
    }

}
