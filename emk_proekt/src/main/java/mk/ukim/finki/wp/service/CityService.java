package mk.ukim.finki.wp.service;

import java.util.List;

import mk.ukim.finki.wp.model.City;

public interface CityService  extends BaseEntityCrudService<City>{

	public List<City> findByName(String name);
	
}
