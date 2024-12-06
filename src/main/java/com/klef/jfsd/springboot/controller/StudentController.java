package com.klef.jfsd.springboot.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.klef.jfsd.springboot.model.StudentModels;
import com.klef.jfsd.springboot.repositry.StudentRepo;
import com.klef.jfsd.springboot.service.StudentService;

@RestController
public class StudentController {
	
	@Autowired
	private StudentService studService;
	
	@Autowired
    private StudentRepo studentRepository;
	
	
	@GetMapping("/")
	public String test() {
		return "Working fine";
		
	}
	
	@GetMapping("/get/{id}")
    public StudentModels getStudentById(@PathVariable int id) {
        return studentRepository.findById(id).orElse(null);
    }
	
	@GetMapping("/get-all")
	public List<StudentModels> getMethodName(){
		return studService.getAll();
	}
	
	@PostMapping("/insert-student")
	public ResponseEntity<String> postMethodName(@RequestBody StudentModels student){
		
		try {
			studService.insertStudent(student);
			return ResponseEntity.ok().body("student inserted");
			
		}catch(Exception e) {
			return ResponseEntity.badRequest().body("Erroe Inserting"+e.getLocalizedMessage());
			
		}
		
		
	}
	
	@PutMapping("update/{id}")
	public ResponseEntity<String> putMethodName(@PathVariable String id, @RequestBody StudentModels student){
		try {
			studService.updateStudent(Integer.parseInt(id), student);
			return ResponseEntity.ok().body("update Student");
		}catch(Exception e) {
			return ResponseEntity.badRequest().body("Error Updating"+e.getLocalizedMessage());
					
		}
		
	}
	
	
	@DeleteMapping("delete/{id}")
	public ResponseEntity<String> deleteStudent(@PathVariable String id){
		try {
			studService.deleteStudent(Integer.parseInt(id));
			return ResponseEntity.ok().body("deleted student");
		}catch(Exception e){
			return ResponseEntity.badRequest().body("Error deleting"+e.getLocalizedMessage());
			
		}
	}
	
	

	
	
	
}
