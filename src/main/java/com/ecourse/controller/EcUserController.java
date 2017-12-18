package com.ecourse.controller;

import com.ecourse.entity.EcUser;
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
import java.util.Map;

/**
 * @author tomato
 * @create 2017-12-15 下午3:47
 */
@Controller
@RequestMapping("/user")
public class EcUserController {

    @Autowired
    private EcUserService ecUserService;

    /**
     * 登陆
     *
     * @param map ModelMap
     * @param request 用户名，密码
     * @return 登陆的用户或者null
     * @throws Exception 异常捕获
     */
    @ResponseBody
    @RequestMapping("/login")
    public Map<String, Object> ecUserLogin(ModelMap map, HttpServletRequest request) throws Exception {
        Map<String, Object> resultMap = new HashMap<String, Object>();
        String password = request.getParameter("password");
        String key = request.getParameter("ecUserId");
        EcUser ecUser;
        if (AccountValidatorUtil.isNumeric(key)) {
            ecUser  = ecUserService.findEcUserByLogin(Integer.parseInt(key), password);
        }
        else {
            ecUser  = ecUserService.findEcUserByLogin(key, password);
        }
        if (ecUser != null) {
            request.getSession().setAttribute("current_EcUser", ecUser);
            resultMap.put("sessionId", request.getSession().getId());
            resultMap.put("res", "yes");
        } else {
            resultMap.put("res", "no");
        }
        return resultMap;
    }

    @ResponseBody
    @RequestMapping("/regedit")
    public  Map<String, Object> ecUserRegedit(ModelMap map, HttpServletRequest request) throws Exception{
        Map<String, Object> resultMap = new HashMap<String, Object>();
        EcUser ecUser = new EcUser();
        ecUser.setUserWxId(request.getParameter("userWxId"));
        ecUser.setUserName(request.getParameter("userName"));
        ecUser.setUserNum(request.getParameter("userNum"));
        ecUser.setUserSex(Integer.parseInt(request.getParameter("userSex")));
        ecUser.setUserSchool(request.getParameter("userSchool"));
        ecUser.setUserSdept(request.getParameter("userSdept"));
        ecUser.setUserBirth(DateUtil.fomatDate(request.getParameter("userBirth")));
        ecUser.setUserPhone(request.getParameter("userPhone"));
        ecUser.setUserType(Integer.parseInt(request.getParameter("userType")));
        ecUser.setUserCreatTime(new Date());
        ecUser.setUserEmail(request.getParameter("userEmail"));
        ecUserService.saveEcUser(ecUser);
        resultMap.put("res", "yes");
        return resultMap;
    }
}
