package it.akademija.parduotuve.product.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import it.akademija.parduotuve.product.Product;

public interface ProductRepository extends JpaRepository<Product, Long> {
	Product findByTitle(String title);

	List<Product> findProductsByTitleContaining(String partOfTitle);

	void deleteByTitle(String title);

	// List<Product>
	// findProductsByTitleContainingOrDescriptionContainingAllIgnoreCase(String
	// searchContent);
}
