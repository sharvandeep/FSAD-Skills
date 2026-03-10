package com.sharvan.hibernate;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.hibernate.query.Query;

public class HQLDemo {

    public static void main(String[] args) {

        SessionFactory factory = new Configuration()
                .configure()
                .buildSessionFactory();

        Session session = factory.openSession();

        /* -------------------------------
           1. SORT PRODUCTS BY PRICE ASC
        --------------------------------*/
        Query<Product> q1 = session.createQuery(
                "from Product order by price asc", Product.class);

        List<Product> list1 = q1.list();

        System.out.println("Products sorted by price ASC:");
        for (Product p : list1) {
            System.out.println(p.getName() + " - " + p.getPrice());
        }

        /* -------------------------------
           2. SORT PRODUCTS BY PRICE DESC
        --------------------------------*/
        Query<Product> q2 = session.createQuery(
                "from Product order by price desc", Product.class);

        List<Product> list2 = q2.list();

        System.out.println("\nProducts sorted by price DESC:");
        for (Product p : list2) {
            System.out.println(p.getName() + " - " + p.getPrice());
        }

        /* -------------------------------
           3. PAGINATION
        --------------------------------*/
        Query<Product> q3 = session.createQuery(
                "from Product", Product.class);

        q3.setFirstResult(0);  // start index
        q3.setMaxResults(3);   // number of records

        List<Product> page = q3.list();

        System.out.println("\nPagination (First 3 products):");
        for (Product p : page) {
            System.out.println(p.getName());
        }

        /* -------------------------------
           4. COUNT PRODUCTS
        --------------------------------*/
        Query<Long> q4 = session.createQuery(
                "select count(*) from Product", Long.class);

        Long count = q4.uniqueResult();

        System.out.println("\nTotal Products: " + count);

        /* -------------------------------
           5. MIN AND MAX PRICE
        --------------------------------*/
        Query<Object[]> q5 = session.createQuery(
                "select min(price), max(price) from Product", Object[].class);

        Object[] result = q5.uniqueResult();

        System.out.println("\nMinimum Price: " + result[0]);
        System.out.println("Maximum Price: " + result[1]);

        /* -------------------------------
           6. LIKE QUERY
        --------------------------------*/
        Query<Product> q6 = session.createQuery(
                "from Product where name like 'L%'", Product.class);

        List<Product> likeList = q6.list();

        System.out.println("\nProducts starting with L:");
        for (Product p : likeList) {
            System.out.println(p.getName());
        }

        session.close();
        factory.close();
    }
}