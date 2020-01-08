package it.akademija.parduotuve.cartproduct;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class CartProduct {
	@Column
	@Id
	private Long id;
	@Column
	private Long quantity;

	public CartProduct() {
	}

	public CartProduct(Long id, Long quantity) {
		this.id = id;
		this.quantity = quantity;

	}

	public void setId(Long id) {
		this.id = id;
	}

	public void setQuantity(Long quantity) {
		this.quantity = quantity;
	}

	public Long getId() {
		return id;
	}

	public Long getQuantity() {
		return quantity;
	}

}
