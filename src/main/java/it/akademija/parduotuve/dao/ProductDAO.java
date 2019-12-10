package it.akademija.parduotuve.dao;

import java.util.List;

import it.akademija.parduotuve.model.Product;

public interface ProductDAO {
	List<Product> getProducts();

	void createProduct(Product product);

	void deleteProduct(String title);

}
