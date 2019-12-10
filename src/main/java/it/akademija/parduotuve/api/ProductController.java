package it.akademija.parduotuve.api;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import it.akademija.parduotuve.dao.ProductDAO;
import it.akademija.parduotuve.model.CreateProductCommand;
import it.akademija.parduotuve.model.Product;

@RestController
@Api(value = "product")
@RequestMapping(value = "/api/products")
public class ProductController {

	private final ProductDAO productDAO;

	@Autowired
	public ProductController(ProductDAO productDAO) {
		this.productDAO = productDAO;
	}

	@RequestMapping(method = RequestMethod.GET)
	@ApiOperation(value = "Get products", notes = "Returns all products in store")
	public List<Product> getProducts() {
		return productDAO.getProducts();
	}

	@RequestMapping(method = RequestMethod.POST)
	@ResponseStatus(HttpStatus.CREATED)
	@ApiOperation(value = "Create product", notes = "Creates new product with data")
	public void createProduct(
			@ApiParam(value = "Product Data", required = true) @Valid @RequestBody final CreateProductCommand cmd) {
		productDAO.createProduct(
				new Product(cmd.getTitle(), cmd.getImage(), cmd.getDescription(), cmd.getPrice(), cmd.getQuantity()));
	}

	@RequestMapping(path = "/{title}", method = RequestMethod.DELETE)
	@ResponseStatus(HttpStatus.NO_CONTENT)
	@ApiOperation(value = "Delete product", notes = "deletes product by title")
	public void deleteProduct(@ApiParam(value = "Product title", required = true) @PathVariable final String title) {
		productDAO.deleteProduct(title);
	}

}
