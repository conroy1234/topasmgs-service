package org.tms.mgm.sys.torPasMgsservice.model;

import java.io.Serializable;

import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Transient;

@Entity
@Table
public class Pass implements Serializable {

	private static final long serialVersionUID = 6328338464323920590L;

	@GeneratedValue(strategy = GenerationType.IDENTITY)	
	@Id
	private long id;
	
	private String passNo;
	private String customerNo;

	@Embedded
	private City city;
	private String expiraryDate;
	private String passActive;

	@Transient
	private boolean isActive;

	public Pass() {

	}

	public Pass(String passNo, String customerNo, City city, String expiraryDate, String passActive) {
		this.passNo = passNo;
		this.customerNo = customerNo;
		this.city = city;
		this.expiraryDate = expiraryDate;
		this.passActive = passActive;
	}

	
	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getPassNo() {
		return passNo;
	}

	public void setPassNo(String passNo) {
		this.passNo = passNo;
	}

	public String getCustomerNo() {
		return customerNo;
	}

	public void setCustomerNo(String customerNo) {
		this.customerNo = customerNo;
	}

	public City getCity() {
		return city;
	}

	public void setCity(City city) {
		this.city = city;
	}

	public String getExpiraryDate() {
		return expiraryDate;
	}

	public void setExpiraryDate(String string) {
		this.expiraryDate = string;
	}

	public String getPassActive() {
		return passActive;
	}

	public void setPassActive(String passActive) {
		this.passActive = passActive;
	}

	
	public void setActive(boolean isActive) {
		this.isActive = isActive;
	}

	public boolean isActive(String active) {
		this.passActive = active.toString();
		if (this.passActive.equalsIgnoreCase("YES"))
			this.isActive = true;
		
		return this.isActive;
	}

	@Override
	public String toString() {
		return "Pass [id=" + id + ", passNo=" + passNo + ", customerNo=" + customerNo + ", city=" + city
				+ ", expiraryDate=" + expiraryDate + ", passActive=" + passActive + ", isActive=" + isActive + "]";
	}

}
