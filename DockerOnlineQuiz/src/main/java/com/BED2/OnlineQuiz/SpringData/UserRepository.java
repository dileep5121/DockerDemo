package com.BED2.OnlineQuiz.SpringData;

import org.springframework.data.repository.CrudRepository;

import com.BED2.OnlineQuiz.Pojo.Users;

public interface UserRepository extends CrudRepository<Users,String> {

	
	
}
