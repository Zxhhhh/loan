package com.gy612.loan.entity;

public class BorrowMaterial {
    private String id;

    private String materialIdentification;

    private String materialHouseproperty;

    private String materialDrivinglicence;

    private String materialPaymenthistory;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id == null ? null : id.trim();
    }

    public String getMaterialIdentification() {
        return materialIdentification;
    }

    public void setMaterialIdentification(String materialIdentification) {
        this.materialIdentification = materialIdentification == null ? null : materialIdentification.trim();
    }

    public String getMaterialHouseproperty() {
        return materialHouseproperty;
    }

    public void setMaterialHouseproperty(String materialHouseproperty) {
        this.materialHouseproperty = materialHouseproperty == null ? null : materialHouseproperty.trim();
    }

    public String getMaterialDrivinglicence() {
        return materialDrivinglicence;
    }

    public void setMaterialDrivinglicence(String materialDrivinglicence) {
        this.materialDrivinglicence = materialDrivinglicence == null ? null : materialDrivinglicence.trim();
    }

    public String getMaterialPaymenthistory() {
        return materialPaymenthistory;
    }

    public void setMaterialPaymenthistory(String materialPaymenthistory) {
        this.materialPaymenthistory = materialPaymenthistory == null ? null : materialPaymenthistory.trim();
    }
}