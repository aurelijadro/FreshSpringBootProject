package it.akademija.parduotuve.product;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductRepository extends JpaRepository<Product, Long> {
	Product findByTitle(String title);

	List<Product> findProductsByTitleContaining(String partOfTitle);

	void deleteByTitle(String title);

	// List<Product>
	// findProductsByTitleContainingOrDescriptionContainingAllIgnoreCase(String
	// searchContent);
}
