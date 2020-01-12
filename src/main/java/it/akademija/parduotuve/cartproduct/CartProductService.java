package it.akademija.parduotuve.cartproduct;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class CartProductService {
	private CartProductRepository cartProductRepository;

	@Autowired
	public CartProductService(CartProductRepository cartProductRepository) {
		this.cartProductRepository = cartProductRepository;
	}

	@Transactional(readOnly = true)
	public List<CartProduct> getCartProducts() {
		return cartProductRepository.findAll();
	}

	@Transactional
	public void createCartProduct(CartProduct cartProduct) {
		cartProductRepository.save(cartProduct);
	}

	@Transactional
	public void deleteCartProduct(Long id) {
		cartProductRepository.deleteById(id);
	}
}
