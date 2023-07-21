package com.wipro;
import java.util.*;
import org.hibernate.*;

 

public class Client {
    public void addStudent(Student student,Session session){
        session.save(student);

 

    }
    public void updateStudent(int studentid,String studentname,Session session){
        Student s=(Student)session.load(Student.class,studentid);
        s.setId(studentid);
        s.setName(studentname);
        session.update(s);
    }
    public void deleteStudent(int studentid,Session session){
            Student s=(Student)session.load(Student.class,studentid);
            session.delete(s);
    }
    
    public void displayStudent(Session session){
        Query query=session.createQuery("from Student");
            List<Student> list=query.list();
        for (Student t:list)
            System.out.println(t.getId()+" "+t.getName());
            System.out.println("\n");
     }
    

    public static void main(String args[]){
        Session session=HibernateUtil.getSessionFactory().openSession();
        Transaction tx=session.beginTransaction();
       // Student s1=new Student(3,"Ranga");
     //  Student s2=new Student(4,"Durai");
        try {
          //new Client().addStudent(s1, session);
         //  new Client().addStudent(s2, session);
         //  new Client().updateStudent(3, "Sri ranga", session);
          // new Client().deleteStudent(4,session);
            new Client().displayStudent(session);

        }
        catch(HibernateException e) {
            e.printStackTrace();
            tx.rollback();
        }

        tx.commit();

        session.close();

 

    }
}