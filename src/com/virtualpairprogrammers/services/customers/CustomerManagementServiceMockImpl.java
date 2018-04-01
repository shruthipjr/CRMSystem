package com.virtualpairprogrammers.services.customers;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.virtualpairprogrammers.domain.Call;
import com.virtualpairprogrammers.domain.Customer;

public class CustomerManagementServiceMockImpl implements CustomerManagementService {

	private Map<String, Customer> customerList = new HashMap<String, Customer>();

	public CustomerManagementServiceMockImpl(){
		Customer customer1 = new Customer("1","shri","s@gmail.com","999555","hi");
		Customer customer2 = new Customer("2","shruthi","shr@gmail.com","9995551235","hello");
		Customer customer3 = new Customer("3","shweha","swe@gmail.com","25999555","sunny");
		
		customerList.put(customer1.getCustomerId(), customer1);
		customerList.put(customer2.getCustomerId(), customer2);
		customerList.put(customer3.getCustomerId(), customer3);
	}

	@Override
	public void newCustomer(Customer newCustomer) {

		customerList.put(newCustomer.getCustomerId(), newCustomer);

	}

	@Override
	public void updateCustomer(Customer changedCustomer) {

		customerList.put(changedCustomer.getCustomerId(), changedCustomer);
		
	}

	@Override
	public void deleteCustomer(Customer oldCustomer) {
		
		customerList.remove(oldCustomer);
	}

	@Override
	public Customer findCustomerById(String customerId) throws CustomerNotFoundException {

		if(customerList.get(customerId) !=null){
			return customerList.get(customerId);
		}

		else
			throw new CustomerNotFoundException();

	}

	@Override
	public List<Customer> findCustomersByName(String name)  {

		List<Customer> customerlist = new ArrayList<Customer>();
		for(Customer next :customerList.values()){
			if(next.getCompanyName().equalsIgnoreCase(name)){
				customerlist.add(next);
			}
		}
		
		return customerlist;
	}

	@Override
	public List<Customer> getAllCustomers() {

		return new ArrayList<Customer>(customerList.values());
	}

	@Override
	public Customer getFullCustomerDetail(String customerId) throws CustomerNotFoundException {
		Customer customer = customerList.get(customerId);
		if(customer != null){
			return customer;
		}
		else 

			throw new CustomerNotFoundException();
	}

	@Override
	public void recordCall(String customerId, Call callDetails) throws CustomerNotFoundException {
		
		Customer customer = this.getFullCustomerDetail(customerId);
		customer.addCall(callDetails);
       System.out.println(customer.getCompanyName());
	}

}
