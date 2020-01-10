package it.akademija.parduotuve.cart;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;

import it.akademija.parduotuve.cartproduct.CartProduct;
import it.akademija.parduotuve.user.User;

@Entity
public class Cart {
	@Column
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	@OneToOne
	@JoinColumn(name = "user_id")
	private User user;

	@OneToMany(mappedBy = "cart")
	private Set<CartProduct> cartProducts = new HashSet();

	public void addProduct(CartProduct cartProduct) {
		this.cartProducts.add(cartProduct);
		cartProduct.setCart(this);
	}

	public User getUser() {
		return user;
	}
}
