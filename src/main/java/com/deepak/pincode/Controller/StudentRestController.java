package com.deepak.pincode.Controller;

import com.deepak.pincode.entities.Student;
import jakarta.annotation.PostConstruct;
import org.springframework.web.bind.annotation.*;


import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/api")
public class StudentRestController {

    List<Student> students;

    @PostConstruct
    public void loadData(){
        students = new ArrayList<>();
        students.add(new Student("deepak","solanki"));
        students.add(new Student("anil", "solanki"));
        students.add(new Student("prabhat","solanki"));
    }

    //define endpoint for "/students" - return list of students

    @GetMapping("/students")
    public List<Student> getStudents(){
        return students;
    }

    @GetMapping ("/student")
    public Student getStudent(@RequestParam int id){

//        //just check for the id limit
//        if (id>=students.size() || id < 0){
//            throw new StudentNotFoundException("Student id not found-"+id);
//        }

        return students.get(id);
    }

    @PostMapping("/student")
    public Student putStudent(@RequestBody Student student){
        this.students.add(student);
        return student;
    }

}
