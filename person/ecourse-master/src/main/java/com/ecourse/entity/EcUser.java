package com.ecourse.entity;

import javax.persistence.*;
import java.util.Date;

/**
 * @author tomato
 * @create 2017-12-18 下午4:59
 */
@Entity
@Table(name = "ec_user", schema = "ecourse")
public class EcUser {
    private int userId;
    private String userPassword;
    private String userWxId;
    private String userName;
    private String userNum;
    private Integer userSex;
    private String userSchool;
    private String userSdept;
    private Date userBirth;
    private String userPhone;
    private Integer userType;
    private Date userCreatTime;
    private String userEmail;
    private String userFaviconUrl;
    private String userTrueName;

    @Id
    @Column(name = "User_Id", nullable = false)
    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    @Basic
    @Column(name = "User_Password", nullable = false, length = 255)
    public String getUserPassword() {
        return userPassword;
    }

    public void setUserPassword(String userPassword) {
        this.userPassword = userPassword;
    }

    @Basic
    @Column(name = "User_wxId", nullable = false, length = 64)
    public String getUserWxId() {
        return userWxId;
    }

    public void setUserWxId(String userWxId) {
        this.userWxId = userWxId;
    }

    @Basic
    @Column(name = "User_Name", nullable = true, length = 20)
    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    @Basic
    @Column(name = "User_Num", nullable = true, length = 64)
    public String getUserNum() {
        return userNum;
    }

    public void setUserNum(String userNum) {
        this.userNum = userNum;
    }

    @Basic
    @Column(name = "User_Sex", nullable = true)
    public Integer getUserSex() {
        return userSex;
    }

    public void setUserSex(Integer userSex) {
        this.userSex = userSex;
    }

    @Basic
    @Column(name = "User_School", nullable = true, length = 100)
    public String getUserSchool() {
        return userSchool;
    }

    public void setUserSchool(String userSchool) {
        this.userSchool = userSchool;
    }

    @Basic
    @Column(name = "User_Sdept", nullable = true, length = 100)
    public String getUserSdept() {
        return userSdept;
    }

    public void setUserSdept(String userSdept) {
        this.userSdept = userSdept;
    }

    @Basic
    @Column(name = "User_Birth", nullable = true)
    public Date getUserBirth() {
        return userBirth;
    }

    public void setUserBirth(Date userBirth) {
        this.userBirth = userBirth;
    }

    @Basic
    @Column(name = "User_Phone", nullable = true, length = 15)
    public String getUserPhone() {
        return userPhone;
    }

    public void setUserPhone(String userPhone) {
        this.userPhone = userPhone;
    }

    @Basic
    @Column(name = "User_Type", nullable = true)
    public Integer getUserType() {
        return userType;
    }

    public void setUserType(Integer userType) {
        this.userType = userType;
    }

    @Basic
    @Column(name = "User_CreatTime", nullable = true)
    public Date getUserCreatTime() {
        return userCreatTime;
    }

    public void setUserCreatTime(Date userCreatTime) {
        this.userCreatTime = userCreatTime;
    }

    @Basic
    @Column(name = "User_Email", nullable = true, length = 50)
    public String getUserEmail() {
        return userEmail;
    }

    public void setUserEmail(String userEmail) {
        this.userEmail = userEmail;
    }

    @Basic
    @Column(name = "User_FaviconUrl", nullable = true, length = 255)
    public String getUserFaviconUrl() {
        return userFaviconUrl;
    }

    public void setUserFaviconUrl(String userFaviconUrl) {
        this.userFaviconUrl = userFaviconUrl;
    }

    @Basic
    @Column(name = "User_TrueName", nullable = true, length = 255)
    public String getUserTrueName() {
        return userTrueName;
    }

    public void setUserTrueName(String userTrueName) {
        this.userTrueName = userTrueName;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }

        EcUser ecUser = (EcUser) o;

        if (userId != ecUser.userId) {
            return false;
        }
        if (userPassword != null ? !userPassword.equals(ecUser.userPassword) : ecUser.userPassword != null) {
            return false;
        }
        if (userWxId != null ? !userWxId.equals(ecUser.userWxId) : ecUser.userWxId != null) {
            return false;
        }
        if (userName != null ? !userName.equals(ecUser.userName) : ecUser.userName != null) {
            return false;
        }
        if (userNum != null ? !userNum.equals(ecUser.userNum) : ecUser.userNum != null) {
            return false;
        }
        if (userSex != null ? !userSex.equals(ecUser.userSex) : ecUser.userSex != null) {
            return false;
        }
        if (userSchool != null ? !userSchool.equals(ecUser.userSchool) : ecUser.userSchool != null) {
            return false;
        }
        if (userSdept != null ? !userSdept.equals(ecUser.userSdept) : ecUser.userSdept != null) {
            return false;
        }
        if (userBirth != null ? !userBirth.equals(ecUser.userBirth) : ecUser.userBirth != null) {
            return false;
        }
        if (userPhone != null ? !userPhone.equals(ecUser.userPhone) : ecUser.userPhone != null) {
            return false;
        }
        if (userType != null ? !userType.equals(ecUser.userType) : ecUser.userType != null) {
            return false;
        }
        if (userCreatTime != null ? !userCreatTime.equals(ecUser.userCreatTime) : ecUser.userCreatTime != null) {
            return false;
        }
        if (userEmail != null ? !userEmail.equals(ecUser.userEmail) : ecUser.userEmail != null) {
            return false;
        }
        if (userFaviconUrl != null ? !userFaviconUrl.equals(ecUser.userFaviconUrl) : ecUser.userFaviconUrl != null) {
            return false;
        }
        if (userTrueName != null ? !userTrueName.equals(ecUser.userTrueName) : ecUser.userTrueName != null) {
            return false;
        }

        return true;
    }

    @Override
    public int hashCode() {
        int result = userId;
        result = 31 * result + (userPassword != null ? userPassword.hashCode() : 0);
        result = 31 * result + (userWxId != null ? userWxId.hashCode() : 0);
        result = 31 * result + (userName != null ? userName.hashCode() : 0);
        result = 31 * result + (userNum != null ? userNum.hashCode() : 0);
        result = 31 * result + (userSex != null ? userSex.hashCode() : 0);
        result = 31 * result + (userSchool != null ? userSchool.hashCode() : 0);
        result = 31 * result + (userSdept != null ? userSdept.hashCode() : 0);
        result = 31 * result + (userBirth != null ? userBirth.hashCode() : 0);
        result = 31 * result + (userPhone != null ? userPhone.hashCode() : 0);
        result = 31 * result + (userType != null ? userType.hashCode() : 0);
        result = 31 * result + (userCreatTime != null ? userCreatTime.hashCode() : 0);
        result = 31 * result + (userEmail != null ? userEmail.hashCode() : 0);
        result = 31 * result + (userFaviconUrl != null ? userFaviconUrl.hashCode() : 0);
        result = 31 * result + (userTrueName != null ? userTrueName.hashCode() : 0);
        return result;
    }
}
