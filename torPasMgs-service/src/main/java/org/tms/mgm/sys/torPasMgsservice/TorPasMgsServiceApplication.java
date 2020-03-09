package org.tms.mgm.sys.torPasMgsservice;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.tms.mgm.sys.torPasMgsservice.data.PopulateTables;

@SpringBootApplication
public class TorPasMgsServiceApplication implements CommandLineRunner {

	@Autowired
	PopulateTables populate;

	public static void main(String[] args) {
		SpringApplication.run(TorPasMgsServiceApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		
	/*
	 * this is commented as i am doing the insert using data.sql but still leave this s a secondary input should it be needed	
	 */
//		City city = new City();
//		city.setCustomerCity("London");
//		city.setPassCity("London");
//
//		populate.executeQuery(city);

	}

}
