package com.ecourse.entity;

import javax.persistence.*;

/**
 * @author tomato
 * @create 2017-12-18 下午4:59
 */
@Entity
@Table(name = "ec_answer", schema = "ecourse")
public class EcAnswer {
    private int ansId;
    private Integer userId;
    private Integer queId;
    private Integer ansAnswer;

    @Id
    @Column(name = "Ans_Id", nullable = false)
    public int getAnsId() {
        return ansId;
    }

    public void setAnsId(int ansId) {
        this.ansId = ansId;
    }

    @Basic
    @Column(name = "User_Id", nullable = true)
    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    @Basic
    @Column(name = "Que_Id", nullable = true)
    public Integer getQueId() {
        return queId;
    }

    public void setQueId(Integer queId) {
        this.queId = queId;
    }

    @Basic
    @Column(name = "Ans_Answer", nullable = true)
    public Integer getAnsAnswer() {
        return ansAnswer;
    }

    public void setAnsAnswer(Integer ansAnswer) {
        this.ansAnswer = ansAnswer;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }

        EcAnswer ecAnswer = (EcAnswer) o;

        if (ansId != ecAnswer.ansId) {
            return false;
        }
        if (userId != null ? !userId.equals(ecAnswer.userId) : ecAnswer.userId != null) {
            return false;
        }
        if (queId != null ? !queId.equals(ecAnswer.queId) : ecAnswer.queId != null) {
            return false;
        }
        if (ansAnswer != null ? !ansAnswer.equals(ecAnswer.ansAnswer) : ecAnswer.ansAnswer != null) {
            return false;
        }

        return true;
    }

    @Override
    public int hashCode() {
        int result = ansId;
        result = 31 * result + (userId != null ? userId.hashCode() : 0);
        result = 31 * result + (queId != null ? queId.hashCode() : 0);
        result = 31 * result + (ansAnswer != null ? ansAnswer.hashCode() : 0);
        return result;
    }
}
