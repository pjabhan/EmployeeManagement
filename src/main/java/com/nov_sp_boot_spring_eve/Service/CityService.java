package com.nov_sp_boot_spring_eve.Service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.nov_sp_boot_spring_eve.Model.CityModel;
import com.nov_sp_boot_spring_eve.Repository.CityRepo;
import com.nov_sp_boot_spring_eve.Response.GeneralResponse;


@Service
public class CityService {
@Autowired
CityRepo cityRepo;





public List<CityModel> getAllCity() {
      return  cityRepo.findAll(); // will get all the data from cityModel(city table);
	
}
public List<CityModel> getCityByZipcode(Long zipCode) {
	return cityRepo.getCityByZipCode(zipCode);
	
	 
}
public List<CityModel> getCityByName(String name) throws Exception {

List<CityModel> cityList= cityRepo.getCityByName(name);
if(cityList.size()>0) {
return cityList;
}
else {
	throw new Exception("City details cannot be found");

	}
	}
	


public boolean updateCityNameById(String name, Integer cityId, Long zipCode)throws Exception {
	
	
	try {
	CityModel cityModel= cityRepo.findById(cityId).orElseThrow(()->new Exception (" City not found"));//will return option which is java 8 feature
	if(name!=null && !name.equals(" ")) {
		cityModel.setCityname(name);
       
	}
	if(zipCode!=null ) {
	 cityModel.setZipcode(zipCode);
	 System.out.println("hello");
	}
	
	cityModel.setCityname(name);
	cityRepo.save(cityModel);// updating the  city using cityrepo;
	return true;
	}catch(Exception e) {
		throw new Exception(e.getMessage());
		
	}
	
	
}
public boolean createCity(String name, Long zipCode) throws Exception{
	try {
	CityModel city=new CityModel(); 
	city.setCityname(name);
	city.setZipcode(zipCode);
	cityRepo.save(city);
	return true;
	}catch(Exception e) {
		throw new Exception (e.getMessage());
	}
	
}
public boolean deleteCity(Integer id) throws Exception {
	try {
		CityModel city=cityRepo.findById(id).orElseThrow(()-> new Exception ("cnnnot find"));
		
		cityRepo.delete( city);
		return true;
		
	}catch (Exception e) {
		throw new Exception (e.getMessage());
	}
	
}
public CityModel getCityDetail(int cityId)throws Exception {
	CityModel cityModel =new CityModel();
	try {
	cityModel=cityRepo.findById(cityId).orElseThrow(()-> new Exception("please enter the correct city id"));
	
	return cityModel;
	}catch(Exception e)
	{
	throw new Exception (e.getMessage());
	}
	
	}
}

