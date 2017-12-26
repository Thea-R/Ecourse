package com.ecourse.entity;

import javax.persistence.*;
import java.util.Date;

/**
 * @author tomato
 * @create 2017-12-20 下午7:36
 */
@Entity
@Table(name = "ec_question", schema = "ecourse")
public class EcQuestion {
    private int queId;
    private Integer courseId;
    private Integer queType;
    private Integer queState;
    private Integer queAns;
    private String queTitle;    //以此值存储答题时间
    private Date queTime;

    @Id
    @Column(name = "Que_Id", nullable = false)
    public int getQueId() {
        return queId;
    }

    public void setQueId(int queId) {
        this.queId = queId;
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
    @Column(name = "Que_Type", nullable = true)
    public Integer getQueType() {
        return queType;
    }

    public void setQueType(Integer queType) {
        this.queType = queType;
    }

    @Basic
    @Column(name = "Que_State", nullable = true)
    public Integer getQueState() {
        return queState;
    }

    public void setQueState(Integer queState) {
        this.queState = queState;
    }

    @Basic
    @Column(name = "Que_Ans", nullable = true)
    public Integer getQueAns() {
        return queAns;
    }

    public void setQueAns(Integer queAns) {
        this.queAns = queAns;
    }

    @Basic
    @Column(name = "Que_Title", nullable = true, length = 255)
    public String getQueTitle() {
        return queTitle;
    }

    public void setQueTitle(String queTitle) {
        this.queTitle = queTitle;
    }

    @Basic
    @Column(name = "Que_Time", nullable = true)
    public Date getQueTime() {
        return queTime;
    }

    public void setQueTime(Date queTime) {
        this.queTime = queTime;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }

        EcQuestion that = (EcQuestion) o;

        if (queId != that.queId) {
            return false;
        }
        if (courseId != null ? !courseId.equals(that.courseId) : that.courseId != null) {
            return false;
        }
        if (queType != null ? !queType.equals(that.queType) : that.queType != null) {
            return false;
        }
        if (queState != null ? !queState.equals(that.queState) : that.queState != null) {
            return false;
        }
        if (queAns != null ? !queAns.equals(that.queAns) : that.queAns != null) {
            return false;
        }
        if (queTitle != null ? !queTitle.equals(that.queTitle) : that.queTitle != null) {
            return false;
        }
        if (queTime != null ? !queTime.equals(that.queTime) : that.queTime != null) {
            return false;
        }

        return true;
    }

    @Override
    public int hashCode() {
        int result = queId;
        result = 31 * result + (courseId != null ? courseId.hashCode() : 0);
        result = 31 * result + (queType != null ? queType.hashCode() : 0);
        result = 31 * result + (queState != null ? queState.hashCode() : 0);
        result = 31 * result + (queAns != null ? queAns.hashCode() : 0);
        result = 31 * result + (queTitle != null ? queTitle.hashCode() : 0);
        result = 31 * result + (queTime != null ? queTime.hashCode() : 0);
        return result;
    }
}
