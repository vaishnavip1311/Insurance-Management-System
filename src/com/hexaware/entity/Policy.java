package com.hexaware.entity;

public class Policy {
	
	private int policyId;
    private double policyAmt;
    private String policyName;
    private double coverageAmt;
    private int duration;
    
	public Policy() {
		super();
	}

	public Policy(int policyId, double policyAmt, String policyName, double coverageAmt, int duration) {
		super();
		this.policyId = policyId;
		this.policyAmt = policyAmt;
		this.policyName = policyName;
		this.coverageAmt = coverageAmt;
		this.duration = duration;
	}

	public int getPolicyId() {
		return policyId;
	}

	public void setPolicyId(int policyId) {
		this.policyId = policyId;
	}

	public double getPolicyAmt() {
		return policyAmt;
	}

	public void setPolicyAmt(double policyAmt) {
		this.policyAmt = policyAmt;
	}

	public String getPolicyName() {
		return policyName;
	}

	public void setPolicyName(String policyName) {
		this.policyName = policyName;
	}

	public double getCoverageAmt() {
		return coverageAmt;
	}

	public void setCoverageAmt(double coverageAmt) {
		this.coverageAmt = coverageAmt;
	}

	public int getDuration() {
		return duration;
	}

	public void setDuration(int duration) {
		this.duration = duration;
	}

	@Override
	public String toString() {
		return "Policy [policyId=" + policyId + ", policyAmt=" + policyAmt + ", policyName=" + policyName
				+ ", coverageAmt=" + coverageAmt + ", duration=" + duration + "]";
	}
    
}
