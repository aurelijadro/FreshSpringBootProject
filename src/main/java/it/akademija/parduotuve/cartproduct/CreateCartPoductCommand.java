package it.akademija.parduotuve.cartproduct;

import javax.validation.constraints.NotNull;

import it.akademija.parduotuve.cart.Cart;
import it.akademija.parduotuve.product.Product;

public class CreateCartPoductCommand {

	@NotNull
	private Long quantity;

	@NotNull
	private Product product;

	@NotNull
	private Cart cart;

	public Long getQuantity() {
		return quantity;
	}

	public void setQuantity(Long quantity) {
		this.quantity = quantity;
	}

	public Product getProduct() {
		return product;
	}

	public void setProduct(Product product) {
		this.product = product;
	}

	public Cart getCart() {
		return cart;
	}

	public void setCart(Cart cart) {
		this.cart = cart;
	}

}
