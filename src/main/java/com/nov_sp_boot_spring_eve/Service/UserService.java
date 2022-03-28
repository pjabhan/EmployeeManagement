package com.nov_sp_boot_spring_eve.Service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.nov_sp_boot_spring_eve.Model.CityModel;
import com.nov_sp_boot_spring_eve.Repository.CityRepo;


@Service
public class UserService {

public String getName() {
	return"sample from service";
}

public String getLogin( @RequestParam String username, String password) throws Exception {
	
	if(username.equals("test" ) && password.equals("testpass")) 
	
	return "welcome";
	else
		throw new Exception("sorry the username and password is wrong");


}


public String getLoginn( String email, String passcode) throws Exception {
	
	if(email.equals("pooja") && passcode.equals(passcode)) {
		
	
			
	return "login accepted";
	}
	else {
		throw new Exception("not welcome");
	}

}
}
