package com.nov_sp_boot_spring_eve.Request;

public class CityCreateRequest {
	private Integer id;
public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
private String name;
public String getName() {
	return name;
}
@Override
public String toString() {
	return "CityCreateRequest [name=" + name + ", zipCode=" + zipCode + "]";
}
public void setName(String name) {
	this.name = name;
}
public Long getZipCode() {
	return zipCode;
}
public void setZipCode(Long zipCode) {
	this.zipCode = zipCode;
}
private Long zipCode;




}
