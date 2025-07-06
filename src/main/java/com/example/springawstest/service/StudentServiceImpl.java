package com.example.springawstest.service;

import com.example.springawstest.entity.Student;
import jakarta.annotation.PostConstruct;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StudentServiceImpl implements StudentService{
    List <Student> students;
    @PostConstruct
    public void init() {
        students = List.of(
                new Student("Alice", 20, "Computer Science"),
                new Student("Bob", 22, "Mathematics"),
                new Student("Charlie", 21, "Physics"));
    }

    @Override
    public String addStudent(String name, int age, String department) {
        return students.stream()
                .filter(student -> student.name().equals(name))
                .findFirst()
                .map(student -> "Student already exists: " + student)
                .orElseGet(() -> {
                    Student newStudent = new Student(name, age, department);
                    students.add(newStudent);
                    return "Student added successfully: " + newStudent;
                });
    }

    @Override
    public String getStudent(String name) {
        return students.stream()
                .filter(student -> student.name().equals(name))
                .findFirst()
                .map(student -> "Student found: " + student)
                .orElse("Student not found: " + name);
    }

    @Override
    public String deleteStudent(String name) {
        return students.stream()
                .filter(student -> student.name().equals(name))
                .findFirst()
                .map(student -> {
                    students.remove(student);
                    return "Student deleted successfully: " + student;
                })
                .orElse("Student not found: " + name);
    }

    @Override
    public String updateStudent(String name, int age, String department) {
        return students.stream()
                .filter(student -> student.name().equals(name))
                .findFirst()
                .map(student -> {
                    students.remove(student);
                    Student updatedStudent = new Student(name, age, department);
                    students.add(updatedStudent);
                    return "Student updated successfully: " + updatedStudent;
                })
                .orElse("Student not found: " + name);
    }

    @Override
    public String getAllStudents() {
        return students.stream()
                .map(Student::toString)
                .reduce("All Students:\n", (acc, student) -> acc + student + "\n");
    }

    @Override
    public List<Student> getAllStudentByDepartment(String department) {
        return students.stream()
                .filter(student -> student.department().equalsIgnoreCase(department))
                .toList();
    }
}
