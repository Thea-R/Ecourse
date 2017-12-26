package com.ecourse.controller;

import com.ecourse.entity.EcAnswer;
import com.ecourse.entity.EcQuestion;
import com.ecourse.entity.EcUser;
import com.ecourse.service.EcAnswerService;
import com.ecourse.service.EcQuestionService;
import com.ecourse.service.EcUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.persistence.criteria.CriteriaBuilder;
import javax.servlet.http.HttpServletRequest;
import java.math.BigDecimal;
import java.text.SimpleDateFormat;
import java.util.*;

/**
 * Created by zhangyuxuan on 17/12/22.
 */
@Controller
@RequestMapping("/question")
public class EcQuestionController {
    @Autowired
    private EcQuestionService ecQuestionService;
    @Autowired
    private EcAnswerService ecAnswerService;
    @Autowired
    private EcUserService ecUserService;
    private int userId=1;
    private int courseId=1;
    /**
     * 登陆
     *
     * @param map ModelMap
     * @param request 用户名，密码
     * @return 是否登陆成功
     * @throws Exception 异常捕获
     */
    @ResponseBody
    @RequestMapping("/questionList")
    public Map<String, Object> QuestionList(ModelMap map, HttpServletRequest request) throws Exception {
        Map<String, Object> resultMap = new HashMap<String, Object>(16);
        EcUser ecUser=ecUserService.findEcUserById(userId);
        resultMap.put("name",ecUser.getUserName());
        Map<String,Object> map1=new HashMap<String,Object>();
        map1.put("courseId",courseId);
        List<EcQuestion> list1=new ArrayList<EcQuestion>();
        List<Map<String,Object>> list=new ArrayList<Map<String,Object>>();
        try {
            list1 = ecQuestionService.findEcQuestion(map1);
            if(list1.size()!=0){
                SimpleDateFormat sdf= new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");    //long类型转换为字符串
                for(EcQuestion l:list1){
                    Map<String,Object> m1=new HashMap<String, Object>();
                    String str = sdf.format(l.getQueTime());
                    int queid=l.getQueId();
                    m1.put("time",str);
                    m1.put("queid",queid);
                    list.add(m1);
                }
            }
        }catch(Exception e){
        }
        resultMap.put("list",list);
        return resultMap;
    }

    @ResponseBody
    @RequestMapping("/addQuestion")
    public Map<String, Object> AddQuestion(ModelMap map, HttpServletRequest request) throws Exception {
        Map<String, Object> resultMap = new HashMap<String, Object>(16);
        String stype = request.getParameter("type");
        int type=Integer.parseInt(stype);
        String sanswer = request.getParameter("answer");
        int answer=Integer.parseInt(sanswer);
        String anstime = request.getParameter("anstime");
        EcQuestion ecQuestion=new EcQuestion();
        ecQuestion.setCourseId(courseId);
        ecQuestion.setQueType(type);
        ecQuestion.setQueAns(answer);
        ecQuestion.setQueState(1);
        ecQuestion.setQueTitle(anstime);
        ecQuestion.setQueTime(new Date());
        ecQuestionService.saveEcQuestion(ecQuestion);
        //接下来求出最近存储的题的id（id最大值)
        Map<String,Object> map1=new HashMap<String,Object>();
        map1.put("courseId",courseId);
        List<EcQuestion> list1=new ArrayList<EcQuestion>();
        double time=0;
        int id=0;
        try {
            list1 = ecQuestionService.findEcQuestion(map1);
            if(list1.size()!=0){
                Collections.reverse(list1);
                for(EcQuestion q:list1){
                    id=q.getQueId();
                    time=Double.parseDouble(q.getQueTitle());
                    time*=60;
                    break;
                }
            }
        }catch(Exception e){
            System.out.println(e);
        }
        resultMap.put("time",time);
        resultMap.put("res","添加");
        resultMap.put("queid",id);
        return resultMap;
    }

    @ResponseBody
    @RequestMapping("/endQuestion")
    public Map<String, Object> EndQuestion(ModelMap map, HttpServletRequest request) throws Exception {
        Map<String, Object> resultMap = new HashMap<String, Object>(16);
        String squeid = request.getParameter("queid");
        int queid=Integer.parseInt(squeid);
        EcQuestion ecQuestion=ecQuestionService.findEcQuestionById(queid);
        if(ecQuestion.getQueState()==1){
            ecQuestion.setQueState(0);
            ecQuestionService.updateEcQuestion(ecQuestion);
        }
        return resultMap;
    }

