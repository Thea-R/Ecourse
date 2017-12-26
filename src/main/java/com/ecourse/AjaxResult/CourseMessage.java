package com.ecourse.AjaxResult;

import java.io.Serializable;

/**
 *返回课程信息，对应于评教
 * Created by biggf on 2017/12/24.
 */
public class CourseMessage  implements Serializable {
    private  String courseName;
    private int courseId;
    private int courseScore;


    private int msgOk;

    public int getMsgOk() {
        return msgOk;
    }

    public void setMsgOk(int msgOk) {
        this.msgOk = msgOk;
    }

    public CourseMessage(String courseName, int courseId, int courseScore, int msgok) {
        this.courseName = courseName;
        this.courseId = courseId;
        this.courseScore = courseScore;
        this.msgOk = msgok;
    }

    public CourseMessage(){}




    public String getCourseName() {
        return courseName;
    }

    public void setCourseName(String courseName) {
        this.courseName = courseName;
    }

    public int getCourseId() {
        return courseId;
    }

    public void setCourseId(int courseId) {
        this.courseId = courseId;
    }

    public int getCourseScore() {
        return courseScore;
    }

    public void setCourseScore(int courseScore) {
        this.courseScore = courseScore;
    }


}
