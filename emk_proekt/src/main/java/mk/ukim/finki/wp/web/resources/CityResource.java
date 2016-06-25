package mk.ukim.finki.wp.web.resources;

import mk.ukim.finki.wp.model.City;
import mk.ukim.finki.wp.service.CityService;
import mk.ukim.finki.wp.web.CrudResource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/data/rest/cities")
public class CityResource extends
		CrudResource<City, CityService> {

	@Autowired
	private CityService service;

	@Override
	public CityService getService() {
		return service;
	}

}
