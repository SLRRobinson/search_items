package model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

@Entity
public class Customer implements Serializable {

	/****/

	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long customerID;
	private String name;
	@OneToMany(cascade = CascadeType.ALL, mappedBy = "customer", orphanRemoval = true,targetEntity=Product.class)
	private List<Product> cusProduct = new ArrayList<>();
	
	public void addProduct(Product product) {
        this.cusProduct.add(product);
        if (product.getCustomer() != this) {
        	product.setCustomer(this);
        }
    }

	

	public Customer() {
	}

	public Customer(Long cusID, String name) {
		this.customerID = cusID;
		this.name = name;
	}

	public Long getCusID() {
		return customerID;
	}

	public String getName() {
		return name;
	}

	public void setCusID(Long cusID) {
		this.customerID = cusID;
	}

	
	

	public List<Product> getCusProduct() {
		return cusProduct;
	}

	public void setCusProduct(List<Product> cusProduct) {
		this.cusProduct = cusProduct;
	}

	public void setName(String name) {
		this.name = name;
	}

}

/*
 * https://vladmihalcea.com/the-best-way-to-map-a-onetomany-association-with-jpa
 * -and-hibernate/
 */