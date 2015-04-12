package com.ethien.dao;
 
import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import com.ethien.model.Customer;
 
public class CustomerDAOImpl implements CustomerDAO {
 
    private SessionFactory sessionFactory;
 
    public void setSessionFactory(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }
    
    public void save(Customer customer) {
        Session session = this.sessionFactory.openSession();
        Transaction tx = session.beginTransaction();
        session.persist(customer);
        tx.commit();
        session.close();
    }

    @SuppressWarnings("unchecked")
    public List<Customer> list() {
        Session session = this.sessionFactory.openSession();
        List<Customer> customerList = session.createQuery("from Customer").list();
        session.close();
        return customerList;
    }
}
