package com.gy612.loan.entity;

public class UserState {
    private String id;

    private Byte isCertification;

    private Byte isFreeze;

    private Byte isShield;
    
    public UserState() {
		super();
		// TODO Auto-generated constructor stub
	}
    
	public UserState(String id, Byte isCertification, Byte isFreeze,
			Byte isShield) {
		super();
		this.id = id;
		this.isCertification = isCertification;
		this.isFreeze = isFreeze;
		this.isShield = isShield;
	}



	public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id == null ? null : id.trim();
    }

    public Byte getIsCertification() {
        return isCertification;
    }

    public void setIsCertification(Byte isCertification) {
        this.isCertification = isCertification;
    }

    public Byte getIsFreeze() {
        return isFreeze;
    }

    public void setIsFreeze(Byte isFreeze) {
        this.isFreeze = isFreeze;
    }

    public Byte getIsShield() {
        return isShield;
    }

    public void setIsShield(Byte isShield) {
        this.isShield = isShield;
    }
}