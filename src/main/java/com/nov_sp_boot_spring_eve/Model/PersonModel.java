package com.nov_sp_boot_spring_eve.Model;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@Table(name="person")

public class PersonModel {
	@Id // Primary key
	@GeneratedValue(strategy=GenerationType.IDENTITY)
 Integer id;
	String name;
	String email;
	String city;
	
	String passcode;
	Integer phoneno;
	@OneToOne
	  @JoinColumn (name="city_id", referencedColumnName ="id")
	  CityModel cityTable;
	
		
		 @OneToMany
		 
		 @JoinColumn(name="id", referencedColumnName = "person_id") 
		 List<MobileModel> mobileModel;
		 
		
	 public List<MobileModel> getMobileModel() {
			return mobileModel;
		}
		public void setMobileModel(List<MobileModel> mobileModel) {
			this.mobileModel = mobileModel;
		}
	public CityModel getCityTable() {
			return cityTable;
		}
		public void setCityTable(CityModel cityTable) {
			this.cityTable = cityTable;
		}
	
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getCity() {
		return city;
	}
	public void setCity(String city) {
		this.city = city;
	}
	public String getPasscode() {
		return passcode;
	}
	public void setPasscode(String passcode) {
		this.passcode = passcode;
	}
	public Integer getPhoneno() {
		return phoneno;
	}
	public void setPhoneno(Integer phoneno) {
		this.phoneno = phoneno;
	}

	
	
}

