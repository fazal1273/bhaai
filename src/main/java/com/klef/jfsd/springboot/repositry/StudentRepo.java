package com.klef.jfsd.springboot.repositry;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.klef.jfsd.springboot.model.StudentModels;

@Repository
public interface StudentRepo extends JpaRepository<StudentModels, Integer> {
	
	@Query("SELECT s FROM StudentModels s WHERE s.id = ?1") 
	public StudentModels getStudentById(Integer id);

}
