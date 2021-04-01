package com.Hibernate.InstructorMain;
import com.Hibernate.Entity.Instructor;
import com.Hibernate.Entity.InstructorDetail;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

// THIS CLASS HAVE APPLIES CRUD OPERATIONS TO THE JVA CODE AND JDBC

public class Main {

    public static void main(String[] args) {
        SessionFactory sessionFactory = new Configuration().configure("hibernate.cfg.xml")
                .addAnnotatedClass(InstructorDetail.class).addAnnotatedClass(Instructor.class)
                .buildSessionFactory();

        Session session = sessionFactory.getCurrentSession();

        try {


//CREATE DATA

                Instructor instructor = new Instructor("Dammy","Deo","sammy@gmail.com");

                InstructorDetail instructorDetail = new InstructorDetail("Codeobar","Listen music");

                instructor.setInstructorDetail(instructorDetail);

// DELETE DATA

            session.beginTransaction();

            int ID = 4;
            InstructorDetail instructorDetail2 = session.get(InstructorDetail.class,ID);
            System.out.println("Getting ID = 1");
            System.out.println(instructorDetail2);
            System.out.println("Getting associate instructor :" + instructorDetail2.getInstructor());


//            session.save(instructorDetail);
//            session.save(instructor);

            session.getTransaction().commit();

            System.out.println("Done !!!....");

        }finally {
            session.close();
            sessionFactory.close();
        }
    }
}