package com.nov_sp_boot_spring_eve.Service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import com.nov_sp_boot_spring_eve.Repository.CityRepo;
import com.nov_sp_boot_spring_eve.Repository.PersonRepo;
import com.nov_sp_boot_spring_eve.Request.PersonRequest;
import com.nov_sp_boot_spring_eve.Response.PersonResponse;
import com.nov_sp_boot_spring_eve.Model.*;

@Service

public class PersonService {
	@Autowired
	public PersonRepo personRepo;

	public List<PersonModel> getNameByCityDetail(String city) {
		List<PersonModel> personinthecity = personRepo.getPersonByCityName(city);
		return personinthecity;
	}
     public PersonModel getNameById (Integer Id) throws Exception{
    	 if(Id<0) {
     		throw new Exception ("can't be negative");
    	 }
    	PersonModel personModel=  personRepo.findById(Id).orElseThrow(()-> new Exception ("id not found "));
    	
    	
    	return personModel;
    	
    
     
     }
	public List<PersonModel> getDetailByPersonName(String name) throws Exception {

		List<PersonModel> detailByName = personRepo.getDetailsByPersonName(name);
		if (detailByName.size() > 0) {
			return detailByName;
		} else {
			throw new Exception("didn't found city");

		}
	}

	// this is another way of doing the same login procedure which i did only for
	// the self study purpose and
	// it is not very practical to do

	public List<PersonModel> getLogin2(String email, String passcode) throws Exception {
		System.out.println(email + " " + passcode);

		List<PersonModel> model = personRepo.getlogin2(email, passcode);
		if (model.size() == 1) {
			return model;

		}
		if (model.size() > 1) {

			throw new Exception("or duplication");
		} else {
			throw new Exception("not found ");

		}
	}

	public PersonRequest userRegister(PersonRequest req) throws Exception {
		PersonModel model = new PersonModel();
		Integer count = personRepo.getUserByEmail(req.getEmail());
		if (count == 0 || count < 0) {
			model.setEmail(req.getEmail());
			model.setPasscode(req.getPasscode());
			personRepo.save(model);
		} else
			throw new Exception("the email exit try new one");
		return req;
	}

	public boolean updateNameById(int id, String name) throws Exception {
		if (name != null || !name.equals(" ")) {
			personRepo.UpdateNameById(id, name);
			PersonModel model = new PersonModel();
			model.setName(name);
			return true;
		} else
			throw new Exception("check the name again");

	}

	public PersonResponse getlogin(String email, String passcode) throws Exception {

		PersonModel model = personRepo.getlogin(email, passcode).orElseThrow(() -> new Exception("didn't match"));
		System.out.println(email + " " + passcode);
		PersonResponse res = new PersonResponse();
		res.setCity(model.getCity());
		res.setEmail(model.getEmail());
		res.setPasscode(model.getPasscode());
		return res;

	}

	public PersonResponse update(PersonRequest req) throws Exception {
		try {
			System.out.println(req.getName());
			PersonModel model = personRepo.findById(req.getId()).orElseThrow(() -> new Exception("no id found"));
			if (req.getUpdateType().equals("name")) {
				model.setName(req.getName());
			}
			if (req.getUpdateType().equals("passcode")) {
				model.setPasscode(req.getPasscode());
			}
			if (req.getUpdateType().equals("email")) {
				model.setEmail(req.getEmail());
			}
			if (req.getUpdateType().equals("city")) {
				model.setCity(req.getCity());
			}

			if (req.getUpdateType().equals("phoneno")) {
				model.setCity(req.getName());
			}
			personRepo.save(model);

			PersonResponse res = new PersonResponse();
			res.setName(model.getName());
			res.setEmail(model.getEmail());
			res.setId(model.getId());
			res.setPasscode(model.getPasscode());
			res.setCity(model.getCity());
			return res;
		} catch (Exception e) {
			throw e;
		}

	}

	
	public void delete(Integer id) throws Exception {
		try {

			System.out.println(id);
			personRepo.deleteFromId(id);
		} catch (Exception e) {
			throw e;
		}
	}

	public List<PersonModel> getPages(Integer pageNo) throws Exception {
		try {
			return personRepo.getPages(PageRequest.of(pageNo, 10));

		} catch (Exception e) {
			throw e;
		}
	}

}
