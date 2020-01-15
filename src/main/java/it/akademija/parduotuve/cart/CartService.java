package it.akademija.parduotuve.cart;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import it.akademija.parduotuve.cart.Cart;
import it.akademija.parduotuve.cart.CartRepository;
import it.akademija.parduotuve.product.Product;
import it.akademija.parduotuve.product.ProductRepository;

@Service
public class CartService {

	@Autowired
	private ProductRepository productsRepository;

	@Autowired
	private CartRepository cartRepository;

//	@Transactional
//	public int getCartProductCountByProductId(Long productId) {
//		List<Cart> carts = cartRepository.findAll();
//		List<Product> cartProducts = new ArrayList<Product>();
//		carts.stream().map(cart -> cart.getProducts().stream().map(product -> cartProducts.add(product)));
//		List<Product> productsInCartsById = cartProducts.stream().filter(product -> product.getId().equals(productId))
//				.collect(Collectors.toList());
//		// return productsInCartsById.size();
//		return cartProducts.size();
//		;
//	}

	@Transactional
	public List<Product> getCartProducts(String username) {
		Cart cart = cartRepository.findByUsernameIgnoreCase(username);
		if (cart != null) {
			return cart.getProducts();
		} else {
			return new ArrayList<Product>();
		}
	}

	@Transactional
	public void addProduct(Product product, String username) {
		Cart cart = cartRepository.findByUsernameIgnoreCase(username);

		if (cart == null) {
			cart = new Cart(username);
		}

		if (product != null) {
			cart.addProduct(product);
			productsRepository.save(product);
		}
	}

	@Transactional
	public void deleteProduct(String username, Long productId) {
		Cart cart = cartRepository.findByUsernameIgnoreCase(username);
		Product product = productsRepository.findById(productId).get();

		cart.getProducts().remove(product);
		product.getCarts().remove(cart);

		cartRepository.save(cart);
		productsRepository.save(product);
	}

}
