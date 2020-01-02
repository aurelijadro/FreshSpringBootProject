package it.akademija.parduotuve.product.dao;

import java.util.Collections;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;

import org.springframework.stereotype.Repository;

import it.akademija.parduotuve.product.Product;

@Repository
public class InMemoryProductDAO implements ProductDAO {
	private final List<Product> products = new CopyOnWriteArrayList<>();

	@Override
	public List<Product> getProducts() {
		return Collections.unmodifiableList(products);
	}

	@Override
	public void createProduct(Product product) {
		products.add(product);

	}

	@Override
	public void deleteProduct(Long id) {
		for (Product product : products) {
			if (id.equals(product.getId())) {
				products.remove(product);
				break;
			}

		}

	}
}
