package business;

import java.util.ArrayList;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import model.Customer;
import model.Product;

public class SearchManager {
	static EntityManagerFactory emf;
	static EntityManager em;
	static SearchManager instance;
Customer customer;
Product product;
ArrayList<Product>cusProducts=new ArrayList<>();

	

	SearchManager() {
		emf = Persistence.createEntityManagerFactory("search");
		em = emf.createEntityManager();
	}
	
	public static SearchManager getInstance() {
		if (instance == null) {
			instance = new SearchManager();
		}
		return instance;
	}

	public void saveCustomer(Customer cus) {
		em.getTransaction().begin();
		em.persist(cus);
		System.out.println("Customer saved");
		em.getTransaction().commit();
		em.close();
		
		
		
		
	}
	
	public void saveProduct(Product cusProduct) {
		em.getTransaction().begin();
		cusProduct.setCustomer(customer);
		em.persist(cusProduct);
		System.out.println("Product saved");
		em.getTransaction().commit();
		em.close();
		
	}

	

	

}