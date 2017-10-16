
package com.gy612.loan.entity;

import java.util.Date;

public class CompanyLoanInfo {
    private String id;

    private String loanName;

    private String loanContactName;

    private String loanContactPhone;

    private Double loanMoney;

    private Date loanDeadline;

    private Byte loanState;

    private Date createDate;

    private Byte isRepay;

    private String userId;

    private String materialId;

    private String remindContent;

    private Double loanReturnMoney;

    private Date loanRepayDate;

    private Integer loanMonth;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id == null ? null : id.trim();
    }

    public String getLoanName() {
        return loanName;
    }

    public void setLoanName(String loanName) {
        this.loanName = loanName == null ? null : loanName.trim();
    }

    public String getLoanContactName() {
        return loanContactName;
    }

    public void setLoanContactName(String loanContactName) {
        this.loanContactName = loanContactName == null ? null : loanContactName.trim();
    }

    public String getLoanContactPhone() {
        return loanContactPhone;
    }

    public void setLoanContactPhone(String loanContactPhone) {
        this.loanContactPhone = loanContactPhone == null ? null : loanContactPhone.trim();
    }

    public Double getLoanMoney() {
        return loanMoney;
    }

    public void setLoanMoney(Double loanMoney) {
        this.loanMoney = loanMoney;
    }

    public Date getLoanDeadline() {
        return loanDeadline;
    }

    public void setLoanDeadline(Date loanDeadline) {
        this.loanDeadline = loanDeadline;
    }

    public Byte getLoanState() {
        return loanState;
    }

    public void setLoanState(Byte loanState) {
        this.loanState = loanState;
    }

    public Date getCreateDate() {
        return createDate;
    }

    public void setCreateDate(Date createDate) {
        this.createDate = createDate;
    }

    public Byte getIsRepay() {
        return isRepay;
    }

    public void setIsRepay(Byte isRepay) {
        this.isRepay = isRepay;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId == null ? null : userId.trim();
    }

    public String getMaterialId() {
        return materialId;
    }

    public void setMaterialId(String materialId) {
        this.materialId = materialId == null ? null : materialId.trim();
    }

    public String getRemindContent() {
        return remindContent;
    }

    public void setRemindContent(String remindContent) {
        this.remindContent = remindContent == null ? null : remindContent.trim();
    }

    public Double getLoanReturnMoney() {
        return loanReturnMoney;
    }

    public void setLoanReturnMoney(Double loanReturnMoney) {
        this.loanReturnMoney = loanReturnMoney;
    }

    public Date getLoanRepayDate() {
        return loanRepayDate;
    }

    public void setLoanRepayDate(Date loanRepayDate) {
        this.loanRepayDate = loanRepayDate;
    }

    public Integer getLoanMonth() {
        return loanMonth;
    }

    public void setLoanMonth(Integer loanMonth) {
        this.loanMonth = loanMonth;
    }
}