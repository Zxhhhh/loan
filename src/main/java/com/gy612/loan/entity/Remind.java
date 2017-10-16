
package com.gy612.loan.entity;

import java.util.Date;

public class Remind {
    private String id;

    private Byte remindType;

    private Byte remindState;

    private Date createDate;

    private String userId;

    private String remindContent;

    
    public Remind() {
		super();
		// TODO Auto-generated constructor stub
	}
    
	public Remind(String id, Byte remindType, Byte remindState,
			String userId, String remindContent) {
		super();
		this.id = id;
		this.remindType = remindType;
		this.remindState = remindState;
		this.userId = userId;
		this.remindContent = remindContent;
	}


	public Remind(Byte remindType, Byte remindState, String userId,
			String remindContent) {
		super();
		this.remindType = remindType;
		this.remindState = remindState;
		this.userId = userId;
		this.remindContent = remindContent;
	}

	public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id == null ? null : id.trim();
    }

    public Byte getRemindType() {
        return remindType;
    }

    public void setRemindType(Byte remindType) {
        this.remindType = remindType;
    }

    public Byte getRemindState() {
        return remindState;
    }

    public void setRemindState(Byte remindState) {
        this.remindState = remindState;
    }

    public Date getCreateDate() {
        return createDate;
    }

    public void setCreateDate(Date createDate) {
        this.createDate = createDate;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId == null ? null : userId.trim();
    }

    public String getRemindContent() {
        return remindContent;
    }

    public void setRemindContent(String remindContent) {
        this.remindContent = remindContent == null ? null : remindContent.trim();
    }
}