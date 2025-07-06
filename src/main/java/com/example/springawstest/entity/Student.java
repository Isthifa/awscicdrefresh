package com.example.springawstest.entity;

public record Student(String name, int age, String department) {

    public Student {
        if (name == null || name.isBlank()) {
            throw new IllegalArgumentException("Name cannot be null or blank");
        }
        if (age <= 0) {
            throw new IllegalArgumentException("Age must be a positive integer");
        }
        if (department == null || department.isBlank()) {
            throw new IllegalArgumentException("Department cannot be null or blank");
        }
    }
}
