package presentation;

import java.io.Serializable;

import javax.enterprise.context.SessionScoped;
import javax.inject.Inject;
import javax.inject.Named;

import business.SearchManager;
import model.Customer;
import model.Product;
@SessionScoped
@Named(value="customerBean")
public class CustomerBean implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	
	private Customer customer= new Customer();
	@Inject
	Product cusProduct;
	
	
	public CustomerBean() {
	}
	
	
	public CustomerBean(Customer customer, Product cusProduct) {
		this.customer = customer;
		this.cusProduct = cusProduct;
	}


	public Customer getCustomer() {
		return customer;
	}
	public Product getCusProduct() {
		return cusProduct;
	}
	public void setCustomer(Customer customer) {
		this.customer = customer;
	}
	public void setCusProduct(Product cusProduct) {
		this.cusProduct = cusProduct;
	}
	
	public void saveCustomer() {
		
		SearchManager.getInstance().saveCustomer(customer);
		System.out.println("Customer saved");
		
	}

}
