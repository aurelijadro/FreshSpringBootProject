package it.akademija.parduotuve.user;

import java.util.List;

import javax.validation.Valid;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import it.akademija.parduotuve.user.dao.UserDAO;
import it.akademija.parduotuve.user.User;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.HttpStatus;

@RestController
@Api(value = "user")
@RequestMapping(value = "/api/users")
public class UserController {

	@Autowired
	@Qualifier("userDao")
	private UserDAO userDao;

	@Autowired
	public UserController(UserDAO userDao) {
		this.userDao = userDao;
	}

	@RequestMapping(method = RequestMethod.GET)
	@ApiOperation(value = "Get users", notes = "Returns registered users")
	public List<User> getUsers() {
		return userDao.getUsers(); // skaitome per DAO
	}

	@RequestMapping(method = RequestMethod.POST)
	@ResponseStatus(HttpStatus.CREATED)
	@ApiOperation(value = "Create user", notes = "Creates user with data")
	public void createUser(
			@ApiParam(value = "User Data", required = true) @Valid @RequestBody final CreateUserCommand cmd) {
		userDao.createUser(new User(cmd.getUsername(), cmd.getFirstName(), cmd.getLastName(), cmd.getEmail()));
	}

	@RequestMapping(path = "/{username}", method = RequestMethod.DELETE)
	@ResponseStatus(HttpStatus.NO_CONTENT)
	public void deleteUser(@PathVariable final String username) {
		userDao.deleteUser(username);
	}

}
