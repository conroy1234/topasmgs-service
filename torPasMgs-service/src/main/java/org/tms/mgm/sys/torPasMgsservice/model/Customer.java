package org.tms.mgm.sys.torPasMgsservice.model;

import java.io.Serializable;

import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table

public class Customer implements Serializable {

	private static final long serialVersionUID = 5821346246072222975L;

	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Id
	private long id;

	private String cusNo;
	private String name;
	@Embedded
	private City city;
	private String DOB;

	public Customer() {

	}

	public Customer(String cusNo, String name, City city, String dOB) {
		this.cusNo = cusNo;
		this.name = name;
		this.city = city;
		DOB = dOB;
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getCusNo() {
		return cusNo;
	}

	public void setCusNo(String cusNo) {
		this.cusNo = cusNo;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public City getCity() {
		return city;
	}

	public void setCity(City city) {
		this.city = city;
	}

	public String getDOB() {
		return DOB;
	}

	public void setDOB(String dOB) {
		DOB = dOB;
	}

	@Override
	public String toString() {
		return "Customer [id=" + id + ", cusNo=" + cusNo + ", name=" + name + ", city=" + city + ", DOB=" + DOB + "]";
	}

}
