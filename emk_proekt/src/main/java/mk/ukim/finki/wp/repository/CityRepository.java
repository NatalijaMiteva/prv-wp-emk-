package mk.ukim.finki.wp.repository;

import java.util.List;

import mk.ukim.finki.wp.model.City;

public interface CityRepository extends JpaSpecificationRepository<City>{

	public List<City> findByName(String name);

}
