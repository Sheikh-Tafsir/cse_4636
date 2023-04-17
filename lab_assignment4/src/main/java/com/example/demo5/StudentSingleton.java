package com.example.demo5;

import com.example.demo5.Student;

import javax.ejb.*;
import javax.persistence.*;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
@Singleton
@Startup
@Path("/studentsingleton")
public class StudentSingleton {
    @PersistenceContext(unitName = "myPersistenceUnit")
    private EntityManager entityManager;

    @GET
    @Path("/highest-cgpa")
    @Produces(MediaType.APPLICATION_JSON)
    @Lock(LockType.READ)
    public Student getStudentWithHighestCGPA() {
        TypedQuery<Student> query = entityManager.createQuery("Select s from Student where s.getCgpa() = (select max(cgpa) from Student )", Student.class);
        query.setMaxResults(1);
        return query.getSingleResult();
    }

}
