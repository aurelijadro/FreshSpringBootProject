package services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import it.akademija.parduotuve.dao.ProductDAO;
import it.akademija.parduotuve.model.Product;

@Service
public class ProductService {
	@Autowired
	@Qualifier("repoProductDao")
	private ProductDAO productDAO;

	@Transactional(readOnly = true)
	public List<Product> getProducts() {
		return productDAO.getProducts();
	}

	@Transactional
	public void createProduct(Product product) {
		productDAO.createProduct(product);
	}

	@Transactional
	public void deleteProduct(String title) {
		productDAO.deleteProduct(title);
	}
}
