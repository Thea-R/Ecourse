package com.ecourse.controller;

import com.ecourse.entity.EcUnderstand;
import com.ecourse.entity.EcUnderstandSelect;
import com.ecourse.entity.EcUser;
import com.ecourse.service.EcUnderstandSelectService;
import com.ecourse.service.EcUnderstandService;
import com.ecourse.service.EcUserService;
import com.ecourse.untils.AccountValidatorUtil;
//import com.ecourse.untils.DateUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import java.util.*;

@Controller
@RequestMapping("/understand")
public class EcUnderstandController {

    @Autowired
    private EcUnderstandService ecUnderstandService;
    @Autowired
    private EcUnderstandSelectService ecUnderstandSelectService;
    @Autowired
    private EcUserService ecUserService;

    /**
     * 教师设置不懂按钮
     *
     * @param map ModelMap
     * @param request 用户名，密码
     * @return 是否登陆成功
     * @throws Exception 异常捕获
     */
    @ResponseBody
    @RequestMapping("/teasettime")
    public  Map<String, Object> ecUnderstandSetnum(ModelMap map, HttpServletRequest request) throws Exception{
        Map<String, Object> resultMap = new HashMap<String, Object>(16);
        EcUnderstand ecUnderstand = new EcUnderstand();
        String str = request.getParameter("num");
        //System.out.println(str);
        if (str != null){
            ecUnderstand.setUndMaximum(Integer.parseInt(str));
        }

        ecUnderstand.setCourseId(123);//后面用session获取
        ecUnderstand.setUndTime(new Date());//设置创建时间

        ecUnderstandService.saveEcUnderstand(ecUnderstand);
        resultMap.put("res", "yes");
        return resultMap;
    }

    /**
     * 教师查看不懂人数
     *
     * @param map ModelMap
     * @param request 用户名，密码
     * @return 是否登陆成功
     * @throws Exception 异常捕获
     */
    @ResponseBody
    @RequestMapping("/teagetnum")
    public  Map<String, Object> ecUnderstandGetnum(ModelMap map, HttpServletRequest request) throws Exception{
        Map<String, Object> resultMap = new HashMap<String, Object>(16);
        Map<String, Object> findMap = new HashMap<String, Object>();
        Map<String, Object> findMap1 = new HashMap<String, Object>();
        Map<String, Object> findMap2 = new HashMap<String, Object>();
        List<EcUnderstandSelect> ecUnderstandSelects = new ArrayList<EcUnderstandSelect>();
        List<EcUser> ecUsers=new ArrayList<EcUser>();

        //查understand表中对象总个数
        List<EcUnderstand> ecUnderstands=new ArrayList<EcUnderstand>();
        ecUnderstands=ecUnderstandService.findEcUnderstand(findMap1);

        //根据最大undid查不懂学生数
        int max=ecUnderstands.size()-1;
        if(max>=0){
            int undId=ecUnderstands.get(max).getUndId();
            findMap.put("undId",undId);
            ecUnderstandSelects=ecUnderstandSelectService.findEcUnderstandSelect(findMap);
            resultMap.put("res",ecUnderstandSelects.size());

            //打印不懂学生列表
            EcUser e=new EcUser();
            for(int i=0;i<ecUnderstandSelects.size();i++){
                e=ecUserService.findEcUserById(ecUnderstandSelects.get(i).getUserId());
                ecUsers.add(e);
            }
            resultMap.put("stulist",ecUsers);

            //resultMap.put("list",ecUnderstandSelects);
            //System.out.println(ecUnderstandSelects.get(0).getUserId());
            return resultMap;
        }
        else{
            resultMap.put("res",0);
            return resultMap;
        }
    }

    /**
     * 学生点击不懂按钮
     *
     * @param map ModelMap
     * @param request 用户名，密码
     * @return 是否登陆成功
     * @throws Exception 异常捕获
     */
    @ResponseBody
    @RequestMapping("/stuclinkud")
    public  Map<String, Object> ecUnderstandselectClinkud(ModelMap map, HttpServletRequest request) throws Exception{
        int flag=0;
        Map<String, Object> resultMap = new HashMap<String, Object>(16);
        Map<String, Object> findMap = new HashMap<String, Object>();
        Map<String, Object> findMap1 = new HashMap<String, Object>();
        EcUnderstandSelect ecUnderstandSelect = new EcUnderstandSelect();
        //EcUser ecUser = (EcUser) request.getSession().getAttribute("current_EcUser");

        //获取不懂值即0
        String str = request.getParameter("udtype");
        System.out.println(str);
        if (str != null){
            ecUnderstandSelect.setUndType(Integer.parseInt(str));
        }

        //查最大undid并设置undid
        List<EcUnderstand> ecUnderstands=new ArrayList<EcUnderstand>();
        ecUnderstands=ecUnderstandService.findEcUnderstand(findMap);
        int max=ecUnderstands.size()-1;
        int undId=ecUnderstands.get(max).getUndId();
        ecUnderstandSelect.setUndId(undId);


        //获取学生用户的userId，后面用session获取
        //ecUnderstandSelect.setUserId(ecUser.getUserId());
        int userid=999;
        ecUnderstandSelect.setUserId(userid);

        //判断understandselect表中是否已经存在该键值
        List<EcUnderstandSelect> ecUnderstandSelects=new ArrayList<EcUnderstandSelect>();
        ecUnderstandSelects=ecUnderstandSelectService.findEcUnderstandSelect(findMap1);
        for(int i=0;i<ecUnderstandSelects.size();i++){
            if(ecUnderstandSelects.get(i).getUndId()==undId&&ecUnderstandSelects.get(i).getUserId()==userid)
                flag=1;
        }

        if(flag==0){
            ecUnderstandSelectService.saveEcUnderstandSelect(ecUnderstandSelect);
            resultMap.put("res", 1);
        }
        else{
            resultMap.put("res",0);
        }

        return resultMap;
    }

}
