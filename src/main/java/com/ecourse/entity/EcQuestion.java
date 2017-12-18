package com.ecourse.entity;

import javax.persistence.*;

/**
 * @author tomato
 * @create 2017-12-18 下午4:59
 */
@Entity
@Table(name = "ec_question", schema = "ecourse")
public class EcQuestion {
    private int queId;
    private Integer queType;
    private Integer queAns;
    private String queTitle;

    @Id
    @Column(name = "Que_Id", nullable = false)
    public int getQueId() {
        return queId;
    }

    public void setQueId(int queId) {
        this.queId = queId;
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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        EcQuestion that = (EcQuestion) o;

        if (queId != that.queId) return false;
        if (queType != null ? !queType.equals(that.queType) : that.queType != null) return false;
        if (queAns != null ? !queAns.equals(that.queAns) : that.queAns != null) return false;
        if (queTitle != null ? !queTitle.equals(that.queTitle) : that.queTitle != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = queId;
        result = 31 * result + (queType != null ? queType.hashCode() : 0);
        result = 31 * result + (queAns != null ? queAns.hashCode() : 0);
        result = 31 * result + (queTitle != null ? queTitle.hashCode() : 0);
        return result;
    }
}
