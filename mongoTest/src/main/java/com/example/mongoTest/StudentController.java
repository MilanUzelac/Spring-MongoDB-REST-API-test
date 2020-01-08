package com.example.mongoTest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Arrays;
import java.util.List;

@RestController
public class StudentController {
    @Autowired
    private StudentRepository studentRepository;

    @Autowired
    public StudentController(StudentRepository studentRepository) {
        this.studentRepository = studentRepository;
    }

    List<String> coursesList = Arrays.asList("AVT", "NRT");

    @GetMapping("/saveMongo")
    public String saveMongo(){
        studentRepository.saveAll(Arrays.asList(new Student("1","Milan",1234,"milan.uzelac96@gmail.com",coursesList,3.43f)));
        return "Successfully saved!";
    }

    @GetMapping("/retrieveStudents")
    public List<Student> listStudent(){
        return studentRepository.findAll();
    }
}
