package com.example.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.model.Student;
import com.example.demo.service.StudentService;

@RestController
@RequestMapping("/api/students")
@CrossOrigin(origins = "*")
public class StudentController {
    @Autowired
    private StudentService studentService;

    @PostMapping
    public ResponseEntity<Student> saveStudents(@RequestBody Student student){
        return new ResponseEntity<Student>(studentService.saveStudent(student),HttpStatus.CREATED);

    }

    @GetMapping
    public List<Student> getAllStudents(){
        return studentService.getAllStudents();

    }


    @GetMapping("{id}")
    public ResponseEntity<Student> getStudentById(@PathVariable("id") long studentID){
        return new  ResponseEntity<Student>(studentService.getStudentById(studentID),HttpStatus.OK);
    }

    @PutMapping("{id}")
    public ResponseEntity<Student> updateStudent(@PathVariable("id") long id,@RequestBody Student student){
        return new ResponseEntity<Student>(studentService.updateStudent(student, id),HttpStatus.OK);
    }

    @DeleteMapping("{id}")
 public ResponseEntity<String> deleteStudent(@PathVariable("id") long id){
 //delete employee from db
 studentService.deleteStudent(id);
 return new ResponseEntity<String>("Student deleted Successfully.",HttpStatus.OK);
 }

}
