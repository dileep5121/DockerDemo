package com.BED2.OnlineQuiz.Pojo;




import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
public class TestDetails {

	
	
	@Id
	private String Test_Id;
	
	private String email;
	
	@Temporal(TemporalType.TIMESTAMP)
	private Date date;
	
	
	private String Assessment;
	
	private int Test_Marks;
	
	private int Total_Marks;
	
	private String result;
	
	public TestDetails() {
		
		
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getAssessment() {
		return Assessment;
	}

	public void setAssessment(String assessment) {
		Assessment = assessment;
	}

	public int getTest_Marks() {
		return Test_Marks;
	}

	public void setTest_Marks(int test_Marks) {
		Test_Marks = test_Marks;
	}

	public int getTotal_Marks() {
		return Total_Marks;
	}

	public void setTotal_Marks(int total_Marks) {
		Total_Marks = total_Marks;
	}

	public String getResult() {
		return result;
	}

	public void setResult(String result) {
		this.result = result;
	}

	public TestDetails( String Test_Id,Date date ,String email, String assessment, int test_Marks, int total_Marks, String result) {
		
		
		this.date=new Date();
		this.Test_Id=Test_Id;
		this.email = email;
		Assessment = assessment;
		Test_Marks = test_Marks;
		Total_Marks = total_Marks;
		this.result = result;
	}

	public String getTest_Id() {
		return Test_Id;
	}

	public void setTest_Id(String test_Id) {
		Test_Id = test_Id;
	}

	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}
	
	
	
	
	
	
	
	
}
