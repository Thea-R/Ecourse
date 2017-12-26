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
     * @param map     ModelMap
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
        if (AccountValidatorUtil.isMobile(key)) {
            ecUser = ecUserService.findEcUserByLogin(key, password);
        }
        else if (AccountValidatorUtil.isNumeric(key)) {
            ecUser = ecUserService.findEcUserByLogin(Integer.parseInt(key), password);
        } else {
            ecUser = ecUserService.findEcUserByLogin(key, password);
        }
        if (ecUser != null) {
            request.getSession().setAttribute("current_EcUser", ecUser);
            resultMap.put("sessionId", request.getSession().getId());
            resultMap.put("res", "yes");
            resultMap.put("user",ecUser);
        } else {
            resultMap.put("res", "no");
        }
        return resultMap;
    }

    /**
     * 注册
     *
     * @param map     ModelMap
     * @param request 注册信息
     * @return 是否注册成功
     * @throws Exception 异常捕获
     */
    @ResponseBody
    @RequestMapping("/regedit")
    public Map<String, Object> ecUserRegedit(ModelMap map, HttpServletRequest request) throws Exception {
        Map<String, Object> resultMap = new HashMap<String, Object>(16);
        EcUser ecUser = new EcUser();
        String str = request.getParameter("userWxId");
        if (str != null) {
            ecUser.setUserWxId(str);
        }
        str = request.getParameter("userName");
        if (str != null) {
            ecUser.setUserName(str);
            System.out.println(str);
        }
        str = request.getParameter("userTrueName");
        if (str != null) {
            ecUser.setUserTrueName(str);
            System.out.println(str);
        }
        str = request.getParameter("userNum");
        if (str != null) {
            ecUser.setUserNum(str);
        }
        str = request.getParameter("userSex");
        if (str != null) {
            ecUser.setUserSex(Integer.parseInt(str));
        }
        str = request.getParameter("userSchool");
        if (str != null) {
            ecUser.setUserSchool(str);
        }
        str = request.getParameter("userSdept");
        if (str != null) {
            ecUser.setUserSdept(str);
        }
        str = request.getParameter("userBirth");
        if (str != null) {
            ecUser.setUserBirth(DateUtil.fomatDate(str));
        }
        str = request.getParameter("userPassWord");
        if (str != null) {
            ecUser.setUserPassword(str);
        }
        str = request.getParameter("userPhone");
        if (str != null) {
            ecUser.setUserPhone(str);
        }
        str = request.getParameter("userType");
        if (str != null) {
            ecUser.setUserType(Integer.parseInt(str));
        }
        ecUser.setUserCreatTime(new Date());
        str = request.getParameter("userEmail");
        if (str != null) {
            ecUser.setUserEmail(str);
        }
        str = request.getParameter("userFaviconUrl");
        if (str != null) {
            ecUser.setUserFaviconUrl(str);
        }
        ecUserService.saveEcUser(ecUser);
        resultMap.put("res", "yes");
        return resultMap;
    }

    /**
     * 修改个人信息
     *
     * @param map     ModelMap
     * @param request 修改的信息
     * @return 是否修改成功
     * @throws Exception 异常捕获
     */
    @ResponseBody
    @RequestMapping("/updateInfo")
    public Map<String, Object> ecUserUpdate(ModelMap map, HttpServletRequest request) throws Exception {
        Map<String, Object> resultMap = new HashMap<String, Object>(16);
        EcUser ecUser = (EcUser) request.getSession().getAttribute("current_EcUser");
        String str = request.getParameter("userWxId");
        if (str != null) {
            ecUser.setUserWxId(str);
        }
        str = request.getParameter("userName");
        if (str != null) {
            ecUser.setUserName(str);
        }
        str = request.getParameter("userNum");
        if (str != null) {
            ecUser.setUserNum(str);
        }
        str = request.getParameter("userSex");
        if (str != null) {
            ecUser.setUserSex(Integer.parseInt(str));
        }
        str = request.getParameter("userSchool");
        if (str != null) {
            ecUser.setUserSchool(str);
        }
        str = request.getParameter("userSdept");
        if (str != null) {
            ecUser.setUserSdept(str);
        }
        str = request.getParameter("userBirth");
        if (str != null) {
            ecUser.setUserBirth(DateUtil.fomatDate(str));
        }
        str = request.getParameter("userPhone");
        if (str != null) {
            ecUser.setUserPhone(str);
        }
        str = request.getParameter("userType");
        if (str != null) {
            ecUser.setUserType(Integer.parseInt(str));
        }
        ecUser.setUserCreatTime(new Date());
        str = request.getParameter("userEmail");
        if (str != null) {
            ecUser.setUserEmail(str);
        }
        ecUserService.updateEcUser(ecUser);
        request.getSession().setAttribute("current_EcUser", ecUser);
        resultMap.put("sessionId", request.getSession().getId());
        resultMap.put("res", "yes");
        return resultMap;
    }

    /**
     * 个人设置修改密码
     *
     * @param map     ModelMap
     * @param request 修改的信息
     * @return 是否修改成功
     * @throws Exception 异常捕获
     */
    @ResponseBody
    @RequestMapping("/updatePassword_info")
    public Map<String, Object> ecUserUpdatePasswordInfo(ModelMap map, HttpServletRequest request) throws Exception {
        Map<String, Object> resultMap = new HashMap<String, Object>(16);
        //String str = request.getParameter("userWxId");
        //EcUser ecUser = (EcUser) request.getSession().getAttribute("current_EcUser");
        String userId=request.getParameter("userId");
        EcUser ecUser=ecUserService.findEcUserById(Integer.parseInt(userId));
        String str1 = request.getParameter("passWord");
        if (ecUser!=null) {

            ecUser.setUserPassword(str1);
            ecUserService.updateEcUser(ecUser);
            resultMap.put("res", "yes");
        } else {
            resultMap.put("res", "no");
        }
        return resultMap;
    }

    /**
     * 忘记密码验证
     *
     * @param map     ModelMap
     * @param request 验证密码填写的信息
     * @return 是否验证成功成功
     * @throws Exception 异常捕获
     */
    @ResponseBody
    @RequestMapping("/forgetPassword")
    public Map<String, Object> ecUserForgetPassword(ModelMap map, HttpServletRequest request) throws Exception {
        Map<String, Object> resultMap = new HashMap<String, Object>(16);

        String userName = request.getParameter("userName");
        String userPhone = request.getParameter("phoneId");
        String userEmail = request.getParameter("mailId");

        EcUser ecUser;
        ecUser = (EcUser) ecUserService.findEcUserByPhandMa(userEmail,userPhone);
        if (ecUser != null) {
            int userId=ecUser.getUserId();
            resultMap.put("userId",userId);
            resultMap.put("res", "yes");
            System.out.println(ecUser.getUserId());
            return resultMap;
        }
        else{
            resultMap.put("res","no");
            return resultMap;
        }
    }
        /*String str = request.getParameter("userWxId");

        EcUser ecUser = ecUserService.findEcUserByWxId(Integer.parseInt(str));
        str = request.getParameter("userName");
        if (str == null || ecUser.getUserName().equals(str)) {
            resultMap.put("res", "no");
            return resultMap;
        }
        str = request.getParameter("userNum");
        if (str == null || ecUser.getUserNum().equals(str)) {
            resultMap.put("res", "no");
            return resultMap;
        }
        str = request.getParameter("userPhone");
        if (str == null || ecUser.getUserPhone().equals(str)) {
            resultMap.put("res", "no");
            return resultMap;
        }
        str = request.getParameter("userEmail");
        if (str == null || ecUser.getUserEmail().equals(str)) {
            resultMap.put("res", "no");
            return resultMap;
        }
        resultMap.put("res", "yes");
        return resultMap;*/


    /**
     * 忘记密码验证成功后修改密码
     *
     * @param map     ModelMap
     * @param request 修改的信息
     * @return 是否修改成功
     * @throws Exception 异常捕获
     */
    @ResponseBody
    @RequestMapping("/updatePassword_forget")
    public Map<String, Object> ecUserUpdatePasswordForget(ModelMap map, HttpServletRequest request) throws Exception {
        Map<String, Object> resultMap = new HashMap<String, Object>(16);
//        String str = request.getParameter("userWxId");
//        EcUser ecUser = ecUserService.findEcUserByWxId(Integer.parseInt(str));
        String str= request.getParameter("ecUserId");
        System.out.println(str);
        EcUser ecUser = ecUserService.findEcUserById(Integer.parseInt(str));
        System.out.println(ecUser.getUserPassword());
        str = request.getParameter("userPassword");
        System.out.println(str);
        /*str = AESUtil.HMACSHA256(str, "ecourse");*/
        ecUser.setUserPassword(str);
        ecUserService.updateEcUser(ecUser);
        request.getSession().setAttribute("current_EcUser", ecUser);
        resultMap.put("sessionId", request.getSession().getId());
        resultMap.put("res", "yes");
        return resultMap;
    }
}
