package org.tms.mgm.sys.torPasMgsservice.repository;

import javax.persistence.NamedQuery;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.tms.mgm.sys.torPasMgsservice.model.City;
import org.tms.mgm.sys.torPasMgsservice.model.Customer;

@Repository
@NamedQuery(name = "findByName", query = "from customer where name = :name and DOB=:DOB")
@NamedQuery(name = "findBycity", query = "from customer where city.passCity = :city.passCity and city.customerCity =:city.customerCity")
public interface CustomerRepository extends JpaRepository<Customer, Long> {
	Customer findBycity(City city);
	Customer findByName(String name);

}
