package mk.ukim.finki.wp.web.resources;

import mk.ukim.finki.wp.model.Person;
import mk.ukim.finki.wp.service.PersonService;
import mk.ukim.finki.wp.web.CrudResource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/data/rest/persons")
public class PersonResource extends CrudResource<Person, PersonService> {

	@Autowired
	private PersonService service;

	@Override
	public PersonService getService() {
		return service;
	}

}
