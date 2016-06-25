package mk.ukim.finki.wp.service;

import mk.ukim.finki.wp.model.Company;
import mk.ukim.finki.wp.model.Person;

public interface CompanyService  extends BaseEntityCrudService<Company>{

	Person findByOwnerEmbg(String embg);
	
}
