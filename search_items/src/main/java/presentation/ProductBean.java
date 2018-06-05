package presentation;

import java.io.Serializable;

import javax.enterprise.context.SessionScoped;
import javax.faces.context.FacesContext;
import javax.inject.Inject;
import javax.inject.Named;
import javax.servlet.http.HttpSession;

import business.SearchManager;
import model.Customer;
import model.Product;
@SessionScoped
@Named(value="productBean")
public class ProductBean implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	SearchManager sm= SearchManager.getInstance();
	private Product product=new Product();
	@Inject
	private Customer customers;
	

	public ProductBean() {
	}
	
	

	public ProductBean(Product product, Customer customers) {
		this.product = product;
		this.customers = customers;
	}



	public Customer getCustomers() {
		return customers;
	}



	public void setCustomers(Customer customers) {
		this.customers = customers;
	}



	public ProductBean(Product product) {
		this.product = product;
	}

	public Product getProduct() {
		return product;
	}

	public void setProduct(Product product) {
		this.product = product;
	}
	
	public void saveProduct() {
		SearchManager.getInstance().saveProduct(product);
		System.out.println("Product Saved");
	
		
	}
	
	public String doLogout() {
		FacesContext facesContext = FacesContext.getCurrentInstance();
		HttpSession httpSession = (HttpSession) facesContext.getExternalContext().getSession(false);
		httpSession.invalidate();
		return "productGui?faces-redirect=true";
	}


}
