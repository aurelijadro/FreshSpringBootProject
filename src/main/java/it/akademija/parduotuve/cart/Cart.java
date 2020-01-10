package it.akademija.parduotuve.cart;

import java.util.Map;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
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

	public User getUser() {
		return user;
	}
}
