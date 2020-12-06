package com.BED2.OnlineQuiz.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.BED2.OnlineQuiz.Pojo.Authorities;
import com.BED2.OnlineQuiz.Pojo.Questions;
import com.BED2.OnlineQuiz.Pojo.TestDetails;
import com.BED2.OnlineQuiz.Pojo.Users;
import com.BED2.OnlineQuiz.Service.UserService;

@Controller
public class RestClient {
	
	@Autowired
	UserService userService;
	
	@RequestMapping("/newUser")
	public String Register(
			@RequestParam(value="fname") String fname,
			@RequestParam(value="lname") String lname,
			@RequestParam(value="password") String password,
			@RequestParam(value="email") String email
			) {
		
		password="{noop}"+password;
	
		Users u=new Users(email,fname,lname,password,"candidate",1);
		
		Authorities a=new Authorities(email,"ROLE_candidate");
		
		 userService.newUser(u,a);
		  
		  return "success";
		 
	}
	
	
	
	@RequestMapping("/admin/getAllUsers")
	public String GetAllUsers(Model model) {
		
	List<Users> u=userService.getAllUsers();
	
	model.addAttribute("users",u);
		return "allUsers";
	}
	
	

	
	
	
	
	
	
	@RequestMapping("/admin/getTestTaken")
	public String GetTestTaken(Model model) {
		
		
		List<TestDetails> t=userService.TestDetails();
		
		model.addAttribute("results", t);
		
		return "allTest";
	}
	
	
	
	
	
	
	
		
	
	
	@RequestMapping("/Springcheck")
	public String Springcheck(
			@ModelAttribute("questions") Questions q
			) {
			
		int marks=userService.checkSpring(q);
		
		if(marks>=30)
		
			return "pass";
		
		else
			
			return "fail";
	}
	
	
	
	
	
	@RequestMapping("/Hibernatecheck")
	public String Hibernatecheck(
			@ModelAttribute("questions") Questions q
			) {
		
		int marks=userService.checkHibernate(q);
		
		if(marks>=30)
		
		return "pass";
		
		else
			
			return "fail";
		
		
	}
	
	
	
	
	

}
