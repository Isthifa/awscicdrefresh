package com.example.springawstest.controller;

import com.example.springawstest.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/students")
public class StudentController {
    @Autowired
    private StudentService studentService;

    @PostMapping("/add")
    public String addStudent(@RequestBody String name, int age, String department) {
        return studentService.addStudent(name, age, department);
    }
    @GetMapping("/get/{name}")
    public String getStudent(@PathVariable String name) {
        return studentService.getStudent(name);
    }
    @PostMapping("/delete")
    public String deleteStudent(@RequestBody String name) {
        return studentService.deleteStudent(name);
    }
    @PutMapping("/update")
    public String updateStudent(@RequestBody String name, int age, String department) {
        return studentService.updateStudent(name, age, department);
    }
    @GetMapping("/getAll")
    public String getAllStudents() {
        return studentService.getAllStudents();
    }

    @GetMapping("/getByDepartment")
    public String getAllStudentByDepartment(@RequestBody String department) {
        return studentService.getAllStudentByDepartment(department).toString();
    }
}
