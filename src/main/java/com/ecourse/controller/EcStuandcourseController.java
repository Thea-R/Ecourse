package com.ecourse.controller;

import com.ecourse.entity.EcCourse;
import com.ecourse.entity.EcStuandcourse;
import com.ecourse.service.EcCourseService;
import com.ecourse.service.EcStuandcourseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author tomato
 * @create 2017-12-26 上午11:20
 */
@Controller
@RequestMapping("/stuandcourse")
public class EcStuandcourseController {

    @Autowired
    EcStuandcourseService ecStuandcourseService;

    @Autowired
    EcCourseService ecCourseService;

    /**
     * 更具ecUserId查找课程
     *
     * @param map     ModelMap
     * @param request 前端请求
     * @return 是否新建成功
     * @throws Exception 异常捕获
     */
    @ResponseBody
    @RequestMapping("/findMyCourse")
    public Map<String, Object> ecCourseFindCourse(ModelMap map, HttpServletRequest request) throws Exception {
        Map<String, Object> resultMap = new HashMap<String, Object>(16);
        int userId = Integer.parseInt(request.getParameter("userId"));
        List<EcStuandcourse> ecStuandcourses = ecStuandcourseService.findEcStuandcourseByUserId(userId);
        List<EcCourse> ecCourses = new ArrayList<EcCourse>();
        for (EcStuandcourse e : ecStuandcourses) {
            ecCourses.add(ecCourseService.findEcCourseById(e.getCourseId()));
        }
        if (ecCourses.size() == 0) {
            resultMap.put("res", "no");
        }
        else {
            resultMap.put("myCourse", ecCourses);
            resultMap.put("res", "yes");
        }
        return resultMap;
    }
}
