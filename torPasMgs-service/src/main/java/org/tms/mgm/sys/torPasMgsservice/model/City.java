package org.tms.mgm.sys.torPasMgsservice.model;

import java.io.Serializable;

import javax.persistence.Embeddable;

@Embeddable
public class City implements Serializable {

	private static final long serialVersionUID = 7096989013859193642L;

	private String customerCity;
	private String passCity;
	
	
	public String getCustomerCity() {
		return customerCity;
	}

	public void setCustomerCity(String customerCity) {
		this.customerCity = customerCity;
	}

	public String getPassCity() {
		return passCity;
	}

	public void setPassCity(String passCity) {
		this.passCity = passCity;
	}

	@Override
	public String toString() {
		return "City [customerCity=" + customerCity + ", passCity=" + passCity + "]";
	}

}
