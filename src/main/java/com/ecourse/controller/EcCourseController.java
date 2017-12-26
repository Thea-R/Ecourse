package com.ecourse.controller;

import com.ecourse.service.EcCourseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import java.util.HashMap;
import java.util.Map;

/**
 * @author tomato
 * @create 2017-12-26 上午11:11
 */
@Controller
@RequestMapping("/course")
public class EcCourseController {

    @Autowired
    EcCourseService ecCourseService;

    /**
     * 保存选择的课程号
     *
     * @param map     ModelMap
     * @param request 前端请求
     * @return 是否新建成功
     * @throws Exception 异常捕获
     */
    @ResponseBody
    @RequestMapping("/saveCourseIdSession")
    public Map<String, Object> ecCourseFindCourse(ModelMap map, HttpServletRequest request) throws Exception {
        Map<String, Object> resultMap = new HashMap<String, Object>(16);
        String course = "courseId";
        if (request.getParameter(course) != null) {
            int courseId = Integer.parseInt(request.getParameter(course));
            request.getSession().setAttribute("current_EcCourse", courseId);
            resultMap.put("myCourse", courseId);
            resultMap.put("res", "yes");
        } else {
            resultMap.put("res", "no");
        }
        return resultMap;
    }
}
