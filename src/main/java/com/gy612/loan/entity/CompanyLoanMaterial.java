package com.gy612.loan.entity;

public class CompanyLoanMaterial {
    private String id;

    private String materialAptitude;

    private String materialMortgage;

    public String getId() {
        return id;
    }
    

    public CompanyLoanMaterial() {
		super();
		// TODO Auto-generated constructor stub
	}
    
	public CompanyLoanMaterial(String id, String materialAptitude,
			String materialMortgage) {
		super();
		this.id = id;
		this.materialAptitude = materialAptitude;
		this.materialMortgage = materialMortgage;
	}


	public void setId(String id) {
        this.id = id == null ? null : id.trim();
    }

    public String getMaterialAptitude() {
        return materialAptitude;
    }

    public void setMaterialAptitude(String materialAptitude) {
        this.materialAptitude = materialAptitude == null ? null : materialAptitude.trim();
    }

    public String getMaterialMortgage() {
        return materialMortgage;
    }

    public void setMaterialMortgage(String materialMortgage) {
        this.materialMortgage = materialMortgage == null ? null : materialMortgage.trim();
    }
}