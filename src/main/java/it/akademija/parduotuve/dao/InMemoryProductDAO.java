package it.akademija.parduotuve.dao;

import java.util.Collections;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;

import org.springframework.stereotype.Repository;
import it.akademija.parduotuve.model.Product;

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
	public void deleteProduct(String title) {
		for (Product product : products) {
			if (title.equals(product.getTitle())) {
				products.remove(product);
				break;
			}

		}

	}
}
