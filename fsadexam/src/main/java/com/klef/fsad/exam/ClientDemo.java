package com.klef.fsad.exam;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import java.util.Date;

public class ClientDemo
{

public static void main(String[] args)
{

SessionFactory factory =
new Configuration().configure().buildSessionFactory();

Session session = factory.openSession();

session.beginTransaction();

/*// INSERT RECORD

Library lib = new Library();

lib.setName("Database Systems");
lib.setDescription("DBMS Book");
lib.setDate(new Date());
lib.setStatus("Available");

Library lib2 = new Library();
lib2.setName("Python Programming");   // your new record
lib2.setDescription("Python Book");
lib2.setDate(new Date());
lib2.setStatus("Available");
session.persist(lib2);
session.persist(lib);

session.getTransaction().commit();

System.out.println("Record Inserted Successfully");
*/
// DELETE RECORD

session.beginTransaction();

Library l = session.get(Library.class,1);

if(l != null)
{
session.remove(l);
System.out.println("Record Deleted Successfully");
}

session.getTransaction().commit();

session.close();
factory.close();

}
}