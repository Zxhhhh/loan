package com.gy612.loan.entity;

public class UserRole {
    private String id;

    private Integer roleLevel;

    private String userId;

    private String typeId;

    public UserRole() {
		super();
		// TODO Auto-generated constructor stub
	}
    
	public UserRole(String id, Integer roleLevel, String userId, String typeId) {
		super();
		this.id = id;
		this.roleLevel = roleLevel;
		this.userId = userId;
		this.typeId = typeId;
	}



	public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id == null ? null : id.trim();
    }

    public Integer getRoleLevel() {
        return roleLevel;
    }

    public void setRoleLevel(Integer roleLevel) {
        this.roleLevel = roleLevel;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId == null ? null : userId.trim();
    }

    public String getTypeId() {
        return typeId;
    }

    public void setTypeId(String typeId) {
        this.typeId = typeId == null ? null : typeId.trim();
    }
}