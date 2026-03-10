package com.sharvan.hibernate;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class HibernateMain {

public static void main(String[] args) {

SessionFactory factory = new Configuration()
.configure()
.buildSessionFactory();

Session session = factory.openSession();
session.beginTransaction();

// CREATE
Product p1 = new Product("Laptop","Gaming Laptop",80000,5);
Product p2 = new Product("Phone","Android Phone",25000,10);

session.save(p1);
session.save(p2);

// READ
Product product = session.get(Product.class,1);
System.out.println(product.getName());

// UPDATE
product.setPrice(75000);
session.update(product);

// DELETE
Product deleteProduct = session.get(Product.class,2);
session.delete(deleteProduct);

session.getTransaction().commit();
session.close();

}
}