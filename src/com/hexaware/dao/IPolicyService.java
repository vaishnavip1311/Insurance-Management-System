package com.hexaware.dao;

import java.util.List;

import com.hexaware.entity.Client;
import com.hexaware.entity.Policy;
import com.hexaware.exception.ClientExistsException;
import com.hexaware.exception.PolicyNotFoundException;

public interface IPolicyService {
	
	void createPolicyForCustomer(Client client) throws ClientExistsException;
    List<Policy> getAllPolicies();
    Policy getPolicy(int policyId) throws PolicyNotFoundException;
    
    static IPolicyService getDaoInstance() {
    	IPolicyService dao = new InsuranceServiceImpl();
		return dao;
	}

}
