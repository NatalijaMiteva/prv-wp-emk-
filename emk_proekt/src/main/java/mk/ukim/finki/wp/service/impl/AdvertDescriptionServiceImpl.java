package mk.ukim.finki.wp.service.impl;

import mk.ukim.finki.wp.model.AdvertDiscription;
import mk.ukim.finki.wp.repository.AdvertDescriptionRepository;
import mk.ukim.finki.wp.service.AdvertDescriptionService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AdvertDescriptionServiceImpl extends
BaseEntityCrudServiceImpl<AdvertDiscription, AdvertDescriptionRepository> implements
AdvertDescriptionService {

	@Autowired
	private AdvertDescriptionRepository repository;

	@Override
	protected AdvertDescriptionRepository getRepository() {
		return repository;
	}


		

}
