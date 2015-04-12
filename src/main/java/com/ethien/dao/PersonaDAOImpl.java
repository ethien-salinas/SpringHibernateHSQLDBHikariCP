package com.ethien.dao;
 
import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import com.ethien.model.Persona;
 
public class PersonaDAOImpl implements PersonaDAO {
 
    private SessionFactory sessionFactory;
 
    public void setSessionFactory(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

    public void save(Persona p) {
        Session session = this.sessionFactory.openSession();
        Transaction tx = session.beginTransaction();
        session.persist(p);
        tx.commit();
        session.close();
    }

    @SuppressWarnings("unchecked")
    public List<Persona> list() {
        Session session = this.sessionFactory.openSession();
        List<Persona> personList = session.createQuery("from Persona").list();
        session.close();
        return personList;
    }

	@SuppressWarnings("unchecked")
	public Persona getPersonaByNombre(String nombre) {
		Session session = this.sessionFactory.openSession();
		List<Persona> personList = session.createQuery("select p from Persona p where p.nombre = :pName")
				.setParameter("pName", nombre).list();
		if(personList.size() != 0)
			return personList.get(0);
		else
			return null;
	}

}
