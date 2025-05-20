package com.hexaware.client;

import java.util.List;
import java.util.Scanner;

import com.hexaware.dao.IPolicyService;
import com.hexaware.entity.Client;
import com.hexaware.entity.Policy;
import com.hexaware.exception.ClientExistsException;
import com.hexaware.exception.PolicyNotFoundException;

public class MainModule {
	
	public static Scanner scan = new Scanner(System.in);
	public static IPolicyService dao = IPolicyService.getDaoInstance();

	public static void main(String[] args) {
		String opt=null;
		do {
			handleMenu();
			System.out.println("Press y to continue:");
			opt=scan.next();
			} while (opt.charAt(0)=='Y'||opt.charAt(0)=='y');

	}
	
	public static void handleMenu() {
		System.out.println("1. Create Policy for Customer");
        System.out.println("2. View All Policies");
        System.out.println("3. Get Policy by ID");
        System.out.print("Enter your choice: ");
        int choice = scan.nextInt();
        
		switch(choice) {
		case 1:
			handleCreatePolicyForCustomer();
			break;
		case 2:
			handleGetAllPolicies();
			break;
		case 3:
			handleGetPolicyById();
			break;
		default:
			System.out.println("Invalid menu option");
		}
	}
	
	public static void handleCreatePolicyForCustomer() {
        System.out.println("Enter Client ID:");
        int clientId = scan.nextInt();
        System.out.println("Enter Client Name:");
        String clientName = scan.next();
        System.out.println("Enter Phone Number:");
        String phone = scan.next();

        System.out.println("Enter Policy ID:");
        int policyId = scan.nextInt();
        System.out.println("Enter Policy Amount:");
        double policyAmt = scan.nextDouble();
        System.out.println("Enter Policy Name:");
        String policyName = scan.next();
        System.out.println("Enter Coverage Amount:");
        double coverageAmt = scan.nextDouble();
        System.out.println("Enter Duration (in months):");
        int duration = scan.nextInt();

        Policy policy = new Policy(policyId, policyAmt, policyName, coverageAmt, duration);
        Client client = new Client(clientId, clientName, phone, policy);

        try {
        	dao.createPolicyForCustomer(client);
            System.out.println("Client and Policy registered successfully.");
        } catch (ClientExistsException e) {
            System.out.println(e.getMessage());
        }
    }

    public static void handleGetPolicyById() {
        System.out.println("Enter Policy ID:");
        int id = scan.nextInt();
        try {
            Policy policy = dao.getPolicy(id);
            if (policy != null) {
                displayPolicy(policy);
            }
        } catch (PolicyNotFoundException e) {
            System.out.println(e.getMessage());
        }
    }

    public static void handleGetAllPolicies() {
        List<Policy> policies = dao.getAllPolicies();
        for (Policy policy : policies) {
            displayPolicy(policy);
        }
    }

    public static void displayPolicy(Policy policy) {
        System.out.println("Policy ID: " + policy.getPolicyId());
        System.out.println("Policy Name: " + policy.getPolicyName());
        System.out.println("Policy Amount: " + policy.getPolicyAmt());
        System.out.println("Coverage Amount: " + policy.getCoverageAmt());
        System.out.println("Duration: " + policy.getDuration() + " months");
        System.out.println("---------------------------------------");
    }

}
