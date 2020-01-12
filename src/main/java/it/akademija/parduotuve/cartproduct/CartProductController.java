package it.akademija.parduotuve.cartproduct;

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

@RestController
@Api(value = "cart product")
@RequestMapping(value = "/api/cartproducts")
public class CartProductController {

	private CartProductService cartProductService;

	@Autowired
	public CartProductController(CartProductService cartProductService) {
		this.cartProductService = cartProductService;
	}

	@RequestMapping(method = RequestMethod.GET)
	@ApiOperation(value = "Get cart products", notes = "Returns all cart products")
	public List<CartProduct> getCartProducts() {
		return cartProductService.getCartProducts();
	}

	@RequestMapping(method = RequestMethod.POST)
	@ResponseStatus(HttpStatus.CREATED)
	@ApiOperation(value = "Create cart product", notes = "Creates new cart product")
	public void createCartProduct(
			@ApiParam(value = "Cart Product Data", required = true) @Valid @RequestBody final CreateCartPoductCommand cmd) {
//		cartProductService.createCartProduct(
//				new CartProduct(cmd.getTitle(), cmd.getImage(), cmd.getDescription(), cmd.getPrice(), cmd.getQuantity()));
	}

	@RequestMapping(path = "/{id}", method = RequestMethod.DELETE)
	@ResponseStatus(HttpStatus.NO_CONTENT)
	@ApiOperation(value = "Delete product", notes = "deletes product by id")
	public void deleteProduct(@ApiParam(value = "Product id", required = true) @PathVariable final String id) {
		cartProductService.deleteCartProduct(Long.parseLong(id));
	}
}
