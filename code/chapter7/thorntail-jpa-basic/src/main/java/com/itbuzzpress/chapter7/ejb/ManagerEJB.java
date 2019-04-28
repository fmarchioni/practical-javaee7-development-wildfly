package com.itbuzzpress.chapter7.ejb;

import java.util.List;

import javax.ejb.Stateless;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;

import javax.persistence.PersistenceContext;

import javax.persistence.PersistenceUnit;
import javax.persistence.Query;

import com.itbuzzpress.chapter7.entity.Customer;
import com.itbuzzpress.chapter7.entity.Request;

@Stateless
public class ManagerEJB {
	@PersistenceContext
	EntityManager em;

	@PersistenceUnit
	EntityManagerFactory emf;

	public void createRequest(String name, int quantity) {
		Customer customer = findCustomerByName(name);
		Request req = new Request();
		req.setQuantity(quantity);
		req.setCustomer(customer);

		em.persist(req);

	}

	public void createCustomer(String name, String address, String email,
			String phone) {
		try {

			Customer customer = new Customer();
			customer.setName(name);
			customer.setAddress(address);
			customer.setEmail(email);
			customer.setPhoneNumber(phone);

			em.persist(customer);
			System.out.println("created customer" + customer);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();

		}
	}

	public List<Customer> findAllCustomers() {
		Query query = em.createQuery("FROM Customer");
		List<Customer> customerList = query.getResultList();
		return customerList;
	}

	public List<Request> findAllRequests() {
		Query query = em.createQuery("FROM Request");
		List<Request> customerOrders = query.getResultList();
		return customerOrders;
	}

	public Customer findCustomerByName(String name) {
		Query query = em
				.createQuery("SELECT c FROM Customer c WHERE c.name = :name");
		query.setParameter("name", name);
		Customer customer = (Customer) query.getSingleResult();
		return customer;
	}

	public List<Request> findAllRequestsByCustomer(String name) {
		Query query = em
				.createQuery("SELECT r FROM Request r WHERE customer.name = :name");
		query.setParameter("name", name);
		List<Request> customerOrders = query.getResultList();
		return customerOrders;
	}
}
