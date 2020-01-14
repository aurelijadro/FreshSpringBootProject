package it.akademija.parduotuve.cart;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;

import it.akademija.parduotuve.product.Product;

@Entity
public class Cart {
	@Column
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;

	private String username;

	@ManyToMany(mappedBy = "carts", cascade = { CascadeType.MERGE, CascadeType.DETACH }, fetch = FetchType.EAGER)
	private List<Product> products = new ArrayList<Product>();

	public Cart() {
	};

	public Cart(String username) {
		this.username = username;
	}

	public List<Product> getProducts() {
		return this.products;
	}

	public void addProduct(Product product) {
		this.products.add(product);
		product.addCart(this);
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getUsername() {
		return this.username;
	}
}
