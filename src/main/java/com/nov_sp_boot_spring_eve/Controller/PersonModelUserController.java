package com.nov_sp_boot_spring_eve.Controller;

import java.util.Collections;
import java.util.List;

import org.apache.catalina.connector.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.nov_sp_boot_spring_eve.Model.PersonModel;
import com.nov_sp_boot_spring_eve.Request.LoginRequest;
import com.nov_sp_boot_spring_eve.Request.LoginRequest2;
import com.nov_sp_boot_spring_eve.Request.PersonRequest;
import com.nov_sp_boot_spring_eve.Response.GeneralResponse;
import com.nov_sp_boot_spring_eve.Response.PersonResponse;
import com.nov_sp_boot_spring_eve.Service.PersonService;

@RestController


public class PersonModelUserController {
	@Autowired
	PersonService personService;

	@GetMapping("getNameByCity/{cityName}")
	public ResponseEntity<?> getNameByCity(@PathVariable String cityName) {
		List<PersonModel> city = personService.getNameByCityDetail(cityName);
		return ResponseEntity.ok(city);
	

	}
    @GetMapping("getDetailById/{id}")
    public ResponseEntity<?> getDetailById(@PathVariable Integer id){
    	try {
    	
    	return ResponseEntity.ok(personService.getNameById(id));
    	}catch(Exception e) {
    		return ResponseEntity.badRequest().body(e.getMessage());
    	}
    	
    	
    }
    
    
    
	@GetMapping("getDetailByName/{name}")
	public ResponseEntity<?> getCityByName(@PathVariable String name) {
		GeneralResponse res = new GeneralResponse();
		try {
			List<PersonModel> detailByName = personService.getDetailByPersonName(name);

			return ResponseEntity.ok(detailByName);
		} catch (Exception e) {

			return ResponseEntity.badRequest().body(e.getMessage());
		}
	}
	//update by name using id..here only the name gets updated
    @PostMapping("updateNameById")
	public ResponseEntity<?> updateNameById(@RequestBody PersonRequest req) {
    	GeneralResponse res=new GeneralResponse();
    	try {
    	personService.updateNameById(req.getId(), req.getName());
    	res.setMessage("city updated");
    	return ResponseEntity.ok(res);
    	
    	}
    	catch(Exception e) {
    		return ResponseEntity.badRequest().body(e.getMessage());
    	}
    	
    
    	
    }
    
    // updating database using id.. here anything can be updated
    @PostMapping("update")
   	public ResponseEntity<?> updateNameByType(@RequestBody PersonRequest req) {
       	GeneralResponse res=new GeneralResponse();
       	try {
       	PersonResponse ress=personService.update(req);
       
       	return ResponseEntity.ok(ress);
       	
       	}
       	catch(Exception e) {
       		return ResponseEntity.badRequest().body(e.getMessage());
       	}
    }
      
       
       	
      
			
			
			
			
			
			
	// login can also be done like this... the duplication is not allowed to happen
	// in first place.. this is coding

	// i did for the ' what if ' kind of situations . this is my own experiment
	// done..
	// tip : the mysql database cares about the space you provided during putting
	// data from the loop so
	// in future if you ever get stuck first erase the extra blank space from mysql
	// database datas and try again.

	@PostMapping("login2")
	public ResponseEntity<?> getLogin2(@RequestBody LoginRequest req) {
		GeneralResponse res = new GeneralResponse();

		try {
			List<PersonModel> model = personService.getLogin2(req.getEmail(), req.getPasscode());
			return ResponseEntity.ok(model);

		} catch (Exception e) {

			return ResponseEntity.badRequest().body(e.getMessage());
		}

	}

	
	
		@PostMapping("userRegister")
		public ResponseEntity<?> userRegister(@RequestBody PersonRequest personReq){
			try {
			PersonRequest req=personService.userRegister(personReq);
			return ResponseEntity.ok(req);
			}catch(Exception e) {
			return ResponseEntity.badRequest().body(e.getMessage());
			}
			
		
	}
		@PostMapping("getLogin")
		public ResponseEntity<?> checkLogin(@RequestBody LoginRequest req) {
			try {
			PersonResponse res=personService.getlogin(req.getEmail(), req.getPasscode());
			
			
			return ResponseEntity.ok(res);
			}catch(Exception e) {
				return ResponseEntity.badRequest().body(e.getMessage());
			}
			
		}

		/*
		 * @PostMapping("delete") public ResponseEntity<?> delete(@RequestBody
		 * PersonRequest req) { GeneralResponse res = new GeneralResponse(); try {
		 * personService.delete(req.getId()); res.setMessage("city deleted ");
		 * 
		 * return ResponseEntity.ok(res); } catch (Exception e) { return
		 * ResponseEntity.badRequest().body(e.getMessage());
		 * 
		 * } }
		 */

		
		 @PostMapping("delete/{id}")
		 public ResponseEntity<?> delete2(@PathVariable Integer id) { 
			 GeneralResponse res = new GeneralResponse();
			 try {
		 personService.delete(id); 
		 res.setMessage("city deleted ");
		 
		 return ResponseEntity.ok(res); } 
			 catch (Exception e) {
				 return ResponseEntity.badRequest().body(e.getMessage());
		 
		} }
		 
	@GetMapping("getPages")
	public ResponseEntity<?> getPages(@RequestParam int pageNo) {

		try {
			pageNo=pageNo-1;
			List<PersonModel> res = personService.getPages(pageNo);
			return ResponseEntity.ok(res);

		} catch (Exception e) {
			return ResponseEntity.badRequest().body(e.getMessage());
		}
	}

}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	

