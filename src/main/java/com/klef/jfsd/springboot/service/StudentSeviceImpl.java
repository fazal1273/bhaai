package com.klef.jfsd.springboot.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.klef.jfsd.springboot.model.StudentModels;
import com.klef.jfsd.springboot.repositry.StudentRepo;

@Service
public class StudentSeviceImpl implements StudentService {
	
	@Autowired 
	private StudentRepo studRepo; 

	@Override
	public void insertStudent(StudentModels student) {
		// TODO Auto-generated method stub
		 studRepo.save(student); 
         System.out.println("Student Inserted successfully"); 
		
	}

	@Override
	public List<StudentModels> getAll() {
		// TODO Auto-generated method stub
		return studRepo.findAll(); 
	}

	@Override
	public void updateStudent(Integer id, StudentModels updatedBody) {
		// TODO Auto-generated method stub
		try { 
            StudentModels std = studRepo.getStudentById(id); 
            std.setName(updatedBody.getName()); 
            std.setCgpa(updatedBody.getCgpa()); 
            studRepo.save(std); 
            System.out.println("Updated student"); 
        } 
catch (Exception e) { 
            System.err.println(e.getLocalizedMessage()); 
        } 
    }
		
		

	@Override
	public void deleteStudent(Integer id) {
		// TODO Auto-generated method stub
		studRepo.delete(studRepo.getStudentById(id)); 
		
	}

}
