package com.ecourse.controller;

import com.ecourse.entity.EcSource;
import com.ecourse.service.EcSourceService;
import com.ecourse.service.EcUserService;
import com.ecourse.untils.AccountValidatorUtil;
import com.ecourse.untils.DateUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import javax.servlet.http.HttpServletRequest;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author thea
 * @create 2017-12-26 14:05
 */

@Controller
@RequestMapping("/courseware")
public class EcSourceController {

    @Autowired
    private EcSourceService ecSourceService;
    @Autowired
    private EcUserService ecUserService;

    /**
     * 展示课件内容
     */
    @ResponseBody
    @RequestMapping("/display")
    public Map<String, Object> displayCourseware(ModelMap map, HttpServletRequest request) throws Exception {
        Map<String, Object> resultMap = new HashMap<String, Object>(16);
        Map<String, Object> tmp = new HashMap<String, Object>(16);
        int courseId=Integer.parseInt(request.getParameter("courseId"));
        tmp.put("courseId",courseId);
        List<EcSource> list=ecSourceService.findEcSource(tmp);//ecSourceService.findEcSourceByCid(Integer.parseInt(request.getSession().getAttribute("current_EcCourse").toString()));

        if(list==null || list.isEmpty()) {
            resultMap.put("num", 0);
        }
        else {
            resultMap.put("num", list.size());
            for(int i=0; i<list.size(); i++) {
                System.out.println(i+" "+list.get(i).getSourceTitle());
            }
            resultMap.put("cwlist", list);
        }

        resultMap.put("res", "yes");
        return resultMap;
    }

    /**
     * 发布新课件
     */
    @ResponseBody
    @RequestMapping("/release")
    public Map<String, Object> releaseCourseware(ModelMap map, HttpServletRequest request) throws Exception{
        Map<String, Object> resultMap = new HashMap<String, Object>(16);
        int courseId=Integer.parseInt(request.getParameter("courseId"));
        EcSource ecSource = new EcSource();
        String title=request.getParameter("sTitle");
        String link=request.getParameter("sLink");
        String pw=request.getParameter("sPassword");
        String note=request.getParameter("sNote");
        //System.out.println(title+" "+link+" "+pw+" "+note);

        //ecSource.setCourseId(Integer.parseInt(request.getSession().getAttribute("current_EcCourse").toString())); //待写
        //System.out.println(ecSourceService.getNewSid());
        ecSource.setSourceId(ecSourceService.getNewSid());
        ecSource.setSourceTitle(title);
        ecSource.setSourceLink(link);
        ecSource.setSourcePassword(pw);
        ecSource.setSourceNote(note);
        ecSource.setCourseId(courseId);

        ecSourceService.saveEcSource(ecSource);
        resultMap.put("res", "yes");
        return resultMap;
    }
}