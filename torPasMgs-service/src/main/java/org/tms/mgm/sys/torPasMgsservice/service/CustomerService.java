package org.tms.mgm.sys.torPasMgsservice.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.tms.mgm.sys.torPasMgsservice.model.City;
import org.tms.mgm.sys.torPasMgsservice.model.Customer;
import org.tms.mgm.sys.torPasMgsservice.repository.CustomerRepository;

@Service
public class CustomerService {

	@Autowired
	CustomerRepository customerRepository;

	public List<Customer> fingAllCustomers() {
		return customerRepository.findAll();
	}

	public Customer saveCustomer(Customer customer) {
		return customerRepository.save(customer);
	}

	public Customer fingById(long cusNum) {
		return customerRepository.getOne(cusNum);
	}
	
	public Customer findBycity(City city) {
		return customerRepository.findBycity(city);
	}
	
	public Customer findByName(String name) {
		return customerRepository.findByName(name);
	}
	
	public Customer remove(Customer entity) {		
		customerRepository.delete(entity);
		return entity;
		
	}
	
	
}
