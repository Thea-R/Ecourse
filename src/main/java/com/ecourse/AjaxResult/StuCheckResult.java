package com.ecourse.AjaxResult;

import com.ecourse.entity.EcStcheck;

import java.io.Serializable;

/**
 * Ajax返回学生签到情况
 *
 * @author tomato
 * @create 2017-12-22 下午2:28
 */
public class StuCheckResult implements Serializable {
    private int checkId;
    private int userId;
    private Integer checkType;
    private String userName;
    private String userFaviconUrl;

    public int getCheckId() {
        return checkId;
    }

    public void setCheckId(int checkId) {
        this.checkId = checkId;
    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public Integer getCheckType() {
        return checkType;
    }

    public void setCheckType(Integer checkType) {
        this.checkType = checkType;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getUserFaviconUrl() {
        return userFaviconUrl;
    }

    public void setUserFaviconUrl(String userFaviconUrl) {
        this.userFaviconUrl = userFaviconUrl;
    }

    public void setEcStcheck(EcStcheck ecStcheck) {
        checkId = ecStcheck.getCheckId();
        userId = ecStcheck.getUserId();
        checkType = ecStcheck.getCheckType();
    }
}
