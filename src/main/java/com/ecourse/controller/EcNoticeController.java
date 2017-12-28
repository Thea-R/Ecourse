package com.ecourse.controller;

import com.ecourse.entity.EcNotice;
import com.ecourse.entity.EcNoticeView;
import com.ecourse.entity.EcStuandcourse;
import com.ecourse.entity.EcUser;
import com.ecourse.service.EcNoticeService;
import com.ecourse.service.EcNoticeViewService;
import com.ecourse.service.EcStuandcourseService;
import com.ecourse.service.EcUserService;
import com.ecourse.untils.DateUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import java.util.*;

@Controller
@RequestMapping("/Notice")
public class EcNoticeController {

    @Autowired
    private EcNoticeService ecNoticeService;

    @Autowired
    private EcNoticeViewService ecNoticeViewService;

    @Autowired
    private EcUserService ecUserService;

    @Autowired
    private EcStuandcourseService ecStuandcourseService;

    @ResponseBody
    @RequestMapping("/TeaPublish")
    public Map<String, Object> ecNoticePublish(ModelMap map, HttpServletRequest request) throws Exception {
        Map<String, Object> resultMap = new HashMap<String, Object>();
        EcNotice ecNotice = new EcNotice();

        int courseId=Integer.parseInt(request.getParameter("courseId"));


        ecNotice.setNotType(Integer.parseInt(request.getParameter("N_type")));
        ecNotice.setNotTitle(request.getParameter("N_title"));
        ecNotice.setNotTime(new Date());
        ecNotice.setNotContent(request.getParameter("N_content"));
        ecNotice.setCourseId(courseId);
        ecNoticeService.saveEcNotice(ecNotice);
        resultMap.put("notice", ecNotice);
        resultMap.put("res", "yes");
        return resultMap;
    }

    @ResponseBody
    @RequestMapping("/TeaCheckNoticeList")
    public Map<String, Object> ecNoticeTeaCheckPublishList(ModelMap map, HttpServletRequest request) throws Exception {
        Map<String, Object> resultMap = new HashMap<String, Object>();
        Map<String, Object> findMap = new HashMap<String, Object>();

        int courseId=Integer.parseInt(request.getParameter("courseId"));


        List<EcNotice> ecNoticeList = new ArrayList<EcNotice>();
        findMap.put("courseId",courseId);
        ecNoticeList = ecNoticeService.findEcNotice(findMap);
        resultMap.put("res", ecNoticeList);
        return resultMap;
    }


    @ResponseBody
    @RequestMapping("/StuCheckNoticeList")
    public Map<String, Object> ecNoticeStuCheckList(ModelMap map, HttpServletRequest request) throws Exception {
        Map<String, Object> resultMap = new HashMap<String, Object>();
        Map<String, Object> findMap = new HashMap<String, Object>();

        int courseId=Integer.parseInt(request.getParameter("courseId"));

        List<EcNotice> ecNoticeList = new ArrayList<EcNotice>();
        findMap.put("courseId", courseId);
        ecNoticeList = ecNoticeService.findEcNotice(findMap);
        resultMap.put("res", ecNoticeList);
        return resultMap;
    }

    @ResponseBody
    @RequestMapping("/StuCheckNoticeContent")
    public Map<String, Object> ecNoticeStuCheckContent(ModelMap map, HttpServletRequest request) throws Exception {
        Map<String, Object> resultMap = new HashMap<String, Object>();
        Map<String, Object> findMap = new HashMap<String, Object>();

        int notId=Integer.parseInt(request.getParameter("notId"));
        int userId=Integer.parseInt(request.getParameter("userId"));


        EcNotice ecNotice=new EcNotice();
        ecNotice=ecNoticeService.findEcNoticeById(notId);
        resultMap.put("content", ecNotice);

        List<EcNoticeView> ecNoticeViewsList = new ArrayList<EcNoticeView>();
        findMap.put("notId",notId);
        findMap.put("userId",userId);
        ecNoticeViewsList=ecNoticeViewService.findEcNoticeView(findMap);
        int num=ecNoticeViewsList.size();
        System.out.println("查表得到的list大小是："+ecNoticeViewsList.size());
        if(num==0){
            EcNoticeView ecNoticeView=new EcNoticeView();
            ecNoticeView.setNotViewTime(new Date());
            ecNoticeView.setUserId(userId);
            ecNoticeView.setNotId(notId);
            ecNoticeViewService.saveEcNoticeView(ecNoticeView);
        }
        return resultMap;
    }


