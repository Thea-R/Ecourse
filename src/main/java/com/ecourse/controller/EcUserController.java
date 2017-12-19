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
     * @return 是否登陆成功
     * @throws Exception 异常捕获
     */
    @ResponseBody
    @RequestMapping("/login")
    public Map<String, Object> ecUserLogin(ModelMap map, HttpServletRequest request) throws Exception {
        Map<String, Object> resultMap = new HashMap<String, Object>(16);
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

    /**
     * 注册
     *
     * @param map ModelMap
     * @param request 注册信息
     * @return 是否注册成功
     * @throws Exception 异常捕获
     */
    @ResponseBody
    @RequestMapping("/regedit")
    public  Map<String, Object> ecUserRegedit(ModelMap map, HttpServletRequest request) throws Exception{
        Map<String, Object> resultMap = new HashMap<String, Object>(16);
        EcUser ecUser = new EcUser();
        String str = request.getParameter("userWxId");
        if (str != null){
            ecUser.setUserWxId(str);
        }
        str = request.getParameter("userName");
        if (str != null){
            ecUser.setUserName(str);
        }
        str = request.getParameter("userNum");
        if (str != null){
            ecUser.setUserNum(str);
        }
        str = request.getParameter("userSex");
        if (str != null){
            ecUser.setUserSex(Integer.parseInt(str));
        }
        str = request.getParameter("userSchool");
        if (str != null){
            ecUser.setUserSchool(str);
        }
        str = request.getParameter("userSdept");
        if (str != null){
            ecUser.setUserSdept(str);
        }
        str = request.getParameter("userBirth");
        if (str != null){
            ecUser.setUserBirth(DateUtil.fomatDate(str));
        }
        str = request.getParameter("userPhone");
        if (str != null){
            ecUser.setUserPhone(str);
        }
        str = request.getParameter("userType");
        if (str != null){
            ecUser.setUserType(Integer.parseInt(str));
        }
        ecUser.setUserCreatTime(new Date());
        str = request.getParameter("userEmail");
        if (str != null){
            ecUser.setUserEmail(str);
        }
        ecUserService.saveEcUser(ecUser);
        resultMap.put("res", "yes");
        return resultMap;
    }

    /**
     * 修改个人信息
     *
     * @param map ModelMap
     * @param request 修改的信息信息
     * @return 是否修改成功
     * @throws Exception 异常捕获
     */
    @ResponseBody
    @RequestMapping("/updateInfo")
    public  Map<String, Object> ecUserUpdate(ModelMap map, HttpServletRequest request) throws Exception{
        Map<String, Object> resultMap = new HashMap<String, Object>(16);
        EcUser ecUser = (EcUser) request.getSession().getAttribute("current_EcUser");
        String str = request.getParameter("userWxId");
        if (str != null){
            ecUser.setUserWxId(str);
        }
        str = request.getParameter("userName");
        if (str != null){
            ecUser.setUserName(str);
        }
        str = request.getParameter("userNum");
        if (str != null){
            ecUser.setUserNum(str);
        }
        str = request.getParameter("userSex");
        if (str != null){
            ecUser.setUserSex(Integer.parseInt(str));
        }
        str = request.getParameter("userSchool");
        if (str != null){
            ecUser.setUserSchool(str);
        }
        str = request.getParameter("userSdept");
        if (str != null){
            ecUser.setUserSdept(str);
        }
        str = request.getParameter("userBirth");
        if (str != null){
            ecUser.setUserBirth(DateUtil.fomatDate(str));
        }
        str = request.getParameter("userPhone");
        if (str != null){
            ecUser.setUserPhone(str);
        }
        str = request.getParameter("userType");
        if (str != null){
            ecUser.setUserType(Integer.parseInt(str));
        }
        ecUser.setUserCreatTime(new Date());
        str = request.getParameter("userEmail");
        if (str != null){
            ecUser.setUserEmail(str);
        }
        ecUserService.updateEcUser(ecUser);
        request.getSession().setAttribute("current_EcUser", ecUser);
        resultMap.put("sessionId", request.getSession().getId());
        resultMap.put("res", "yes");
        return resultMap;
    }
}
