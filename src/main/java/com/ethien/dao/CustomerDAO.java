package com.ethien.dao;

import java.util.List;

import com.ethien.model.Customer;

public interface CustomerDAO {

	public void save(Customer customer);
    public List<Customer> list();

}
