package com.example.springawstest.service;

import com.example.springawstest.entity.Student;

import java.util.List;

public interface StudentService {
    /**
     * Adds a new student.
     *
     * @param name       the name of the student
     * @param age        the age of the student
     * @param department the department of the student
     * @return a message indicating success or failure
     */
    String addStudent(String name, int age, String department);

    /**
     * Retrieves a student's information.
     *
     * @param name the name of the student
     * @return a string containing the student's information
     */
    String getStudent(String name);
    /**
     * Deletes a student.
     *
     * @param name the name of the student to delete
     * @return a message indicating success or failure
     */
    String deleteStudent(String name);

    /**
     * Updates a student's information.
     *
     * @param name       the name of the student
     * @param age        the new age of the student
     * @param department the new department of the student
     * @return a message indicating success or failure
     */
    String updateStudent(String name, int age, String department);

    /**
     * Retrieves all students' information.
     *
     * @return a string containing all students' information
     */
    String getAllStudents();


    List<Student> getAllStudentByDepartment(String department);
}
