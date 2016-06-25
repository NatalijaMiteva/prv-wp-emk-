package mk.ukim.finki.wp.web.resources;

import mk.ukim.finki.wp.model.Company;
import mk.ukim.finki.wp.service.CompanyService;
import mk.ukim.finki.wp.web.CrudResource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/data/rest/companies")
public class CompanyResource extends
		CrudResource<Company, CompanyService> {

	@Autowired
	private CompanyService service;

	@Override
	public CompanyService getService() {
		return service;
	}

}
