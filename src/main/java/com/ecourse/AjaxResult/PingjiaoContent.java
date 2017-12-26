package com.ecourse.AjaxResult;

/**
 * Created by biggf on 2017/12/25.
 */
public class PingjiaoContent {
    private float star;
    private int courseId;
    private String courseName;
    private int isPingjiao;

    public PingjiaoContent(int star, int courseId, String courseName, int isPingjiao) {
        this.star = star;
        this.courseId = courseId;
        this.courseName = courseName;
        this.isPingjiao = isPingjiao;
    }
    public PingjiaoContent(){}
    public float getStar() {
        return star;
    }

    public void setStar(float star) {
        this.star = star;
    }

    public int getCourseId() {
        return courseId;
    }

    public void setCourseId(int courseId) {
        this.courseId = courseId;
    }

    public String getCourseName() {
        return courseName;
    }

    public void setCourseName(String courseName) {
        this.courseName = courseName;
    }


    public int getIsPingjiao() {
        return isPingjiao;
    }

    public void setIsPingjiao(int isPingjiao) {
        this.isPingjiao = isPingjiao;
    }
}
