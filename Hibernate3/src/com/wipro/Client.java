package com.wipro;

 

import java.util.*;
import org.hibernate.*;

 

public class Client {
    public static void main(String[] args) {
        // Create Session Object using try-with-resources
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            // Perform life-cycle operations under a transaction
             Transaction tx = session.beginTransaction();

            // Create a Student object and save it
            Student s1 = new Student();
            // s1.setId(1); //generator class=assigned
            s1.setName("Cathy");
            session.save(s1); // part of the cache now
           // session.flush(); // push all the objects from the cache to the DB

           tx.commit();
        } catch (HibernateException e) {
            e.printStackTrace();
        }
    }
}