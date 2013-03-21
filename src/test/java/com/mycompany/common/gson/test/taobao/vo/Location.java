package com.mycompany.common.gson.test.taobao.vo;

import java.io.Serializable;

public class Location implements Serializable{

	private static final long serialVersionUID = 7997732552983921625L;
	
	private String zip;	     
	private String address;		 
	private String city;		   
	private String state;		   
	private String country;		 
	private String district;
	
	public String getZip() {
		return zip;
	}
	public void setZip(String zip) {
		this.zip = zip;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public String getCity() {
		return city;
	}
	public void setCity(String city) {
		this.city = city;
	}
	public String getState() {
		return state;
	}
	public void setState(String state) {
		this.state = state;
	}
	public String getCountry() {
		return country;
	}
	public void setCountry(String country) {
		this.country = country;
	}
	public String getDistrict() {
		return district;
	}
	public void setDistrict(String district) {
		this.district = district;
	}	

	
}