    @ResponseBody
    @RequestMapping("/ifQuestion")
    public Map<String, Object> IfQuestion(ModelMap map, HttpServletRequest request) throws Exception {
        Map<String, Object> resultMap = new HashMap<String, Object>(16);
        Map<String,Object> map1=new HashMap<String,Object>();
        map1.put("courseId",courseId);
        List<EcQuestion> list1=new ArrayList<EcQuestion>();
        int id=0;
        int type=0;
        try{
            list1=ecQuestionService.findEcQuestion(map1);
            for(EcQuestion l:list1){
                if(l.getQueState()==1){
                    id=l.getQueId();
                    type=l.getQueType();
                    break;
                }
            }
        }catch(Exception e){
        }
        if(id!=0){
            resultMap.put("type",type);
            resultMap.put("res",1);
            resultMap.put("queid",id);
        }
        else{
            resultMap.put("res",0);
        }
        return resultMap;
    }

    @ResponseBody
    @RequestMapping("/answerQuestion")
    public Map<String, Object> AnswerQuestion(ModelMap map, HttpServletRequest request) throws Exception {
        Map<String, Object> resultMap = new HashMap<String, Object>(16);
        String squeid = request.getParameter("queid");
        int queid=Integer.parseInt(squeid);
        String sanswer=request.getParameter("answer");
        int answer=Integer.parseInt(sanswer);
        EcQuestion ecQuestion = new EcQuestion();
        ecQuestion = ecQuestionService.findEcQuestionById(queid);
        if (ecQuestion.getQueState() == 1) {
            Map<String, Object> map1 = new HashMap<String, Object>();
            map1.put("userId", userId);
            map1.put("queId", queid);
            resultMap.put("res", "yes");
            List<EcAnswer> list=new ArrayList<EcAnswer>();
            try {
                list = ecAnswerService.findEcAnswer(map1);
                if (list.size()==0) {
                    EcAnswer ecAnswer = new EcAnswer();
                    ecAnswer.setUserId(userId);
                    ecAnswer.setQueId(queid);
                    ecAnswer.setAnsAnswer(answer);
                    ecAnswerService.saveEcAnswer(ecAnswer);
                }
                else {
                    EcAnswer e1 = new EcAnswer();
                    for (EcAnswer l : list) {
                        e1 = l;
                    }
                    e1.setAnsAnswer(answer);
                    ecAnswerService.updateEcAnswer(e1);
                }
            }catch(Exception e){
                e.printStackTrace();
            }
        }
        else {
            resultMap.put("res", "no");
        }
        return resultMap;
    }

    @ResponseBody
    @RequestMapping("/resultQuestion")
    public Map<String, Object> ResultQuestion(ModelMap map, HttpServletRequest request) throws Exception {
        Map<String, Object> resultMap = new HashMap<String, Object>(16);
        String squeid = request.getParameter("queid");
        int queid= Integer.parseInt(squeid);
        System.out.println(queid);
        EcQuestion ecQuestion=ecQuestionService.findEcQuestionById(queid);
        int type=0;
        if(ecQuestion.getQueType()==0){ //如果是选择题
            type=0;
            Map<String,Object> map1=new HashMap<String, Object>();
            map1.put("queId",queid);
            List<EcAnswer> list=new ArrayList<EcAnswer>();
            try {
                list = ecAnswerService.findEcAnswer(map1);
                int option0 = 0;
                int option1 = 0;
                int option2 = 0;
                int option3 = 0;
                int right = ecQuestion.getQueAns();
                int rightman = 0;
                int count = 0;
                double rate = 0;
                if (list.size()!=0) {
                    for (EcAnswer l : list) {
                        count++;
                        if (l.getAnsAnswer() == 0) option0++;
                        else if (l.getAnsAnswer() == 1) option1++;
                        else if (l.getAnsAnswer() == 2) option2++;
                        else option3++;
                        if (l.getAnsAnswer() == right)
                            rightman++;
                    }
                    int rate0 = rightman * 10000 / count;
                    rate=(double)rate0/100;
                }
                resultMap.put("op0", option0);
                resultMap.put("op1", option1);
                resultMap.put("op2", option2);
                resultMap.put("op3", option3);
                resultMap.put("rate", rate);
                resultMap.put("type", type);
            }catch(Exception e){
                e.printStackTrace();
            }
        }
        else{       //如果是判断题
            type=1;
            Map<String,Object> map1=new HashMap<String, Object>();
            map1.put("queId",queid);
            List<EcAnswer> list=new ArrayList<EcAnswer>();
            try {
                list = ecAnswerService.findEcAnswer(map1);
                int option0 = 0;
                int option1 = 0;
                int right = ecQuestion.getQueAns();
                int rightman = 0;
                int count = 0;
                double rate = 0;
                if (list.size()!=0) {
                    for (EcAnswer l : list) {
                        count++;
                        if (l.getAnsAnswer() == 0) option0++;
                        else option1++;
                        if (l.getAnsAnswer() == right)
                            rightman++;
                    }
                    int rate0 = rightman * 10000 / count;
                    rate=(double)rate0/100;
                }
                System.out.println("rate:" + rate);
                resultMap.put("op0", option0);
                resultMap.put("op1", option1);
                resultMap.put("rate", rate);
                resultMap.put("type", type);
            }catch(Exception e){
                System.out.println(e);
                e.printStackTrace();
            }
        }
        return resultMap;
    }
}
