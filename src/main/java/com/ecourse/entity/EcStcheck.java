package com.ecourse.entity;

import javax.persistence.*;

/**
 * @author tomato
 * @create 2017-12-18 下午4:59
 */
@Entity
@Table(name = "ec_stcheck", schema = "ecourse")
@IdClass(EcStcheckPK.class)
public class EcStcheck {
    private int checkId;
    private int userId;
    private Integer checkType;

    @Id
    @Column(name = "Check_Id", nullable = false)
    public int getCheckId() {
        return checkId;
    }

    public void setCheckId(int checkId) {
        this.checkId = checkId;
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
    @Column(name = "Check_type", nullable = true)
    public Integer getCheckType() {
        return checkType;
    }

    public void setCheckType(Integer checkType) {
        this.checkType = checkType;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        EcStcheck ecStcheck = (EcStcheck) o;

        if (checkId != ecStcheck.checkId) return false;
        if (userId != ecStcheck.userId) return false;
        if (checkType != null ? !checkType.equals(ecStcheck.checkType) : ecStcheck.checkType != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = checkId;
        result = 31 * result + userId;
        result = 31 * result + (checkType != null ? checkType.hashCode() : 0);
        return result;
    }
}
