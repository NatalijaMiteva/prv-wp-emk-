package mk.ukim.finki.wp.service.impl;

import java.util.List;

import mk.ukim.finki.wp.model.City;
import mk.ukim.finki.wp.repository.CityRepository;
import mk.ukim.finki.wp.service.CityService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CityServiceImpl extends
BaseEntityCrudServiceImpl<City, CityRepository> implements
CityService {

    @Autowired
    private CityRepository repository;

	@Override
	public List<City> findByName(String name) {
		return repository.findByName(name);
	}

	@Override
	protected CityRepository getRepository() {
		return repository;
	}

    

}
