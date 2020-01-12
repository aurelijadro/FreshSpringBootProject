package it.akademija.parduotuve.cart;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import it.akademija.parduotuve.cartproduct.CartProduct;
import it.akademija.parduotuve.cartproduct.CartProductRepository;

@Service
public class CartService {
	private CartRepository cartRepository;

	@Autowired
	public CartService(CartRepository cartRepository) {
		this.cartRepository = cartRepository;
	}

	@Transactional(readOnly = true)
	public Cart getCartById(Long id) {
		return null;
	}

	@Transactional
	public void createCart(Cart cart) {
//		cartRepository.save(cart);
	}

}
