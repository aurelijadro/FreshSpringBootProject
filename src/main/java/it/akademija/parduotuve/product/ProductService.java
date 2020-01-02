package it.akademija.parduotuve.product;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import it.akademija.parduotuve.product.dao.ProductDAO;
import it.akademija.parduotuve.product.Product;
import it.akademija.parduotuve.product.dao.ProductRepository;

@Service
public class ProductService {
	@Autowired
	@Qualifier("repoProductDao")
	private ProductDAO productDAO;

	@Autowired
	private ProductRepository productRepository;

	@Transactional(readOnly = true)
	public List<Product> getProducts() {
		return productDAO.getProducts();
	}

	@Transactional
	public void createProduct(Product product) {
		productDAO.createProduct(product);
	}

	@Transactional
	public void deleteProduct(Long id) {
		productDAO.deleteProduct(id);
	}

	@Transactional
	public List<Product> getSomething(String whatever) {
		return productRepository.findProductsByTitleContaining(whatever);
	}

}
