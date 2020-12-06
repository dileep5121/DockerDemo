package com.BED2.OnlineQuiz.RestController;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.BED2.OnlineQuiz.Pojo.Authorities;
import com.BED2.OnlineQuiz.Pojo.TestDetails;
import com.BED2.OnlineQuiz.Pojo.Users;
import com.BED2.OnlineQuiz.SpringData.AuthorityRepository;
import com.BED2.OnlineQuiz.SpringData.TestRepository;
import com.BED2.OnlineQuiz.SpringData.UserRepository;

@RestController
public class RestController1 {
	
	
	@Autowired
	private UserRepository Userrepository;
	
	@Autowired
	private AuthorityRepository Authorityrepository;
	
	
	@Autowired
	private TestRepository Testrepository;
	
	
	//Get-Mapping
	@GetMapping("/GetAllUsers")
	public List<Users> getAll() {
		
		
  return (List<Users>)Userrepository.findAll();
	}
	
	
	//Get All Test-Taken
	@GetMapping("/GetAllTest")
	public List<TestDetails> testDetails(){
		
		return (List<TestDetails>)Testrepository.findAll();
	}
	
	
	
    //Post Mapping
	@PostMapping("/addNewUser")
	public Users addNewUser(@Valid @RequestBody Users u) {
		
		
	return Userrepository.save(u);
		
	}
	
	
	
	//Post-Mapping
	@PostMapping("/addNewAuthority")
	public Authorities addNewAuthority( @RequestBody Authorities auth) {
		
		return Authorityrepository.save(auth);
		
		}
	
	
	
	@PutMapping("/addResult")
	public TestDetails addResult( @RequestBody TestDetails details) {
		
		return Testrepository.save(details);
		
		
		
	}
	
	
	

}
