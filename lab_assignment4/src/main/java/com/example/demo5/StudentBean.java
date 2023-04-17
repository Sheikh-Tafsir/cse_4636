package com.example.demo5;

import com.example.demo5.Student;
import javax.ejb.Stateless;
import javax.persistence.*;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

@Stateless
@Path("/student")
public class StudentBean {
    @PersistenceContext(unitName = "myPersistenceUnit")
    private EntityManager entityManager;

    // Endpoint to add a new student
    @POST
    @Produces(MediaType.APPLICATION_JSON)
    public String addStudent(
            @QueryParam("id") int id,
            @QueryParam("name") String name,
            @QueryParam("semester") int semester,
            @QueryParam("cgpa") double cgpa) {

        Student student = new Student(id, name, semester, cgpa);
        entityManager.persist(student);
        String temp="";
        temp+=(id+" "+name+" "+semester+" "+cgpa+" ");
        return temp;
    }

    // Endpoint to get the name of a student by id
    @GET
    @Path("/{id}/name")
    @Produces(MediaType.APPLICATION_JSON)
    public String getStudentName(@PathParam("id") int id) {

        Student student = entityManager.find(Student.class, id);

        if (student == null) {
            return "not found";
        }

        String name = student.getName();
        return name;
    }

    // Endpoint to get the student with the higher cgpa between two students
    @GET
    @Path("/higher-cgpa")
    @Produces(MediaType.APPLICATION_JSON)
    public String getHigherCgpaStudent(
            @QueryParam("id1") int id1,
            @QueryParam("id2") int id2) {

        Student student1 = entityManager.find(Student.class, id1);
        Student student2 = entityManager.find(Student.class, id2);

        if (student1 == null || student2 == null) {
            return "not found";
        }

        Student higherCgpaStudent = student1.getCgpa() > student2.getCgpa() ? student1 : student2;
        return higherCgpaStudent.getName();
    }

    // Endpoint to update the name of a student by id
    @PUT
    @Path("/{id}/name")
    public String updateStudentName(@PathParam("id") int id, @QueryParam("name") String name) {

        Student student = entityManager.find(Student.class, id);

        if (student == null) {
            return "not found";
        }

        student.setName(name);
        entityManager.merge(student);

        return student.getName();
    }
}
