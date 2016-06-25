package mk.ukim.finki.wp.service.impl;

import mk.ukim.finki.wp.model.Company;
import mk.ukim.finki.wp.model.Person;
import mk.ukim.finki.wp.repository.CompanyRepository;
import mk.ukim.finki.wp.service.CompanyService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CompanyServiceImpl extends
BaseEntityCrudServiceImpl<Company, CompanyRepository> implements
CompanyService {

	@Autowired
	private CompanyRepository repository;

	@Override
	public Person findByOwnerEmbg(String embg) {
		return repository.findByOwnerEmbg(embg);
	}

	@Override
	protected CompanyRepository getRepository() {
		return repository;
	}

}
