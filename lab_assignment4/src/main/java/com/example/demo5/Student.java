package com.example.demo5;
import javax.persistence.*;

@Entity
@Table(name = "student")

public class Student {
    @Id
    @Column(name = "id")
    private int id;

    @Column(name = "name")
    private String name;

    @Column(name = "semester")
    private int semester;

    @Column(name = "cgpa")
    private double cgpa;

    // Default constructor
    public Student() {

    }

    // Constructor with parameters
    public Student(int id, String name, int semester, double cgpa) {
        this.id=id;
        this.name = name;
        this.semester = semester;
        this.cgpa = cgpa;
    }

    // Getters and Setters
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getSemester() {
        return semester;
    }

    public void setSemester(int semester) {
        this.semester = semester;
    }

    public double getCgpa() {
        return cgpa;
    }

    public void setCgpa(double cgpa) {
        this.cgpa = cgpa;
    }

}
