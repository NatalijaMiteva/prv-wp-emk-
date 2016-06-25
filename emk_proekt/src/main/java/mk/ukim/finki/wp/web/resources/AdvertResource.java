package mk.ukim.finki.wp.web.resources;

import java.beans.Expression;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.validation.Valid;

import mk.ukim.finki.wp.model.Advert;
import mk.ukim.finki.wp.model.AdvertDiscription;
import mk.ukim.finki.wp.model.FavoriteItem;
import mk.ukim.finki.wp.model.User;
import mk.ukim.finki.wp.service.AdvertDescriptionService;
import mk.ukim.finki.wp.service.AdvertService;
import mk.ukim.finki.wp.service.UserService;
import mk.ukim.finki.wp.specifications.BaseSpecification;
import mk.ukim.finki.wp.web.CrudResource;
import org.springframework.data.jpa.domain.Specification;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.data.jpa.domain.Specification;

@RestController
@RequestMapping("/data/rest/adverts")
public class AdvertResource extends CrudResource<Advert, AdvertService> {

	@Autowired
	private AdvertService service;

	@Autowired
	private UserService userService;

	@Autowired
	private AdvertDescriptionService descriptionService;

	@Override
	public AdvertService getService() {
		return service;
	}

	public AdvertDescriptionService getDescriptionService() {
		return descriptionService;
	}

	@RequestMapping(value = "/query", method = RequestMethod.GET, produces = "application/json")
	public List<Advert> getQueryData(@RequestParam(required = false) final String query) {
		System.out.println("QQUERY" + query);
		Specification<Advert> spec = new Specification<Advert>() {
			@Override
			public Predicate toPredicate(Root<Advert> root,
										 CriteriaQuery<?> criteriaQuery, CriteriaBuilder cb) {
				if (query != null) {
					System.out.println("NOT NULL");
					String actualQuery = "%" + query.toLowerCase() + "%";
					return cb.like(cb.lower(root.<String>get("city").<String>get("name")), actualQuery);
					//cb.like(teamName, actualQuery));
				} else {
					System.out.println("NULL");
					return null;
				}
			}
		};
		return new ArrayList<Advert>(getService().findAll(spec));
	}


	@RequestMapping(method = RequestMethod.POST, produces = "application/json")
	public Advert create(@RequestBody @Valid Advert entity,
			HttpServletRequest request, HttpServletResponse response) {

		AdvertDiscription ad = entity.getAdvertDescription();
		getDescriptionService().save(ad);

		User user = userService.findByUsername(entity.getOwner().getUsername());
		entity.setOwner(user);

		getService().save(entity);
		return entity;
	}

	@RequestMapping(value = "/by_city/{id}", method = RequestMethod.GET, produces = "application/json")
	@ResponseBody
	public List<Advert> getByCityId(@PathVariable Long id,
									HttpServletRequest request, HttpSession session) {
		return getService().findByCityId(id);
	}

	@RequestMapping(value = "/by_category/{id}", method = RequestMethod.GET, produces = "application/json")
	@ResponseBody
	public List<Advert> getByCategoryId(@PathVariable Long id,
			HttpServletRequest request, HttpSession session) {
		return getService().findByCategoryId(id);
	}

	@RequestMapping(value = "/details/{id}", method = RequestMethod.GET, produces = "application/json")
	@ResponseBody
	public Advert getAdvertDetails(@PathVariable Long id,
			HttpServletRequest request, HttpSession session) {
		return getService().findById(id);
	}

	@RequestMapping(value = "/search", method = RequestMethod.GET, produces = "application/json")
	public List search(@RequestParam String text) {
		return service.search(text);
	}
}
