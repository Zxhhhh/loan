package com.gy612.loan.entity;

public class PersonalLoanMaterial {
    private String id;

    private String materialPersonal;

    private String materialMortgage;

    public PersonalLoanMaterial() {
		super();
		// TODO Auto-generated constructor stub
	}
    
	public PersonalLoanMaterial(String id, String materialPersonal,
			String materialMortgage) {
		super();
		this.id = id;
		this.materialPersonal = materialPersonal;
		this.materialMortgage = materialMortgage;
	}


	public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id == null ? null : id.trim();
    }

    public String getMaterialPersonal() {
        return materialPersonal;
    }

    public void setMaterialPersonal(String materialPersonal) {
        this.materialPersonal = materialPersonal == null ? null : materialPersonal.trim();
    }

    public String getMaterialMortgage() {
        return materialMortgage;
    }

    public void setMaterialMortgage(String materialMortgage) {
        this.materialMortgage = materialMortgage == null ? null : materialMortgage.trim();
    }
}