package com.nov_sp_boot_spring_eve.Controller;

import java.util.HashMap;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.RequestEntity;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.nov_sp_boot_spring_eve.Model.CityModel;
import com.nov_sp_boot_spring_eve.Model.PersonModel;
import com.nov_sp_boot_spring_eve.Request.CityCreateRequest;
import com.nov_sp_boot_spring_eve.Request.LoginRequest2;
import com.nov_sp_boot_spring_eve.Request.SampleRequest;
import com.nov_sp_boot_spring_eve.Response.GeneralResponse;
import com.nov_sp_boot_spring_eve.Service.CityService;
import com.nov_sp_boot_spring_eve.Service.UserService;

@RestController
@RequestMapping("user")
public class UserController {
	
	@Autowired
	UserService userService;
	
	@Autowired
	CityService cityService;

	@GetMapping("user")
	public String getService() {
		return userService.getName();
	}

	//This is one way of sending proper message in the json form to the client server because 
	//it uses the response entity which converts everything in its parameter to json using this the message
	//which you have written in the original getlogin method that do not come becaseu you have made a new one
	 
		@PostMapping("login")
		public ResponseEntity<?> getLogin(@RequestBody LoginRequest2 req) throws Exception {
			GeneralResponse res=new GeneralResponse();
			try {
				
		 	userService.getLogin(req.getUsername(), req.getPassword());
	      res.setMessage("welcome.. login successful");
	      ResponseEntity.ok(res);
	      
	   

			} catch (Exception e) {
				res.setMessage(e.getMessage());
					

			}
			return ResponseEntity.badRequest().body(res);

			}
		
	
	 // this is direct way of sending message which you have already wriiten in the original method i.e.
		// getLogin which is in UserService class inside nov.service package .. you send the original 
		//String to the user this is shortcut but might not be better in every case or long run use
	@PostMapping("login2")
	public String getLogin2(@RequestBody LoginRequest2 req) throws Exception {
		GeneralResponse res=new GeneralResponse();
		try {
			
	  return	userService.getLogin(req.getUsername(), req.getPassword());
          

		} catch (Exception e) {
			return e.getMessage();
		}
	}
	@PostMapping("createCity")
	public ResponseEntity<?> createCity(@RequestBody CityCreateRequest req) {
		GeneralResponse res=new GeneralResponse();
		try {               
	  cityService.createCity(req.getName(), req.getZipCode());
	    res.setMessage("city created");
	   return ResponseEntity.ok(res);
	 
		}catch(Exception e) {
		res.setMessage( e.getMessage());
			return ResponseEntity.ok(res);
		}
	
		
		
	 
		
		
	}
	@PostMapping("getcitybyname/name/{name}")
	public ResponseEntity<?> getCitybyName( @PathVariable String name){
		GeneralResponse res=new GeneralResponse();
		try {
		
		return ResponseEntity.ok(cityService.getCityByName(name));
		}
		catch(Exception e) {
			e.printStackTrace();
		res.setMessage(e.getMessage());
		 return ResponseEntity.badRequest().body(res);
		}
	}
	
	
	@PostMapping("zipcode/getZipcode/{zipcode}")
	public ResponseEntity<?> getCityByZipcode(@PathVariable Long zipcode){
		GeneralResponse res=new GeneralResponse();
		try {
			return ResponseEntity.ok(cityService.getCityByZipcode(zipcode));
			
			
		}catch(Exception e) {
			res.setMessage(e.getMessage());
			return ResponseEntity.badRequest().body(res);
			
		}
	
		
		
		
		 
	}
	@PostMapping("updateCity")
	public ResponseEntity<?> updateCity(@RequestBody CityCreateRequest req) {
		GeneralResponse res=new GeneralResponse();
		try {               
	  cityService.updateCityNameById(req.getName(), req.getId() ,req.getZipCode());
	    res.setMessage("city updated");
	   return ResponseEntity.ok(res);
	 
		}catch(Exception e) {
		res.setMessage( e.getMessage());
			return ResponseEntity.badRequest().body(res);
		}
	
		
	}
	 
		@PostMapping ("deleteCity")
		public ResponseEntity<? > deleteCity(@RequestBody CityCreateRequest req){
			GeneralResponse res=new GeneralResponse();
			try {
			cityService.deleteCity(req.getId());
			
			res.setMessage("city deleted");
			return ResponseEntity.ok(res);
			}catch (Exception e) {
				res.setMessage(e.getMessage());
				return ResponseEntity.badRequest().body(res);
				
			}
		
	}
		@GetMapping("getAllCity")
		public ResponseEntity<?> getAllCity(){
		return ResponseEntity.ok(cityService.getAllCity());
		

	}
		@GetMapping("findbyCityId")
		public ResponseEntity<?> findbyCityId(@RequestBody CityCreateRequest city){
			try {
		  
		    
		
			return ResponseEntity.ok(cityService.getCityDetail(city.getId()));
		
		}catch(Exception e) {
			return ResponseEntity.badRequest().body(e.getMessage());
		}
		}
		
		
		@GetMapping("getAllCity/{id}")
		public ResponseEntity<?> findByCityId(@PathVariable  Integer id){
			try {
		   CityModel cityById= cityService.getCityDetail(id);
		   
		    
		
			return ResponseEntity.ok(cityById);
		
		}catch(Exception e) {
			GeneralResponse res=new GeneralResponse();
			res.setMessage(e.getMessage());
			return ResponseEntity.badRequest().body(res);
		}
		}
	
	}

