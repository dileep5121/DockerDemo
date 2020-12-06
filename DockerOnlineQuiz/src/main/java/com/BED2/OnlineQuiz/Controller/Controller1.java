package com.BED2.OnlineQuiz.Controller;

import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.BED2.OnlineQuiz.Pojo.Questions;

@Controller
public class Controller1 {
	
	
	
	
	
	//Redirecting to Login-Page
	
	@RequestMapping("/")
	public String Login() {
		
		
		
		return "login";
	}

	
	//Candidate-Mapping
	@RequestMapping("/candidate")
	public String User() {
		
		
		return "candidate";
	}
	
	
	
	//Admin-Mapping
	@RequestMapping("/admin")
	public String Admin() {
		
		return "admin";
	}
	
	
	
	//New Registration
	@RequestMapping("/register")
	public String Register() {
		
		return "register";
	}
	
	
	
	//Spring-Assessment
	
	@RequestMapping("/candidate/SpringAssessment")
	public String Spring(Model model) {
		
		
		model.addAttribute("questions", new Questions());
		
		return "SpringAssessment";
	}
	
	
	
	
	@RequestMapping("/candidate/HibernateAssessment")
	//Hibernate-Assessment
	
	public String Hibernate(Model model){
		
		model.addAttribute("questions", new Questions());
		
		
		return "HibernateAssessment";
	}
	
	
	
}