    @ResponseBody
    @RequestMapping("/TeaCheckStuRead")
    public Map<String, Object> ecNoticeTeaCheckStuRead(ModelMap map, HttpServletRequest request) throws Exception {
        Map<String, Object> resultMap = new HashMap<String, Object>();
        Map<String, Object> findMap = new HashMap<String, Object>();
        Map<String, Object> findMap1= new HashMap<String, Object>();

        int courseId=Integer.parseInt(request.getParameter("courseId"));
        int notId=Integer.parseInt(request.getParameter("notId"));

        List<EcUser> ecUsersList=new ArrayList<EcUser>();//查看通知的学生
        List<EcUser> ecUsersList1=new ArrayList<EcUser>();//没有查看的学生
        List<EcUser> ecUsersList3=new ArrayList<EcUser>();//所有学生1
        List<EcUser> ecUserlist4=new ArrayList<EcUser>();//所有学生2
        List<EcNoticeView> ecNoticeViewsList=new ArrayList<EcNoticeView>();
        List<EcStuandcourse> ecStuandcoursesList =new ArrayList<EcStuandcourse>();//总人数ID

        EcNotice ecNotice=new EcNotice();
        ecNotice=ecNoticeService.findEcNoticeById(notId);//通知


        findMap.put("notId",notId);
        ecNoticeViewsList=ecNoticeViewService.findEcNoticeView(findMap); //找到这条通知被查看的列表：


        findMap1.put("userType",0);
        ecUsersList3 = ecUserService.findEcUser(findMap1);//查找所有的学生1：


        ecStuandcoursesList=ecStuandcourseService.findEcStuandcourseByCourseId(courseId);//总的学生ID
        System.out.println("获取的课程ID学生ID列表"+ecStuandcoursesList.get(0).getUserId()+"学生数"+ecStuandcoursesList.size());


        //查找查看通知的学生：
        for(int i=0;i<ecNoticeViewsList.size();i++ ){
            ecUsersList.add(ecUserService.findEcUserById(ecNoticeViewsList.get(i).getUserId()));
        }
        System.out.println("已查看通知的学生的人数为："+ecUsersList.size());


        //未查看通知学生：
        int k=ecStuandcoursesList.size();
        int m=ecUsersList.size();
        for(int i=0;i<k;i++){
            int studentId=ecStuandcoursesList.get(i).getUserId();
            int flag=0;
            for (int j=0;j<m;j++){
                if (studentId==ecUsersList.get(j).getUserId()){
                    flag=1;
                    break;
                }
            }
            if (flag==0) {
                ecUserlist4.add(ecUserService.findEcUserById(studentId));
            }
        }
        System.out.println("未查看通知的总人数："+ecUserlist4.size());

        resultMap.put("content",ecNotice);
        resultMap.put("Read",ecUsersList);
        resultMap.put("NotRead",ecUserlist4);

        return resultMap;
    }

/**
 ecNotice.setUserWxId(request.getParameter("userWxId"));
 ecUser.setUserName(request.getParameter("userName"));
 ecUser.setUserNum(request.getParameter("userNum"));
 ecUser.setUserSex(Integer.parseInt(request.getParameter("userSex")));
 ecUser.setUserSchool(request.getParameter("userSchool"));
 ecUser.setUserSdept(request.getParameter("userSdept"));
 ecUser.setUserBirth(DateUtil.fomatDate(request.getParameter("userBirth")));
 ecUser.setUserPhone(request.getParameter("userPhone"));
 ecUser.setUserType(Integer.parseInt(request.getParameter("userType")));
 ecUser.setUserCreatTime(new Date());success
 ecUser.setUserEmail(request.getParameter("userEmail"));
 ecUserService.saveEcUser(ecUser);
 resultMap.put("res", "yes");
 return resultMap;
 **/
}