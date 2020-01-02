package it.akademija.parduotuve.product.dao;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import it.akademija.parduotuve.product.Product;

public interface ProductDAO {
	List<Product> getProducts();

	void createProduct(Product product);

	void deleteProduct(Long id);

}
