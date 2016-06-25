package mk.ukim.finki.wp.web.resources;

import java.io.IOException;
import java.util.List;
import java.util.UUID;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.validation.Valid;

import mk.ukim.finki.wp.model.User;
import mk.ukim.finki.wp.security.TokenTransfer;
import mk.ukim.finki.wp.security.TokenUtils;
import mk.ukim.finki.wp.security.UserTransfer;
import mk.ukim.finki.wp.service.UserService;
import mk.ukim.finki.wp.web.CrudResource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/data/rest")
public class UserResource extends CrudResource<User, UserService> {

	private static final int TOKEN_DURATION = 30 * 24 * 60 * 60; // 30 days

	@Autowired
	private UserDetailsService userService;

	@Autowired
	@Qualifier("authenticationManager")
	private AuthenticationManager authManager;

	@Autowired
	private UserService service;

	/**
	 * Authenticates a user and creates an authentication token.
	 *
	 * @param username
	 *            The name of the user.
	 * @param password
	 *            The password of the user.
	 * @return A transfer containing the authentication token.
	 */
	@RequestMapping(value = "/user/authenticate", method = RequestMethod.POST, produces = "application/json")
	@ResponseBody
	public TokenTransfer authenticate(
			@RequestParam("username") String username,
			@RequestParam("password") String password,
			@RequestParam("rememberMe") boolean rememberMe,
			HttpServletRequest request, HttpServletResponse response) {

		System.out.println(username);
		System.out.println(password);
		UsernamePasswordAuthenticationToken authenticationToken = new UsernamePasswordAuthenticationToken(
				username, password);
		Authentication authentication = this.authManager
				.authenticate(authenticationToken);
		SecurityContextHolder.getContext().setAuthentication(authentication);

		/*
		 * Reload user as password of authentication principal will be null
		 * after authorization and password is needed for token generation
		 */
		UserDetails userDetails = this.userService.loadUserByUsername(username);
		Cookie cookie = new Cookie("token", TokenUtils.createToken(userDetails));
		if (rememberMe) {
			cookie.setMaxAge(TOKEN_DURATION);
		}
		cookie.setPath(request.getContextPath());
		response.addCookie(cookie);
		return new TokenTransfer(TokenUtils.createToken(userDetails));
	}

	@RequestMapping(value = "/token", method = RequestMethod.GET, produces = "application/json")
	@ResponseBody
	public void authenticate(HttpServletRequest request,
			HttpServletResponse response) {
		Cookie[] cookies = request.getCookies();
		for (Cookie c : cookies) {
			if (c.getName().equals("temp_token")) {
				c.setMaxAge(TOKEN_DURATION);
				c.setPath(request.getContextPath());
				response.addCookie(c);
				System.out.println("Found cookie");
				return;
			}
		}
		Cookie cookie = new Cookie("temp_token", UUID.randomUUID().toString());
		cookie.setMaxAge(TOKEN_DURATION);
		cookie.setPath(request.getContextPath());
		response.addCookie(cookie);
	}

	@RequestMapping(value = "/user", method = RequestMethod.GET, produces = "application/json")
	@ResponseBody
	public UserTransfer getUser(HttpServletRequest request,
			HttpServletResponse response) throws IOException {
		Authentication authentication = SecurityContextHolder.getContext()
				.getAuthentication();
		Object principal = authentication.getPrincipal();
		if (principal instanceof String
				&& ((String) principal).equals("anonymousUser")) {
			response.sendError(HttpServletResponse.SC_UNAUTHORIZED);
		}
		if (principal instanceof UserDetails) {

			UserDetails userDetails = (UserDetails) principal;
			User user = service.findByUsername(userDetails.getUsername());
			return new UserTransfer(user.getUsername(), user.getRole()
					.toString());
		}
		return null;
	}

	@Override
	public UserService getService() {
		return service;
	}

	@RequestMapping(value = "/users/register", method = RequestMethod.POST, produces = "application/json")
	public User create(@RequestBody @Valid User entity,
			HttpServletRequest request, HttpServletResponse response) {

		getService().save(entity);
		return entity;
	}

	@RequestMapping(value = "/users/register", method = RequestMethod.GET, produces = "application/json")
	public List<User> getAll() {
		return getService().findAll();
	}

	@RequestMapping(value = "/users/register/{id}", method = RequestMethod.GET, produces = "application/json")
	public User get(@PathVariable Long id, HttpServletRequest request,
			HttpServletResponse response) {
		User entity = getService().findOne(id);
		if (entity == null) {
			response.setStatus(HttpServletResponse.SC_NOT_FOUND);
		}
		return entity;
	}

	@RequestMapping(value = "/users/register/{id}", method = RequestMethod.DELETE, produces = "application/json")
	public void delete(@PathVariable Long id, HttpServletRequest request,
			HttpServletResponse response) {
		getService().delete(id);
	}

	@RequestMapping(value = "/users/by/{username}", method = RequestMethod.GET, produces = "application/json")
	public User getByUsername(@PathVariable String username, HttpServletRequest request,
					HttpServletResponse response) {
		User entity = getService().findByUsername(username);
		if (entity == null) {
			response.setStatus(HttpServletResponse.SC_NOT_FOUND);
		}
		return entity;
	}

}
