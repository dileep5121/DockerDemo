package com.BED2.OnlineQuiz.Service;

import java.util.Arrays;
import java.util.Date;
import java.util.List;

import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.BED2.OnlineQuiz.Pojo.Authorities;
import com.BED2.OnlineQuiz.Pojo.Questions;
import com.BED2.OnlineQuiz.Pojo.TestDetails;
import com.BED2.OnlineQuiz.Pojo.Users;





@Service
public class UserService {

	RestTemplate template=new RestTemplate();
	
	
	
	
	
	
	public void newUser(Users u,Authorities a) {
		
     final String uri="http://localhost:8080/addNewUser";
     
     final String url="http://localhost:8080/addNewAuthority";
     
     
	  RestTemplate template=new RestTemplate();
		
		Users user=template.postForObject(uri, u, Users.class);
		
		Authorities auth=template.postForObject(url, a, Authorities.class);
		
		}
	
	
	
	
	
	
	public List<Users> getAllUsers() {
		
		
		
		final String uri="http://localhost:8080/GetAllUsers";
		
		Users[] u=template.getForObject(uri,Users[].class);
		
		List<Users> userList=Arrays.asList(u);
		

				return userList;
		
	}
	
	
	
	
	
	
	
	public List<TestDetails> TestDetails(){
		
		final String uri="http://localhost:8080/GetAllTest";
		
		TestDetails[] t=template.getForObject(uri,TestDetails[].class);
		
		List<TestDetails> test=Arrays.asList(t);
	
		return test;
		
	}
	
	
	
	
	
	
	
	
	
	public int checkSpring(Questions q) {
		
		int marks=0;
		final String uri="http://localhost:8080/addResult";
		String result="";
		
		String[] question= {"J2EE App Development Framework","Inversion Of Control","Aspect Oriented Programming","Application Context","Dispatcher Servlet"};
		
	     String question1[]= {q.getQ1(), q.getQ2(),q.getQ3(),q.getQ4(),q.getQ5()};
  
        for(int i=0;i<question.length;i++) {
    	 
        	if(question[i].equals(question1[i]))
    			marks++;
    	 }
    
    if(marks*10>=30)
     result="Pass";
    else
     result="Fail";
    
    Authentication authentication=SecurityContextHolder.getContext().getAuthentication();
	String email=authentication.getName();
	String id="Spring_"+email;
    
     TestDetails details=new TestDetails(id,new Date(),email,"Spring-L1",marks*10,50,result);
    
     template.put(uri, details, TestDetails.class);
    
     
    return marks*10;
	
	}
	
	
	
	
	
	
	
	
	
public int checkHibernate(Questions q) {
		
		int marks=0;
		String result="";
		
		final String uri="http://localhost:8080/addResult";
		
		String question1[]= {q.getQ1(), q.getQ2(),q.getQ3(),q.getQ4(),q.getQ5()};
		
		String question[]= {"Object Relational Mapping","uni-directional & bi-directional","configuration file","Hibernate Query Language","isolation levels"};
		

        for(int i=0;i<question.length;i++) {
    	 
        	if(question[i].equals(question1[i]))
    			marks++;
    	 }
    
    if(marks*10>=30)
     result="Pass";
    else
     result="Fail";
    
    Authentication authentication=SecurityContextHolder.getContext().getAuthentication();
   	String email=authentication.getName();
   	String id="Hibernate_"+email;
    
     TestDetails details=new TestDetails(id,new Date(),email,"Hibernate_L1",marks*10,50,result);
    
     template.put(uri, details, TestDetails.class);
    
     
    return marks*10;
		
		
		
	}
	
	
	
	
}


