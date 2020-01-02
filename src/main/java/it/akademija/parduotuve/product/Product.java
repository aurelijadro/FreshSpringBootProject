package it.akademija.parduotuve.product;

import java.math.BigDecimal;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Product {
	@Column
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	@Column
	private String title;
	@Column
	private String image;
	@Column
	private String description;
	@Column
	private BigDecimal price;
	@Column
	private Long quantity;

	public Product() {
	}

	public Product(String title, String image, String description, BigDecimal price, Long quantity) {
		this.title = title;
		this.image = image;
		this.description = description;
		this.price = price;
		this.quantity = quantity;
	}

	public String getTitle() {
		return title;
	}

	public String getImage() {
		return image;
	}

	public String getDescription() {
		return description;
	}

	public BigDecimal getPrice() {
		return price;
	}

	public Long getQuantity() {
		return quantity;
	}

	public Object getId() {
		return id;
	}

}
