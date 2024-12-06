package com.klef.jfsd.springboot.service;

import java.util.List;

import com.klef.jfsd.springboot.model.StudentModels;

public interface StudentService {
	
	public void insertStudent(StudentModels student); 
	public List<StudentModels> getAll(); 
	public void updateStudent(Integer id,StudentModels updatedBody); 
	public void deleteStudent(Integer id);

}
