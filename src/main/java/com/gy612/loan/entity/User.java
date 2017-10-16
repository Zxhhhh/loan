package com.gy612.loan.entity;

import java.util.Date;

public class User {
    private String id;

    private String username;

    private String password;

    private String usermail;

    private String salt;

    private Date createDate;

    private String infoId;

    private String secureId;

    private String stateId;

    private Byte isActivate;

    public String getId() {
        return id;
    }
    

    public User() {
		super();
		// TODO Auto-generated constructor stub
	}
    

	public User(String id, String username, String password, String usermail,
			String salt) {
		super();
		this.id = id;
		this.username = username;
		this.password = password;
		this.usermail = usermail;
		this.salt = salt;
	}


	public void setId(String id) {
        this.id = id == null ? null : id.trim();
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username == null ? null : username.trim();
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password == null ? null : password.trim();
    }

    public String getUsermail() {
        return usermail;
    }

    public void setUsermail(String usermail) {
        this.usermail = usermail == null ? null : usermail.trim();
    }

    public String getSalt() {
        return salt;
    }

    public void setSalt(String salt) {
        this.salt = salt == null ? null : salt.trim();
    }

    public Date getCreateDate() {
        return createDate;
    }

    public void setCreateDate(Date createDate) {
        this.createDate = createDate;
    }

    public String getInfoId() {
        return infoId;
    }

    public void setInfoId(String infoId) {
        this.infoId = infoId == null ? null : infoId.trim();
    }

    public String getSecureId() {
        return secureId;
    }

    public void setSecureId(String secureId) {
        this.secureId = secureId == null ? null : secureId.trim();
    }

    public String getStateId() {
        return stateId;
    }

    public void setStateId(String stateId) {
        this.stateId = stateId == null ? null : stateId.trim();
    }

    public Byte getIsActivate() {
        return isActivate;
    }

    public void setIsActivate(Byte isActivate) {
        this.isActivate = isActivate;
    }

	@Override
	public String toString() {
		return "User [id=" + id + ", username=" + username + ", password="
				+ password + ", usermail=" + usermail + ", salt=" + salt
				+ ", createDate=" + createDate + ", infoId=" + infoId
				+ ", secureId=" + secureId + ", stateId=" + stateId
				+ ", isActivate=" + isActivate + "]";
	}
    
}