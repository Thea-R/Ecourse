package com.ecourse.entity;

import javax.persistence.*;
import java.util.Date;

/**
 * @author tomato
 * @create 2017-12-18 下午4:59
 */
@Entity
@Table(name = "ec_check", schema = "ecourse")
public class EcCheck {
    private int checkId;
    private Date checkTime;
    private Integer courseId;
    private String checkVerify;

    @Id
    @Column(name = "Check_Id", nullable = false)
    public int getCheckId() {
        return checkId;
    }

    public void setCheckId(int checkId) {
        this.checkId = checkId;
    }

    @Basic
    @Column(name = "Check_Time", nullable = true)
    public Date getCheckTime() {
        return checkTime;
    }

    public void setCheckTime(Date checkTime) {
        this.checkTime = checkTime;
    }

    @Basic
    @Column(name = "Course_Id", nullable = true)
    public Integer getCourseId() {
        return courseId;
    }

    public void setCourseId(Integer courseId) {
        this.courseId = courseId;
    }

    @Basic
    @Column(name = "Check_Verify", nullable = true, length = 20)
    public String getCheckVerify() {
        return checkVerify;
    }

    public void setCheckVerify(String checkVerify) {
        this.checkVerify = checkVerify;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }

        EcCheck ecCheck = (EcCheck) o;

        if (checkId != ecCheck.checkId) {
            return false;
        }
        if (checkTime != null ? !checkTime.equals(ecCheck.checkTime) : ecCheck.checkTime != null) {
            return false;
        }
        if (courseId != null ? !courseId.equals(ecCheck.courseId) : ecCheck.courseId != null) {
            return false;
        }
        if (checkVerify != null ? !checkVerify.equals(ecCheck.checkVerify) : ecCheck.checkVerify != null) {
            return false;
        }

        return true;
    }

    @Override
    public int hashCode() {
        int result = checkId;
        result = 31 * result + (checkTime != null ? checkTime.hashCode() : 0);
        result = 31 * result + (courseId != null ? courseId.hashCode() : 0);
        result = 31 * result + (checkVerify != null ? checkVerify.hashCode() : 0);
        return result;
    }
}
