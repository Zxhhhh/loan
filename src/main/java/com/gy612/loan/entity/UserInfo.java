package com.gy612.loan.entity;

public class UserInfo {
    private String id;

    private String userRealname;

    private String userPhone;

    private String userAddr;

    private String userSex;

    private Integer userAge;

    private String userLogo;

    private String userIdentitynum;

    private String userIdentitypic;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id == null ? null : id.trim();
    }

    public String getUserRealname() {
        return userRealname;
    }

    public void setUserRealname(String userRealname) {
        this.userRealname = userRealname == null ? null : userRealname.trim();
    }

    public String getUserPhone() {
        return userPhone;
    }

    public void setUserPhone(String userPhone) {
        this.userPhone = userPhone == null ? null : userPhone.trim();
    }

    public String getUserAddr() {
        return userAddr;
    }

    public void setUserAddr(String userAddr) {
        this.userAddr = userAddr == null ? null : userAddr.trim();
    }

    public String getUserSex() {
        return userSex;
    }

    public void setUserSex(String userSex) {
        this.userSex = userSex == null ? null : userSex.trim();
    }

    public Integer getUserAge() {
        return userAge;
    }

    public void setUserAge(Integer userAge) {
        this.userAge = userAge;
    }

    public String getUserLogo() {
        return userLogo;
    }

    public void setUserLogo(String userLogo) {
        this.userLogo = userLogo == null ? null : userLogo.trim();
    }

    public String getUserIdentitynum() {
        return userIdentitynum;
    }

    public void setUserIdentitynum(String userIdentitynum) {
        this.userIdentitynum = userIdentitynum == null ? null : userIdentitynum.trim();
    }

    public String getUserIdentitypic() {
        return userIdentitypic;
    }

    public void setUserIdentitypic(String userIdentitypic) {
        this.userIdentitypic = userIdentitypic == null ? null : userIdentitypic.trim();
    }
}