package com.zrq.controller;

import com.zrq.entity.*;
import com.zrq.service.AnswerService;
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

    @Autowired
    private AnswerService answerService;

    @RequestMapping("paperList")
    @ResponseBody
    public List<Paper> paperList(){
        List<Paper> paperList=paperService.findAll();
        return paperList;
    }

    @RequestMapping("mypaperList")
    @ResponseBody
    public List<Paper> mypaperList(HttpServletRequest request){
        System.out.println("mypaperList???");
        User user = (User)(request.getSession().getAttribute("user"));
        System.out.println(user.getId());
        List<Paper> paperList=paperService.findAllmy(user.getId());
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

    @RequestMapping("saList")
    @ResponseBody
    public float saList(HttpServletRequest request){
        //实现选择题数据库自动判分
//        System.out.println("saList???");
        Paper paper = (Paper)(request.getSession().getAttribute("gradePaper"));
        User user = (User)(request.getSession().getAttribute("gradeUser"));
//        System.out.println(paper.getId());
//        System.out.println(user.getId());
        List<SelectAnswer> salist = answerService.findSelectByUserAndPaper(user.getId(), paper.getId());
//        request.getSession().setAttribute("salength",salist.size());

        List<SelectAnswer> saCorrectlist = answerService.findCorrectSelectByUserAndPaper(user.getId(), paper.getId());
//        request.getSession().setAttribute("salength",salist.size());
//        System.out.println(user.getId());
//        System.out.println(paper.getId());
        System.out.println(saCorrectlist.size());
        System.out.println(salist.size());
        float score = (float)saCorrectlist.size()/(float)salist.size()*(float)40;
        System.out.println(score);
        request.getSession().setAttribute("selectScore",score);

        System.out.println("sqlist???");
//        System.out.println(sqlist.size());
        return score;
    }
    @RequestMapping("faList")
    @ResponseBody
    public List<FillAnswer> faList(HttpServletRequest request){
        System.out.println("faList???");
        Paper paper = (Paper)(request.getSession().getAttribute("gradePaper"));
        User user = (User)(request.getSession().getAttribute("gradeUser"));
        List<FillAnswer> falist = answerService.findFillByUserAndPaper(user.getId(), paper.getId());
        request.getSession().setAttribute("falength",falist.size());
//        System.out.println("sqlist???");
//        System.out.println(sqlist.size());
        return falist;
    }

    @RequestMapping("list")
    public String list(){
//        PageBean<Exam> examPage=paperService.findByPage(Integer.parseInt(currentPage),pageSize);
//        System.out.println("pageSize:"+examPage.getTotalNum()+currentPage.toString()+pageSize);
//        System.out.println("pageSize:"+examPage.getItems().get(1).getName());
//        map.put("examPage",examPage);
        return "paper-list";
    }

    @RequestMapping("signup")
    public String signup(HttpServletRequest request,@RequestParam("id") Integer id,
                         Map<String,Object> map){
        System.out.println("xxx"+id);
        Paper currentPaper=paperService.findById(id);
        request.getSession().setAttribute("currentPaper",currentPaper);
        map.put("currentPaper",currentPaper);
        return "signup";
    }

}
