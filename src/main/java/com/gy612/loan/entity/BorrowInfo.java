package com.gy612.loan.entity;

import java.util.Date;

public class BorrowInfo {
    private String id;

    private String borrowContact;

    private String borrowUnit;

    private String borrowFinance;

    private String borrowCompanyName;

    private String borrowCompanyEntity;

    private Double borrowRegisteredCapital;

    private String borrowCompanyLocation;

    private String borrowCompanyCode;

    private Double borrowFinancingFund;

    private Byte borrowState;

    private Date createDate;

    private Byte isRepay;

    private String userId;

    private String materialId;

    private String remindContent;

    private Double borrowMoney;

    private Double borrowReturnMoney;

    private Date borrowReturnDate;

    private String borrowMonth;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id == null ? null : id.trim();
    }

    public String getBorrowContact() {
        return borrowContact;
    }

    public void setBorrowContact(String borrowContact) {
        this.borrowContact = borrowContact == null ? null : borrowContact.trim();
    }

    public String getBorrowUnit() {
        return borrowUnit;
    }

    public void setBorrowUnit(String borrowUnit) {
        this.borrowUnit = borrowUnit == null ? null : borrowUnit.trim();
    }

    public String getBorrowFinance() {
        return borrowFinance;
    }

    public void setBorrowFinance(String borrowFinance) {
        this.borrowFinance = borrowFinance == null ? null : borrowFinance.trim();
    }

    public String getBorrowCompanyName() {
        return borrowCompanyName;
    }

    public void setBorrowCompanyName(String borrowCompanyName) {
        this.borrowCompanyName = borrowCompanyName == null ? null : borrowCompanyName.trim();
    }

    public String getBorrowCompanyEntity() {
        return borrowCompanyEntity;
    }

    public void setBorrowCompanyEntity(String borrowCompanyEntity) {
        this.borrowCompanyEntity = borrowCompanyEntity == null ? null : borrowCompanyEntity.trim();
    }

    public Double getBorrowRegisteredCapital() {
        return borrowRegisteredCapital;
    }

    public void setBorrowRegisteredCapital(Double borrowRegisteredCapital) {
        this.borrowRegisteredCapital = borrowRegisteredCapital;
    }

    public String getBorrowCompanyLocation() {
        return borrowCompanyLocation;
    }

    public void setBorrowCompanyLocation(String borrowCompanyLocation) {
        this.borrowCompanyLocation = borrowCompanyLocation == null ? null : borrowCompanyLocation.trim();
    }

    public String getBorrowCompanyCode() {
        return borrowCompanyCode;
    }

    public void setBorrowCompanyCode(String borrowCompanyCode) {
        this.borrowCompanyCode = borrowCompanyCode == null ? null : borrowCompanyCode.trim();
    }

    public Double getBorrowFinancingFund() {
        return borrowFinancingFund;
    }

    public void setBorrowFinancingFund(Double borrowFinancingFund) {
        this.borrowFinancingFund = borrowFinancingFund;
    }

    public Byte getBorrowState() {
        return borrowState;
    }

    public void setBorrowState(Byte borrowState) {
        this.borrowState = borrowState;
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

    public Double getBorrowMoney() {
        return borrowMoney;
    }

    public void setBorrowMoney(Double borrowMoney) {
        this.borrowMoney = borrowMoney;
    }

    public Double getBorrowReturnMoney() {
        return borrowReturnMoney;
    }

    public void setBorrowReturnMoney(Double borrowReturnMoney) {
        this.borrowReturnMoney = borrowReturnMoney;
    }

    public Date getBorrowReturnDate() {
        return borrowReturnDate;
    }

    public void setBorrowReturnDate(Date borrowReturnDate) {
        this.borrowReturnDate = borrowReturnDate;
    }

    public String getBorrowMonth() {
        return borrowMonth;
    }

    public void setBorrowMonth(String borrowMonth) {
        this.borrowMonth = borrowMonth == null ? null : borrowMonth.trim();
    }
}