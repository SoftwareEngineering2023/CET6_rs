package com.zrq.controller.examinee;

import com.zrq.controller.BaseController;
import com.zrq.entity.*;
import com.zrq.entity.examinee.Examinee;
import com.zrq.service.AnswerService;
import com.zrq.service.ExamService;
import com.zrq.service.PaperService;
import com.zrq.service.examinee.ExamineeService;
import com.zrq.util.StringUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpServletRequest;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

/**
 * Created by zrq on 2018-4-18.
 */
@Controller
@RequestMapping("/examinee")//考生 用户模式下
public class ExamineeController extends BaseController{
    @Autowired
    private ExamineeService examineeService;
    @Autowired
    private ExamService examService;
    @Autowired
    private PaperService paperService;
    @Autowired
    private AnswerService answerService;
    /**
     * 显示个人列表，无用
     * @param map
     * @return
     */
    @RequestMapping("/list")
    public String findAll(Map<String,Object> map){
        List<Examinee> list=examineeService.findAll();
        String examString="";
        for (Examinee e:list) {
            examString+=e.getId()+e.getUsername()+"\n";
        }
        map.put("hello",examString);
        return "admin/index";
    }

    /**
     * 跳转到个人信息页面
     * myInfo:查看个人信息页面
     * confirmInfo:信息确认逻辑
     * cancelInfo：撤销信息修改逻辑
     * @return
     */
    @RequestMapping({"myInfo","confirmInfo","cancelInfo"})
    public  String confirmInfo(){
        return "my-info";
    }

    /**
     * 参与考试
     * @param request
     * @return
     */
    @RequestMapping("joinExam")
    public  String joinExam(HttpServletRequest request){
        Integer id=((Exam)request.getSession().getAttribute("currentExam")).getId();
        Integer userId=((User)request.getSession().getAttribute("user")).getId();
        if(examineeService.insertExam(userId,id)>0)
            return "paypage";
        return "my-info";
    }
    @RequestMapping("joinPaper")
    public  String joinPaper(HttpServletRequest request){
        Integer paperid=((Paper)request.getSession().getAttribute("currentPaper")).getId();
        Integer userid=((User)request.getSession().getAttribute("user")).getId();
        if(examineeService.insertMyPaper(userid,paperid)>0)
            return "paypage";
        return "my-info";
    }

    /**
     * 跳转到更新个人信息页面
     * @return
     */
    @RequestMapping("updateInfo")
    public  String updateInfo(){return "update-info";}

    /**
     * 保存个人信息，并跳转到相应页面
     * 当前考试存在继续确认页面即个人信息页
     * 不存在跳到个人信息页
     * @return
     */
    @RequestMapping("saveInfo")
    public  String saveInfo(HttpServletRequest request,User user){
        //此处书写保存个人信息代码，不需要判断当前考试是否存在
        user.setId(((User)request.getSession().getAttribute("user")).getId());
        if(examineeService.updateUser(user)>0){
            User newUser=examineeService.findUserById(user.getId());
//            request.getSession().removeAttribute("user");
            request.getSession().setAttribute("user",newUser);
        }
        return "my-info";
    }

    /**
     * 支付考试
     * @param request
     * @param map
     * @return
     */
//    @RequestMapping("pay")
//    public  String pay(HttpServletRequest request,Map<String,Object> map){
//        Exam exam=(Exam)request.getSession().getAttribute("currentExam");
//        Integer userId=((User)request.getSession().getAttribute("user")).getId();
//        if(exam!=null) {//当前考试存在则跳转相关信息，不存在则返回考试列表页面
//            MyExam myExam=examineeService.payByUserAndExam(userId,exam.getId());
//            List<MyExam> l=new ArrayList<MyExam>();
//            l.add(myExam);
//            map.put("myExam",l);
////            System.out.println("pay-myexam:"+l.get(0).getPay());
//            request.getSession().removeAttribute("currentExam");
//            return "my-exam";
//        }
//        return "my-exam";
//    }
    @RequestMapping("pay")
    public  String pay(HttpServletRequest request,Map<String,Object> map){
        Paper paper=(Paper)request.getSession().getAttribute("currentPaper");
        Integer userId=((User)request.getSession().getAttribute("user")).getId();
        if(paper!=null) {//当前考试存在则跳转相关信息，不存在则返回考试列表页面
            MyPaper myPaper=examineeService.payByUserAndPaper(userId,paper.getId());
            List<MyPaper> l=new ArrayList<MyPaper>();
            l.add(myPaper);
            map.put("myPaper",l);
            System.out.println("pay-mypaper:"+l.get(0).getPay());
            request.getSession().removeAttribute("currentPaper");
            return "my-paper";
        }
        return "my-paper";
    }

    /**
     * 继续支付
     * 跳转到支付考试页面
     * @param request
     * @param map
     * @return
     */
    @RequestMapping("continuePay")
    public  String pay(HttpServletRequest request,Map<String,Object> map,
                       @RequestParam(name = "id")Integer id){
        Exam exam=examService.findById(id);
        request.getSession().setAttribute("currentExam",exam);
        System.out.println("continuePayId:"+id);
        return "paypage";
    }

