package com.klef.fsad.exam;

import org.hibernate.Session;
import org.hibernate.Transaction;
import java.util.Date;

public class ClientDemo {
    public static void main(String[] args) {
        insertRecord();
        deleteRecord(1); // Example: delete record with ID=1
    }

    public static void insertRecord() {
        Session session = HibernateUtil.getSessionFactory().openSession();
        Transaction tx = session.beginTransaction();

        Library lib = new Library();
        lib.setName("Digital Library");
        lib.setDescription("Contains e-books and journals");
        lib.setDate(new Date());
        lib.setStatus("Active");

        session.persist(lib);
        tx.commit();
        session.close();

        System.out.println("Record Inserted Successfully!");
    }

    public static void deleteRecord(int id) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        Transaction tx = session.beginTransaction();

        Library lib = session.get(Library.class, id);
        if (lib != null) {
            session.remove(lib);
            System.out.println("Record Deleted Successfully!");
        } else {
            System.out.println("Record Not Found!");
        }

        tx.commit();
        session.close();
    }
}