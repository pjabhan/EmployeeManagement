package com.nov_sp_boot_spring_eve.Controller;

import java.util.HashMap;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.RequestEntity;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.nov_sp_boot_spring_eve.Request.CityCreateRequest;
import com.nov_sp_boot_spring_eve.Request.LoginRequest;
import com.nov_sp_boot_spring_eve.Request.SampleRequest;
import com.nov_sp_boot_spring_eve.Service.UserService;

@RestController
public class SampleController {
	@Autowired 
	UserService userService;
	@GetMapping("user/{work}")
	public String gett(@PathVariable String work) {
		return "name from post" + work;
	}
@GetMapping("user/{user_id}")
public String getName( @PathVariable  String user_id) {
	return "name from get" +user_id;
}
@GetMapping("userr")
public String getRequestName(@RequestParam String nickname) {
	return "request param" +nickname;
}
@GetMapping("userr2")
public  String getNickname(@RequestParam String name) {
	return name;
}
@PostMapping("Home/{name}")
public  String postNickname(@PathVariable String name) {
	return "this is from post home" +name;
}

/*
 * @PostMapping("req_body") public String sample_requestbody(@RequestBody
 * SampleRequest obj) {
 * 
 * return "from pojoclalss" + obj.getName() +" " +obj.getCity();
 * 
 * 
 * }
 */
@PostMapping("req_body")
public String sample_requestbody(@RequestBody HashMap<String, String > obj) {
	
	return  "from HashMap" +obj.get("name")+" "  +obj.get("city");
	
	
}
@PostMapping("city")
public String getCity(@RequestBody CityCreateRequest city) {

	return "success";
}

@PostMapping("checkLogin")
public String getLogin(@RequestBody LoginRequest req) {
    try {
	return userService.getLogin(req.getEmail(), req.getPasscode());
	
    }catch(Exception e) {
    	return e.getMessage();
    }
   
    
   


}
}