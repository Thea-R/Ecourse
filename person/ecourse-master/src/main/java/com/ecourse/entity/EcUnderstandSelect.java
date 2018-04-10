package com.ecourse.entity;

import javax.persistence.*;

/**
 * @author tomato
 * @create 2017-12-18 下午4:59
 */
@Entity
@Table(name = "ec_understand_select", schema = "ecourse")
@IdClass(EcUnderstandSelectPK.class)
public class EcUnderstandSelect {
    private int undId;
    private int userId;
    private Integer undType;

    @Id
    @Column(name = "Und_Id", nullable = false)
    public int getUndId() {
        return undId;
    }

    public void setUndId(int undId) {
        this.undId = undId;
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
    @Column(name = "Und_Type", nullable = false)
    public Integer getUndType() {
        return undType;
    }

    public void setUndType(Integer undType) {
        this.undType = undType;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }

        EcUnderstandSelect that = (EcUnderstandSelect) o;

        if (undId != that.undId) {
            return false;
        }
        if (userId != that.userId) {
            return false;
        }
        if (undType != null ? !undType.equals(that.undType) : that.undType != null) {
            return false;
        }

        return true;
    }

    @Override
    public int hashCode() {
        int result = undId;
        result = 31 * result + userId;
        result = 31 * result + (undType != null ? undType.hashCode() : 0);
        return result;
    }
}
