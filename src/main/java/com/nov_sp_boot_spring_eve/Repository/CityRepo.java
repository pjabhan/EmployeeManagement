package com.nov_sp_boot_spring_eve.Repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.nov_sp_boot_spring_eve.Model.CityModel;
import com.nov_sp_boot_spring_eve.Request.CityCreateRequest;

@Repository
public interface CityRepo  extends JpaRepository<CityModel, Integer>{
	
	
	
	@Query("Select city from  CityModel city where city.zipcode > ?1")
	List<CityModel> getCityByZipCode(Long zipCode);
	
	@Query("Select city from CityModel city where city.cityname like  %?1%")
		List<CityModel> getCityByName(String name);
		


		
	 
	
}
