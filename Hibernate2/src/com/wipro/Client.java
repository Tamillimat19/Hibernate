package com.wipro;

 

import java.util.*;
import org.hibernate.*;
/**
*
* @author savits
*/

 


public class Client {
    public static void main(String[] args){
        //Create Session Object
        Session session=HibernateUtil.getSessionFactory().openSession();

 

        //Perform life-cycle operations under a transaction
        Transaction tx=null;
        try {
            tx=session.beginTransaction();

 

            //Create a Student object and save it
            Student s1=new Student();
            s1.setId(56);
            s1.setName("Roger");
            session.save(s1);
            tx.commit();
        }
        catch (HibernateException e){
            e.printStackTrace();
        }
        finally {
            session.close();
        }
    }
}

 