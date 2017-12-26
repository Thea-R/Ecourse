package com.ecourse.AjaxResult;

import com.ecourse.entity.EcCheck;

import java.io.Serializable;
import java.util.Date;

/**
 * Ajax返回一个课程的所有签到表
 *
 * @author tomato
 * @create 2017-12-22 下午8:02
 */
public class CheckResult implements Serializable {
    private int checkId;
    private Date checkTime;
    private Integer courseId;
    private String checkVerify;
    private Integer checkState;
    private Date checkWeek;
    private Date checkTimeH;
    private Integer checkYesNum;
    private Integer checkAllNum;

    public int getCheckId() {
        return checkId;
    }

    public void setCheckId(int checkId) {
        this.checkId = checkId;
    }

    public Date getCheckTime() {
        return checkTime;
    }

    public void setCheckTime(Date checkTime) {
        this.checkTime = checkTime;
    }

    public Integer getCourseId() {
        return courseId;
    }

    public void setCourseId(Integer courseId) {
        this.courseId = courseId;
    }

    public String getCheckVerify() {
        return checkVerify;
    }

    public void setCheckVerify(String checkVerify) {
        this.checkVerify = checkVerify;
    }

    public Integer getCheckState() {
        return checkState;
    }

    public void setCheckState(Integer checkState) {
        this.checkState = checkState;
    }

    public Date getCheckWeek() {
        return checkWeek;
    }

    public void setCheckWeek(Date checkWeek) {
        this.checkWeek = checkWeek;
    }

    public Date getCheckTimeH() {
        return checkTimeH;
    }

    public void setCheckTimeH(Date checkTimeH) {
        this.checkTimeH = checkTimeH;
    }

    public Integer getCheckYesNum() {
        return checkYesNum;
    }

    public void setCheckYesNum(Integer checkYesNum) {
        this.checkYesNum = checkYesNum;
    }

    public Integer getCheckAllNum() {
        return checkAllNum;
    }

    public void setCheckAllNum(Integer checkAllNum) {
        this.checkAllNum = checkAllNum;
    }

    public void setEcCheck(EcCheck ecCheck) {
        checkId = ecCheck.getCheckId();
        checkTime = ecCheck.getCheckTime();
        courseId = ecCheck.getCourseId();
        checkVerify = ecCheck.getCheckVerify();
        checkState = ecCheck.getCheckState();
        checkWeek = ecCheck.getCheckTime();
        checkTimeH = ecCheck.getCheckTime();
    }
}
