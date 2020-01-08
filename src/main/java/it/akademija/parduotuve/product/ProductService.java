package it.akademija.parduotuve.product;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import it.akademija.parduotuve.product.Product;

@Service
public class ProductService {

	private ProductRepository productRepository;

	@Autowired
	public ProductService(ProductRepository productRepository) {
		this.productRepository = productRepository;
	}

	@Transactional(readOnly = true)
	public List<Product> getProducts() {
		return productRepository.findAll();
	}

	@Transactional
	public void createProduct(Product product) {
		productRepository.save(product);
	}

	@Transactional
	public void deleteProduct(Long id) {
		productRepository.deleteById(id);
	}

	@Transactional
	public List<Product> getSomething(String whatever) {
		return productRepository.findProductsByTitleContaining(whatever);
	}

}