    /**
     *
     * @param request
     * @param map
     * @param pay 是否支付,0未支付，1支付
     * @param examed 是否考试，有参数即代表已考试
     * @return
     */
    @RequestMapping("examList")
    public  String examList(HttpServletRequest request,
                            Map<String,Object> map,
                            @RequestParam(name="pay",required = false) Integer pay,
                            @RequestParam(name = "examed",required = false) Integer examed){
        Integer userId=((User)request.getSession().getAttribute("user")).getId();
        if(pay==0||pay==1){
            List<MyExam> myExam=(List<MyExam>)request.getAttribute("myExam");
            if(examed!=null){
                myExam=examineeService.findByUserAndExamed(userId);
            }else {
                myExam=examineeService.findByUserAndPay(userId,pay);
            }
            map.put("myExam",myExam);
        }
        return "my-exam";
    }

    /**
     * 跳转考试查询页面
     * @param request
     * @param map
     * @return
     */
    @RequestMapping("score")
    public  String score(HttpServletRequest request,Map<String,Object> map,
                         @RequestParam(name = "id",required = false) Integer id){
        Integer userId=((User)request.getSession().getAttribute("user")).getId();
        List<MyExam> myExam=null;
        if(id!=null){
            //考试id存在查询单条考试所有记录
            if(id==0){//id=0查询所有
                myExam=examineeService.findByUserAndExamed(userId);
            }else {
                myExam = examineeService.findOneByUserAndExamed(userId, id);
            }
            map.put("myExam",myExam);//用传递的参数不同控制页面是否显示搜索框
        }else{
            //考试id存在查询所有考试记录
            myExam=examineeService.findByUserAndExamed(userId);
            Map<Integer,String> search=new TreeMap<Integer,String>();
            for (MyExam e:myExam){
                search.put(e.getExam().getId(),e.getExam().getName());
            }
            map.put("search",search);
        }
        return "score";
    }
    //试卷列表
    @RequestMapping("paperlist")
    public  String paperlist(HttpServletRequest request,Map<String,Object> map,
                         @RequestParam(name = "id",required = false) Integer id){
//        System.out.println("userid???");
//        System.out.println(id);
        User examinee=examineeService.findUserById(id);
        request.getSession().setAttribute("currentExaminee",examinee);
        map.put("currentExaminee",examinee);
        return "e-paperlist";
    }

    //开始答卷
    @RequestMapping("answer")
    public String paper(HttpServletRequest request,@RequestParam("paperid")Integer paperid, Map<String,Object> map){
        Paper paper=paperService.findById(paperid);
        request.getSession().setAttribute("currentAnswerPaper",paper);
        User examinee=(User)(request.getSession().getAttribute("currentExaminee"));
//        System.out.println("userid???");
//        System.out.println(examinee.getId());
        map.put("currentAnswerPaper",paper);
        return "answersheet";
    }

    @RequestMapping("saveSelectAnswer")
    public String saveSelectQuestion(HttpServletRequest request) {
//        System.out.println("qlength???");
//        System.out.println(request.getSession().getAttribute("sqlength"));
//        System.out.println("fqid1???");
//        System.out.println(request.getParameter("fqid1"));
//        System.out.println("fanswer1???");
//        System.out.println(request.getParameter("fanswer1"));

        Paper paper = (Paper)(request.getSession().getAttribute("currentAnswerPaper"));
//        paper.setOuted();//paper对该学生置为失效
        int paperid = paper.getId();
        User examinee = (User)(request.getSession().getAttribute("currentExaminee"));
        int eid = examinee.getId();

        //处理选择题
        int sqlength = (int)(request.getSession().getAttribute("sqlength"));

        for(int i=1;i<sqlength+1;i++){
            String sanswer_name = ("sanswer"+i);
            String sqid_name = ("sqid"+i);
            System.out.println(sanswer_name);
            System.out.println(sqid_name);
            int sanswer = Integer.parseInt(request.getParameter(sanswer_name));
            int sqid = Integer.parseInt(request.getParameter(sqid_name));

            //插入答案
            SelectAnswer sa = new SelectAnswer();
            sa.setPaperId(paperid);
            sa.setStudentId(eid);
            sa.setQuestionId(sqid);
            sa.setAnswer(sanswer);

            answerService.saveSelect(sa);
        }
        //处理填空题
        int fqlength = (int)(request.getSession().getAttribute("fqlength"));

        for(int i=1;i<fqlength+1;i++){
            String fanswer_name = ("fanswer"+i);
            String fqid_name = ("fqid"+i);
//            System.out.println(fanswer_name);
//            System.out.println(fqid_name);
            String fanswer = request.getParameter(fanswer_name);
            int fqid = Integer.parseInt(request.getParameter(fqid_name));

            //插入答案
            FillAnswer fa = new FillAnswer();
            fa.setPaperId(paperid);
            fa.setStudentId(eid);
            fa.setQuestionId(fqid);
            fa.setAnswer(fanswer);

            answerService.saveFill(fa);
        }
        return "paperlist";
    }

    /**
     * 返回任何路径对应页面
     * 如果未定义方法会默认使用该方法
     * 若是定义了跳转方法会优先使用已定义的
     * @param url
     * @return
     */
    @RequestMapping("{url}")
    public String viewDistribute(@PathVariable("url")String url){
        url= StringUtil.humpToLine(url);//驼峰法与横线转换
        System.out.println("MyPagedefault-all:"+url);
        return url;
    }
}
