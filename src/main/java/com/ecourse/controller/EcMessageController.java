package com.ecourse.controller;

import com.ecourse.AjaxResult.CourseMessage;
import com.ecourse.AjaxResult.ListContent;
import com.ecourse.AjaxResult.PingjiaoContent;
import com.ecourse.entity.EcCourse;
import com.ecourse.entity.EcMessage;
import com.ecourse.entity.EcStuandcourse;
import com.ecourse.service.EcCourseService;
import com.ecourse.service.EcMessageService;
import com.ecourse.service.EcStuandcourseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.persistence.criteria.CriteriaBuilder;
import javax.servlet.http.HttpServletRequest;
import java.text.DecimalFormat;
import java.util.*;

/**
 * Created by biggf on 2017/12/23.
 */
@Controller
@RequestMapping("/message")
public class EcMessageController {
    @Autowired
    EcMessageService ecMessageService;
    @Autowired
    EcStuandcourseService ecStuandcourseService;
    @Autowired
    EcCourseService ecCourseService;

    @ResponseBody
    @RequestMapping("/coursemessage")
    List<CourseMessage> getCourseMessage(ModelMap map, HttpServletRequest request)
    {

        Map<String, Object> resultMap = new HashMap<String, Object>(16);
        String userId=request.getParameter("userId");
        System.out.println("userId2"+":"+userId);
        Map<String ,Object> coursemap=new HashMap<String, Object>(16);;
        coursemap.put("userId",userId);
        System.out.println("coursemap:"+coursemap.get("userId"));

        List<EcStuandcourse> listStuandCourse =new ArrayList<EcStuandcourse>();

        listStuandCourse=ecStuandcourseService.findEcStuandcourseByUserId(Integer.parseInt(userId));
        System.out.println("listcoursesize size:"+listStuandCourse.size());
        List<CourseMessage> listmessage=new ArrayList<CourseMessage>();
        for(EcStuandcourse item:listStuandCourse)
        {
            CourseMessage cm=new CourseMessage();
            cm.setCourseId(item.getCourseId());
            cm.setCourseName(ecCourseService.findEcCourseById((item.getCourseId())).getCourseName());
            cm.setCourseScore(100);
            Map<String ,Object> msgmap=new HashMap<String, Object>();
            msgmap.put("userId",userId);
            msgmap.put("courseId",item.getCourseId());
            msgmap.put("msgAnonymous",0);
            EcMessage em=ecMessageService.findUserMessage(Integer.parseInt(userId),item.getCourseId());
            if(em!=null)
            cm.setMsgOk(em.getMsgOk());
            else
            {
                cm.setMsgOk(0);
            }
            listmessage.add(cm);
        }

        for(CourseMessage e:listmessage)
        {
            System.out.println(e.getCourseId());
            System.out.println(e.getCourseName());
            System.out.println(e.getCourseScore());
        }

       // resultMap.put("infos",listmessage);
        return listmessage;
    }
    @ResponseBody
    @RequestMapping("/savemessage")
    public Map<String,Object> savemessage(ModelMap map, HttpServletRequest request)
    {
        Map<String,Object> resmap=new HashMap<String, Object>();
        String courseId = request.getParameter("courseId");
        String content = request.getParameter("content");
        String stars=request.getParameter("stars");
        String userId=request.getParameter("userId");
        System.out.println("???+++"+content);
        System.out.println("???+++"+courseId);
        System.out.println("???+++"+stars);
        System.out.println("???+++"+userId);
        EcMessage ecm=new EcMessage();
        if(courseId!=null)
        ecm.setCourseId(Integer.parseInt(courseId));
        else
        {
            resmap.put("res","no");
            return resmap;
        }

        ecm.setMsgAnonymous(0);
        if(content!=null)
        ecm.setMsgContent(content);
        else
        {
            resmap.put("res","no");
            return resmap;
        }
        if(stars!=null)
        ecm.setMsgStar(Float.parseFloat(stars));
        else
        {
            resmap.put("res","no");
            return resmap;
        }
        ecm.setMsgTime(new Date());
        if(userId!=null)
        ecm.setUserId(Integer.parseInt(userId));
        else
        {
            resmap.put("res","no");
            return resmap;
        }
        ecm.setMsgOk(1);
        ecMessageService.saveEcMessage(ecm);

        resmap.put("res","yes");
        return resmap;
    }

    @ResponseBody
    @RequestMapping("/checkmessage")
    public List<PingjiaoContent> checkmessage(ModelMap map, HttpServletRequest request)
    {
        System.out.println("??1");
        String userId=request.getParameter("userId");
        List<EcCourse> ecCourses=ecCourseService.findEcCourseByuserId(Integer.parseInt(userId));
        List<PingjiaoContent> pcs=new ArrayList<PingjiaoContent>();
        List<EcMessage> em=new ArrayList<EcMessage>();
        for(EcCourse item:ecCourses)
        {
            PingjiaoContent pc=new PingjiaoContent();
            double sum=0;
            int count=0;
            em=ecMessageService.findEcMessageByCourseId(item.getCourseId());
            for(EcMessage item2:em)
            {
                sum+=item2.getMsgStar();
                count++;
            }
            if(em.size()==0)
            {
                pc.setIsPingjiao(0);
                pc.setStar(0);
            }
            else
            {
                pc.setIsPingjiao(1);
                DecimalFormat df=new DecimalFormat("######0.00");
                pc.setStar(Float.parseFloat(df.format((float)sum/(1.0f*count))));
            }
            System.out.println(pc.getIsPingjiao());
            pc.setCourseId(item.getCourseId());
            pc.setCourseName(item.getCourseName());
            pcs.add(pc);
        }
        return pcs;
    }

    @ResponseBody
    @RequestMapping("/listpingjiao")
    public List<ListContent> listpingjiao(ModelMap map, HttpServletRequest request)
    {
        String userId=request.getParameter("userId");
        String courseId=request.getParameter("courseId");
        String courseName=request.getParameter("courseName");
        List<EcMessage> ecMessages=ecMessageService.findEcMessageByCourseId(Integer.parseInt(courseId));
        List<ListContent> listContents=new ArrayList<ListContent>();
        for(EcMessage item:ecMessages)
        {
            ListContent lc=new ListContent();
            lc.setContent(item.getMsgContent());
            lc.setCourseId(Integer.parseInt(courseId));
            lc.setCourseName(courseName);

            System.out.println("stu userId:"+item.getUserId());
            lc.setStuId(item.getUserId());
            listContents.add(lc);
        }
        return listContents;
    }
}
