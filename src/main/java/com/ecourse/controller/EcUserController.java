package com.ecourse.controller;

import com.ecourse.entity.EcUser;
import com.ecourse.service.EcUserService;
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
 * @create 2017-12-15 下午3:47
 */
@Controller
@RequestMapping("/user")
public class EcUserController {

    @Autowired
    private EcUserService ecUserService;

    @ResponseBody
    @RequestMapping("/login")
    public Map<String, Object> ecUserLogin(ModelMap map, HttpServletRequest request) throws Exception {
        Map<String, Object> resultMap = new HashMap<String, Object>();
        String password = request.getParameter("password");
        int id = Integer.parseInt(request.getParameter("ecUserId"));
        EcUser ecUser  = ecUserService.findEcUserByLogin(id, password);
        if (ecUser != null) {
            //resultMap.put("wxid", ecUser);
            resultMap.put("res", "yes11");
        } else {
            resultMap.put("res", "no");
        }
        return resultMap;
    }
}
