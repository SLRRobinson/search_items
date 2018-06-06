package model;

import java.io.Serializable;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Entity
public class Product implements Serializable {

	/****/
	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long prodID;
	private String name, description, color;
	/*
	 * https://stackoverflow.com/questions/2584521/in-a-bidirectional-jpa-onetomany-
	 * manytoone-association-what-is-meant-by-the-in
	 */
	@ManyToOne(fetch = FetchType.EAGER,cascade = CascadeType.ALL, targetEntity=Customer.class)
	@JoinColumn(name = "customerID")
	private Customer customer;
	 
	

	public Product() {
	}

	public Product(Long prodID, String name, String description, String color, Customer customer) {
		this.prodID = prodID;
		this.name = name;
		this.description = description;
		this.color = color;
		this.customer = customer;
	}

	public String getName() {
		return name;
	}

	public String getDescription() {
		return description;
	}

	public String getColor() {
		return color;
	}

	public void setName(String name) {
		this.name = name;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public void setColor(String color) {
		this.color = color;
	}

	public Long getProdID() {
		return prodID;
	}

	public void setProdID(Long prodID) {
		this.prodID = prodID;
	}

	public Customer getCustomer() {
		return customer;
	}

	public void setCustomer(Customer customer) {
		this.customer = customer;
	}
	
	
	}

/*
 * https://vladmihalcea.com/the-best-way-to-map-a-onetomany-association-with-jpa
 * -and-hibernate/
 */
