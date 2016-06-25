package mk.ukim.finki.wp.service;

import java.util.List;

import mk.ukim.finki.wp.model.Advert;

public interface AdvertService extends BaseEntityCrudService<Advert>{

	public List<Advert> findByCategoryId(Long id);
	
	public List search(String text);
	
	public Advert findById(Long id);

	public List<Advert> findByCityId(Long id);
}
