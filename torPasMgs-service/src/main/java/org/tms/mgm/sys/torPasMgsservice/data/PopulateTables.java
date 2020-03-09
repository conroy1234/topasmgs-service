package org.tms.mgm.sys.torPasMgsservice.data;

import java.time.LocalDateTime;
import java.util.Arrays;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.tms.mgm.sys.torPasMgsservice.constants.ApiConstants;
import org.tms.mgm.sys.torPasMgsservice.model.City;
import org.tms.mgm.sys.torPasMgsservice.model.Customer;
import org.tms.mgm.sys.torPasMgsservice.model.Pass;
import org.tms.mgm.sys.torPasMgsservice.service.CustomerService;
import org.tms.mgm.sys.torPasMgsservice.service.PassService;

@Component
public class PopulateTables implements ApiConstants {

	Logger logger = LoggerFactory.getLogger(PopulateTables.class);
	
	@Autowired
	PassService passService;

	@Autowired
	CustomerService customerService;

	public PopulateTables() {

	}
	

	private  void populateCustomer(City city,String[] name) {
		List<Customer> customers = Arrays.asList(new Customer(RONDOMLY_GENERATED_ID, name[0], city, "20-06-1983"),
				new Customer(RONDOMLY_GENERATED_ID1, name[1], city, "15-08-1983"),
				new Customer(RONDOMLY_GENERATED_ID2, name[2], city, "23-12-1975"));

		for (Customer customer : customers) {
			customerService.saveCustomer(customer);
			logger.info("new customer >>"+customer +" created");
		}
	}

	private  void populatePass(City city, String[] name) {	
		List<Pass> passes = Arrays.asList( 				
		new Pass(RONDOMLY_GENERATED_ID, name[0], city, LocalDateTime.now().toString(),ACTIVE_PASS),
		new Pass(RONDOMLY_GENERATED_ID1, name[1], city, LocalDateTime.now().toString(),INACTIVE_PASS),
		new Pass(RONDOMLY_GENERATED_ID2, name[2], city, LocalDateTime.now().toString(),INACTIVE_PASS));
		
		for (Pass pass : passes) {
			
			passService.savePass(pass);
			logger.info("new pass >> "+pass +" created");
		}
	}
	
	public void executeQuery(City city) {
		populateCustomer(city,LIST_OF_CUSTOMER_NAMES);
		populatePass(city,LIST_OF_CUSTOMER_NAMES);
	}
}
