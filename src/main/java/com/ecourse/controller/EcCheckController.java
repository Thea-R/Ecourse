package com.ecourse.controller;

import com.ecourse.AjaxResult.CheckResult;
import com.ecourse.entity.EcCheck;
import com.ecourse.service.EcCheckService;
import com.ecourse.service.EcStcheckService;
import com.ecourse.service.EcStuandcourseService;
import com.ecourse.untils.CommonUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import java.util.*;

/**
 * @author tomato
 * @create 2017-12-21 上午10:02
 */
@Controller
@RequestMapping("/check")
public class EcCheckController {

    @Autowired
    EcCheckService ecCheckService;

    @Autowired
    EcStuandcourseService ecStuandcourseService;

    @Autowired
    EcStcheckService ecStcheckService;

    /**
     * 新建一个点名
     *
     * @param map     ModelMap
     * @param request 前端请求
     * @return 是否新建成功
     * @throws Exception 异常捕获
     */
    @ResponseBody
    @RequestMapping("/newCheck")
    public Map<String, Object> ecCheckNew(ModelMap map, HttpServletRequest request) throws Exception {
        Map<String, Object> resultMap = new HashMap<String, Object>(16);
        //Integer.parseInt(request.getSession().getAttribute("current_EcCourse"))
        int courseId = 1;
        Map<String, Object> findMap = new HashMap<String, Object>(16);
        findMap.put("courseId", courseId);
        findMap.put("checkState", 1);
        List<EcCheck> ecChecks = ecCheckService.findEcCheck(findMap);
        if (ecChecks.size() > 0) {
            resultMap.put("checkVerify", ecChecks.get(0).getCheckVerify());
            resultMap.put("res", "no");
            return resultMap;
        }
        EcCheck ecCheck = new EcCheck();
        ecCheck.setCourseId(courseId);
        ecCheck.setCheckTime(new Date());
        ecCheck.setCheckVerify(CommonUtil.generateUUID(6));
        ecCheck.setCheckState(1);
        ecCheckService.saveEcCheck(ecCheck);
        resultMap.put("checkVerify", ecCheck.getCheckVerify());
        resultMap.put("res", "yes");
        return resultMap;
    }

    /**
     * 结束点名
     *
     * @param map     ModelMap
     * @param request 前端请求
     * @return 是否新建成功
     * @throws Exception 异常捕获
     */
    @ResponseBody
    @RequestMapping("/endCheck")
    public Map<String, Object> ecCheckEnd(ModelMap map, HttpServletRequest request) throws Exception {
        Map<String, Object> resultMap = new HashMap<String, Object>(16);
        //Integer.parseInt(request.getSession().getAttribute("current_EcCourse"))
        int courseId = 1;
        Map<String, Object> findMap = new HashMap<String, Object>(16);
        findMap.put("courseId", courseId);
        findMap.put("checkState", 1);
        List<EcCheck> ecChecks = ecCheckService.findEcCheck(findMap);
        if (ecChecks.size() == 0) {
            resultMap.put("res", "no");
            return resultMap;
        }
        EcCheck ecCheck = ecChecks.get(0);
        ecCheck.setCheckState(0);
        ecCheckService.updateEcCheck(ecCheck);
        resultMap.put("res", "yes");
        return resultMap;
    }

    /**
     * 查询这门课的所有签到记录
     *
     * @param map     ModelMap
     * @param request 前端请求
     * @return 是否新建成功
     * @throws Exception 异常捕获
     */
    @ResponseBody
    @RequestMapping("/findCourseCheck")
    public Map<String, Object> ecCheckFindCourseCheck(ModelMap map, HttpServletRequest request) throws Exception {
        Map<String, Object> resultMap = new HashMap<String, Object>(16);
        //Integer.parseInt(request.getSession().getAttribute("current_EcCourse"))
        int courseId = 1;
        List<EcCheck> ecChecks = ecCheckService.findEcCheckByCourseId(courseId);
        if (ecChecks.size() == 0) {
            resultMap.put("res", "no");
            return resultMap;
        }
        List<CheckResult> checkResults = new ArrayList<CheckResult>();
        CheckResult checkResult = new CheckResult();
        Map<String, Object> findMap = new HashMap<String, Object>(16);
        for (EcCheck e : ecChecks) {
            checkResult = new CheckResult();
            checkResult.setEcCheck(e);
            System.out.println(e.getCheckId() + "\t\t" + checkResult.getCheckId() + "\t\t" + checkResult.getCheckTime());
            checkResult.setCheckAllNum(ecStuandcourseService.findEcStuandcourseByCourseId(e.getCourseId()).size());
            findMap.clear();
            findMap.remove("checkId");
            findMap.put("checkId", e.getCheckId());
            findMap.put("checkType", 5);
            checkResult.setCheckYesNum(ecStcheckService.findEcStcheck(findMap).size());
            checkResults.add(checkResult);
        }
        for (CheckResult c:checkResults){
            System.out.println("c.getCheckId()的值是：---"+ c.getCheckId() + "，当前方法=EcCheckController.ecCheckFindCourseCheck()");
        }
        resultMap.put("ecChecks", checkResults);
        resultMap.put("res", "yes");
        return resultMap;
    }
}
