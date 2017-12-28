package com.ecourse.controller;

import com.ecourse.AjaxResult.StuCheckResult;
import com.ecourse.entity.EcCheck;
import com.ecourse.entity.EcStcheck;
import com.ecourse.entity.EcUser;
import com.ecourse.service.EcCheckService;
import com.ecourse.service.EcStcheckService;
import com.ecourse.service.EcUserService;
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
 * @create 2017-12-21 下午7:40
 */
@Controller
@RequestMapping("/stcheck")
public class EcStcheckController {

    @Autowired
    EcStcheckService ecStcheckService;

    @Autowired
    EcCheckService ecCheckService;

    @Autowired
    EcUserService ecUserService;

    /**
     * 查询这一个签到表中所有的签到详细记录
     *
     * @param map     ModelMap
     * @param request 前端请求
     * @return 是否新建成功
     * @throws Exception 异常捕获
     */
    @ResponseBody
    @RequestMapping("/findStcheck")
    public Map<String, Object> ecStccheckFindCheck(ModelMap map, HttpServletRequest request) throws Exception {
        Map<String, Object> resultMap = new HashMap<String, Object>(16);
        int checkId = Integer.parseInt(request.getParameter("checkId"));
        Map<String, Object> findMap = new HashMap<String, Object>(16);
        findMap.put("checkId", checkId);
        findMap.put("checkType", 5);
        List<EcStcheck> ecStchecks = ecStcheckService.findEcStcheck(findMap);
        List<StuCheckResult> stuCheckResults = addStuChackInfo(ecStchecks);
        findMap = new HashMap<String, Object>(16);
        findMap.put("checkId", checkId);
        findMap.put("ltCheckType", 5);
        List<EcStcheck> ecStcheckList = ecStcheckService.findEcStcheck(findMap);
        List<StuCheckResult> stuCheckResultList = addStuChackInfo(ecStcheckList);
        if (ecStchecks.size() == 0 && ecStcheckList.size() == 0) {
            resultMap.put("res", "no");
            return resultMap;
        }
        resultMap.put("ecStchecks", stuCheckResults);
        resultMap.put("ltCheckType", stuCheckResultList);
        resultMap.put("res", "yes");
        return resultMap;
    }

    /**
     * 一个签到表中签到学生详细信息的json数据
     *
     * @param ecStchecks 签到的学生
     * @return 学生详细信息
     */
    private List<StuCheckResult> addStuChackInfo(List<EcStcheck> ecStchecks) {
        List<StuCheckResult> stuCheckResults = new ArrayList<StuCheckResult>();
        StuCheckResult stuCheckResult = new StuCheckResult();
        EcUser ecUser;
        for (EcStcheck e : ecStchecks) {
            stuCheckResult.setEcStcheck(e);
            ecUser = ecUserService.findEcUserById(e.getUserId());
            stuCheckResult.setUserName(ecUser.getUserName());
            stuCheckResult.setUserFaviconUrl(ecUser.getUserFaviconUrl());
            stuCheckResults.add(stuCheckResult);
        }
        return stuCheckResults;
    }

    /**
     * 更改一个学生的签到状态
     *
     * @param map     ModelMap
     * @param request 前端请求
     * @return 是更改成功
     * @throws Exception 异常捕获
     */
    @ResponseBody
    @RequestMapping("/updateStcCheck")
    public Map<String, Object> ecStccheckUpdateStcCheck(ModelMap map, HttpServletRequest request) throws Exception {
        Map<String, Object> resultMap = new HashMap<String, Object>(16);
        int checkId = Integer.parseInt(request.getParameter("checkId"));
        int userId = Integer.parseInt(request.getParameter("userId"));
        int checkType = Integer.parseInt(request.getParameter("checkType"));
        EcStcheck ecStcheck = ecStcheckService.findEcStcheckById(checkId, userId);
        if (ecStcheck == null) {
            resultMap.put("res", "no");
            return resultMap;
        }
        ecStcheck.setCheckType(checkType);
        ecStcheckService.updateEcStcheck(ecStcheck);
        resultMap.put("res", "yes");
        return resultMap;
    }

    /**
     * 学生签到
     *
     * @param map     ModelMap
     * @param request 前端请求
     * @return 是更改成功
     * @throws Exception 异常捕获
     */
    @ResponseBody
    @RequestMapping("/newStcCheck")
    public Map<String, Object> ecStccheckNewStcCheck(ModelMap map, HttpServletRequest request) throws Exception {
        Map<String, Object> resultMap = new HashMap<String, Object>(16);
        String checkVerify = request.getParameter("checkVerify");
        int checkId = Integer.parseInt(request.getParameter("checkId"));
        int userId = Integer.parseInt(request.getParameter("userId"));
        EcCheck ecCheck = ecCheckService.findEcCheckById(checkId);
        EcStcheck ecStcheck = ecStcheckService.findEcStcheckById(checkId, userId);
        if (ecStcheck == null || ecCheck == null || !ecCheck.getCheckVerify().equals(checkVerify)) {
            resultMap.put("res", "no");
            return resultMap;
        }
        int checkTypeYes = 5;
        if (ecStcheck.getCheckType() == checkTypeYes) {
            resultMap.put("res", "no");
            resultMap.put("repeat", "yes");
            return resultMap;
        }
        ecStcheck.setCheckType(5);
        ecStcheckService.updateEcStcheck(ecStcheck);
        resultMap.put("res", "yes");
        return resultMap;
    }
}
