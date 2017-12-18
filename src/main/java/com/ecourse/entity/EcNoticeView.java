package com.ecourse.entity;

import javax.persistence.*;
import java.util.Date;

/**
 * @author tomato
 * @create 2017-12-18 下午4:59
 */
@Entity
@Table(name = "ec_notice_view", schema = "ecourse")
@IdClass(EcNoticeViewPK.class)
public class EcNoticeView {
    private int notId;
    private int userId;
    private Date notViewTime;

    @Id
    @Column(name = "Not_Id", nullable = false)
    public int getNotId() {
        return notId;
    }

    public void setNotId(int notId) {
        this.notId = notId;
    }

    @Id
    @Column(name = "User_Id", nullable = false)
    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    @Basic
    @Column(name = "Not_ViewTime", nullable = true)
    public Date getNotViewTime() {
        return notViewTime;
    }

    public void setNotViewTime(Date notViewTime) {
        this.notViewTime = notViewTime;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }

        EcNoticeView that = (EcNoticeView) o;

        if (notId != that.notId) {
            return false;
        }
        if (userId != that.userId) {
            return false;
        }
        if (notViewTime != null ? !notViewTime.equals(that.notViewTime) : that.notViewTime != null) {
            return false;
        }

        return true;
    }

    @Override
    public int hashCode() {
        int result = notId;
        result = 31 * result + userId;
        result = 31 * result + (notViewTime != null ? notViewTime.hashCode() : 0);
        return result;
    }
}
