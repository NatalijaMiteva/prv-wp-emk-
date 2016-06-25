package mk.ukim.finki.wp.repository;


import java.util.List;

import mk.ukim.finki.wp.model.Advert;

public interface AdvertRepository extends JpaSpecificationRepository<Advert> {

	List<Advert> findByCategoryId(Long id);
	Advert findById(Long id);
	List<Advert> findByCityId(Long id);
}
