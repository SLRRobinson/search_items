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
	private Long cusID;
	private String name;
	@OneToMany(cascade = CascadeType.ALL, mappedBy = "customer", orphanRemoval = true)
	private List<Product> cusProduct = new ArrayList<>();

	

	public Customer() {
	}

	public Customer(Long cusID, String name) {
		this.cusID = cusID;
		this.name = name;
	}

	public Long getCusID() {
		return cusID;
	}

	public String getName() {
		return name;
	}

	public void setCusID(Long cusID) {
		this.cusID = cusID;
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