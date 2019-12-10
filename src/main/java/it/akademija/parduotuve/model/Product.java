package it.akademija.parduotuve.model;

import java.math.BigDecimal;

public final class Product {
	private String title;
	private String image;
	private String description;
	private BigDecimal price;
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

}
