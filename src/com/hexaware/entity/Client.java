package com.hexaware.entity;

public class Client {
	
	private int clientId;
    private String clientName;
    private String phoneNumber;
    private Policy policy;
    
	public Client() {
		super();
	}
	
	public Client(int clientId, String clientName, String phoneNumber, Policy policy) {
		super();
		this.clientId = clientId;
		this.clientName = clientName;
		this.phoneNumber = phoneNumber;
		this.policy = policy;
	}

	public int getClientId() {
		return clientId;
	}

	public void setClientId(int clientId) {
		this.clientId = clientId;
	}

	public String getClientName() {
		return clientName;
	}

	public void setClientName(String clientName) {
		this.clientName = clientName;
	}

	public String getPhoneNumber() {
		return phoneNumber;
	}

	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}

	public Policy getPolicy() {
		return policy;
	}

	public void setPolicy(Policy policy) {
		this.policy = policy;
	}

	@Override
	public String toString() {
		return "Client [clientId=" + clientId + ", clientName=" + clientName + ", phoneNumber=" + phoneNumber
				+ ", policy=" + policy + "]";
	}
	
}
