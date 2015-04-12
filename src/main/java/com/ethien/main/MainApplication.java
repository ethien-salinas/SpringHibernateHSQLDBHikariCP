package com.ethien.main;

import java.util.List;

import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.ethien.dao.CustomerDAO;
import com.ethien.dao.PersonaDAO;
import com.ethien.model.Customer;
import com.ethien.model.Persona;

public class MainApplication {

	public static void main(String[] args) {

		// ***** Spring context call *****
		ClassPathXmlApplicationContext cxt = new ClassPathXmlApplicationContext("spring-ctx.xml");

		// ***** Retreive of DAO's *****
		PersonaDAO personDAO = cxt.getBean("personaDAOImpl", PersonaDAO.class);
		CustomerDAO customerDAO = cxt.getBean("customerDAOImpl", CustomerDAO.class);

		// ***** Some objects to save *****
		Persona person = new Persona();
		person.setNombre("Elizabeth");
		person.setPais("México");

		Persona person2 = new Persona();
		person2.setNombre("Ethien");
		person2.setPais("Francia");

		Persona person3 = new Persona();
		person3.setNombre("Nallely");
		person3.setPais("Brasil");

		Customer customer = new Customer();
		customer.setFirstname("Homer");
		customer.setLastname("Simpson");
		customer.setCity("Springfield");
		customer.setStreet("Evergreen Terrace");

		Customer customer2 = new Customer();
		customer2.setFirstname("Marge");
		customer2.setLastname("Simpson");
		customer2.setCity("Springfield");
		customer2.setStreet("Evergreen Terrace");

		// ***** use of personDAO to save *****
		personDAO.save(person);
		personDAO.save(person2);
		personDAO.save(person3);

		// ***** use of personDAO to list *****
		List<Persona> listPersonas = personDAO.list();
		for (Persona p : listPersonas) {
			System.out.println("Person List::" + p);
		}

		// ***** use of personDAO to retreive one object *****
		System.out.println(personDAO.getPersonaByNombre("Ethien"));

		// ***** use of customerDAO to save *****
		customerDAO.save(customer);
		customerDAO.save(customer2);

		// ***** use of customerDAO to list *****
		List<Customer> listCustomers = customerDAO.list();
		for (Customer c : listCustomers) {
			System.out.println("Customer List::" + c);
		}

		// ***** Spring close *****
		cxt.close();
	}
}