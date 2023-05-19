package com.zrq.controller;

import com.zrq.entity.Exam;
import com.zrq.entity.Paper;
import com.zrq.entity.Statistics;
import com.zrq.service.PaperService;
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

    @RequestMapping("paperList")
    @ResponseBody
    public List<Paper> paperList(){
        List<Paper> paperList=paperService.findAll();
        return paperList;
    }


}
