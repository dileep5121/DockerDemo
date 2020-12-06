package com.BED2.OnlineQuiz.SpringData;

import org.springframework.data.repository.CrudRepository;

import com.BED2.OnlineQuiz.Pojo.TestDetails;

public interface TestRepository extends CrudRepository<TestDetails,String> {

}
