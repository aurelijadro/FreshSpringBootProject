package it.akademija.parduotuve.cart;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import it.akademija.parduotuve.cart.Cart;
import it.akademija.parduotuve.cart.CartRepository;

@Service
public class CartService {
	private CartRepository cartRepository;

	@Autowired
	public CartService(CartRepository cartRepository) {
		this.cartRepository = cartRepository;
	}

	@Transactional(readOnly = true)
	public Cart getCartByUserId(Long id) {
		return null;
	}

	@Transactional
	public void createCart(Cart cart) {
//		cartRepository.save(cart);
	}

}
