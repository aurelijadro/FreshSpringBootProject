package it.akademija.parduotuve.product;

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
import it.akademija.parduotuve.PagingData;
import it.akademija.parduotuve.product.Product;
import it.akademija.parduotuve.product.ProductService;

@RestController
@Api(value = "product")
@RequestMapping(value = "/api/products")
public class ProductController {

	private ProductService productService;

	@Autowired
	public PagingData pagingData;

	@Autowired
	public ProductController(ProductService productService) {
		this.productService = productService;
	}

	@RequestMapping(method = RequestMethod.GET)
	@ApiOperation(value = "Get products", notes = "Returns all products in store")
	public List<Product> getProducts() {
		pagingData.setLimit(10);
		return productService.getProducts();
	}

	@RequestMapping(method = RequestMethod.POST)
	@ResponseStatus(HttpStatus.CREATED)
	@ApiOperation(value = "Create product", notes = "Creates new product with data")
	public void createProduct(
			@ApiParam(value = "Product Data", required = true) @Valid @RequestBody final CreateProductCommand cmd) {
		productService.createProduct(
				new Product(cmd.getTitle(), cmd.getImage(), cmd.getDescription(), cmd.getPrice(), cmd.getQuantity()));
	}

	@RequestMapping(path = "/{id}", method = RequestMethod.DELETE)
	@ResponseStatus(HttpStatus.NO_CONTENT)
	@ApiOperation(value = "Delete product", notes = "deletes product by id")
	public void deleteProduct(@ApiParam(value = "Product id", required = true) @PathVariable final String id) {
		productService.deleteProduct(Long.parseLong(id));
	}

}
