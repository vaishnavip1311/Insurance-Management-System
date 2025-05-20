package com.hexaware.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.hexaware.entity.Client;
import com.hexaware.entity.Policy;
import com.hexaware.exception.ClientExistsException;
import com.hexaware.exception.DbConnectionException;
import com.hexaware.exception.PolicyNotFoundException;
import com.hexaware.util.DbConnectionUtil;

public class InsuranceServiceImpl implements IPolicyService{

	@Override
	public void createPolicyForCustomer(Client client) throws ClientExistsException {
		Connection conn = null;
		PreparedStatement st = null;
		try {
			conn = DbConnectionUtil.getDbConnection();
			st = conn.prepareStatement("SELECT * FROM Client WHERE client_Id = ?");
            st.setInt(1, client.getClientId());
            ResultSet rs = st.executeQuery();
      
            Policy policy = client.getPolicy();
            st = conn.prepareStatement("INSERT INTO Policy(policy_Id, policy_Amt, policy_Name, coverage_Amt, duration) VALUES (?, ?, ?, ?, ?)");
            st.setInt(1, policy.getPolicyId());
            st.setDouble(2, policy.getPolicyAmt());
            st.setString(3, policy.getPolicyName());
            st.setDouble(4, policy.getCoverageAmt());
            st.setInt(5, policy.getDuration());
            st.executeUpdate();
            
            if (rs.next()) {
                throw new ClientExistsException("Client with ID " + client.getClientId() + " already exists.");
            }
            
            st = conn.prepareStatement("INSERT INTO Client(client_Id, client_Name, phone_Number, policy_Id) VALUES (?, ?, ?, ?)");
                st.setInt(1, client.getClientId());
                st.setString(2, client.getClientName());
                st.setString(3, client.getPhoneNumber());
                st.setInt(4, client.getPolicy().getPolicyId());
                st.executeUpdate();
            
		} catch (DbConnectionException | SQLException | ClientExistsException e) {
			System.out.println(e.getMessage());
		}finally {
			DbConnectionUtil.closeConnection(conn);
		}
	}

	@Override
	public List<Policy> getAllPolicies() {
		List<Policy> lst = new ArrayList<Policy>();
		Connection conn = null;
		Policy policy = null;
		
		try {
			conn = DbConnectionUtil.getDbConnection();
			PreparedStatement st= conn.prepareStatement("select * from policy");
			ResultSet rs = st.executeQuery();
			while (rs.next()) {
                policy = new Policy(rs.getInt("policy_Id"),rs.getDouble("policy_Amt"),rs.getString("policy_Name"),rs.getDouble("coverage_Amt"),rs.getInt("duration"));
                lst.add(policy);
            }
			
		} catch (DbConnectionException | SQLException e) {
			System.out.println(e.getMessage());
		}finally {
			DbConnectionUtil.closeConnection(conn);
		}
		return lst;
	}

	@Override
	public Policy getPolicy(int policyId) throws PolicyNotFoundException{
		Connection conn = null;
		Policy policy = null;
		
		try {
			conn = DbConnectionUtil.getDbConnection();
			PreparedStatement st = conn.prepareStatement("SELECT * FROM Policy WHERE policy_Id = ?");
			st.setInt(1, policyId);;
			ResultSet rs= st.executeQuery();
			if(rs.next()) {
				policy = new Policy(rs.getInt("policy_Id"),rs.getDouble("policy_Amt"),rs.getString("policy_Name"),rs.getDouble("coverage_Amt"),rs.getInt("duration"));
			}
			else {
				throw new PolicyNotFoundException("Policy with ID " + policyId + " not found.");
			}
			
		} catch (DbConnectionException | SQLException |PolicyNotFoundException e) {
			System.out.println(e.getMessage());
		}finally {
			DbConnectionUtil.closeConnection(conn);
		}
		return policy;
	}

}
