package com.gy612.loan.entity;

public class AdminRole {
    private String id;

    private Byte roleLevel;

    private String adminId;

    private String typeId;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id == null ? null : id.trim();
    }

    public Byte getRoleLevel() {
        return roleLevel;
    }

    public void setRoleLevel(Byte roleLevel) {
        this.roleLevel = roleLevel;
    }

    public String getAdminId() {
        return adminId;
    }

    public void setAdminId(String adminId) {
        this.adminId = adminId == null ? null : adminId.trim();
    }

    public String getTypeId() {
        return typeId;
    }

    public void setTypeId(String typeId) {
        this.typeId = typeId == null ? null : typeId.trim();
    }
}