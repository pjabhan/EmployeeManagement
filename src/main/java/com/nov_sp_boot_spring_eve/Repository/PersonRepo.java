package com.nov_sp_boot_spring_eve.Repository;

import java.util.List;
import java.util.Optional;

import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.transaction.Transactional;

import org.springframework.boot.autoconfigure.data.web.SpringDataWebProperties.Pageable;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.nov_sp_boot_spring_eve.Model.CityModel;
import com.nov_sp_boot_spring_eve.Model.PersonModel;
import com.nov_sp_boot_spring_eve.Request.CityCreateRequest;

@Repository
public interface PersonRepo  extends JpaRepository<PersonModel, Integer>{
	
	
	
	@Query("Select person from  PersonModel person where person.city like %?1%")
	List<PersonModel> getPersonByCityName(String city);
	
	@Query("Select person from PersonModel person where person.name like %?1%")
	List<PersonModel> getDetailsByPersonName(String name);
	
	@Query ("Select person from PersonModel person where person.email= ?1 and person.passcode= ?2")
	List<PersonModel> getlogin2(String email , String passcode);

	@Query ("Select person from PersonModel person where person.email= ?1 and person.passcode= ?2")
	Optional<PersonModel> getlogin(String email , String passcode);

		@Query("Select count(person.id)from PersonModel person where person.email=?1")
		Integer getUserByEmail(String email);
		
		
		@Transactional
		@Modifying
		@Query ("update  from PersonModel person set person.name=?2 where person.id=?1")
		Integer UpdateNameById(Integer id,String name); 
	   
		
		@Transactional
		@Modifying
		@Query ("delete  PersonModel person where person.id = ?1")
		void deleteFromId(Integer id);
		
		
		  @Query("Select person from PersonModel person")
		  List<PersonModel> getPages(PageRequest page);
		 
		  @Query("Select person from PersonModel person where person.id=?1")
		  List<PersonModel> getPersonDetailById(Integer id);
		  
		 
}
