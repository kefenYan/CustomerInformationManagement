package com.project02;

public class CustomerList {
	
	private Customer[] customers;//An array of customer objects
	private int total = 0;      //Number of record keeping customers
	
	/*
	 * Constructor that initializes the customer array
	 */
	
	public CustomerList(int totalCustomer) {
		customers = new Customer[totalCustomer];
	}
	/*
	 * Add the specified customer to the array
	 * true added successfully, false added failed
	 */
	public boolean addCustomer(Customer customer) {
		if(total >=customers.length) {
			return false;
		}
		customers[total] = customer;
		total++;
//	or	customers[total++] = customer;
		return true;
	}
//	Modify specified customer information
	public boolean replaceCustomer(int index,Customer cust) {
		if(index <0||index>=total) {
			return false;
		}
		customers[total] = cust;
		return true;
	}
//	Delete the customer at the specified index position
	public boolean deleteCustomer(int index) {
		if(index <0||index>=total) {
			return false;
		}
		for(int i = index;i<total-1;i++) {
			customers[i] = customers[i+1];
		}
//		Leave the last element blank null
		customers[total - 1] = null;
		total--;
//	or	customers[--total] = null;
		return true;
	}
//	Get all customer information
	public Customer[] getAllCustomers() {
		Customer[] custs = new Customer[total];
		for(int i=0;i<total;i++) {
			custs[i] = customers[i];
		}
		return custs;
	}
//	Get customer information at a specified location
	public Customer getCustomer(int index) {
		if(index <0||index>=total) {
			return null;
		}
		return customers[index];
	}
//	Get the number of customers
	public int getTotal() {
		return total;
		
	}
	
}
