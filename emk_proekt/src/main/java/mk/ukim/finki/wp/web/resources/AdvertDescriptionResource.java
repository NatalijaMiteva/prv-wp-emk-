package mk.ukim.finki.wp.web.resources;

import mk.ukim.finki.wp.model.AdvertDiscription;
import mk.ukim.finki.wp.service.AdvertDescriptionService;
import mk.ukim.finki.wp.web.CrudResource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/data/rest/advertDescription")
public class AdvertDescriptionResource extends
		CrudResource<AdvertDiscription, AdvertDescriptionService> {

	@Autowired
	private AdvertDescriptionService service;

	@Override
	public AdvertDescriptionService getService() {
		return service;
	}
	
//	@RequestMapping(method = RequestMethod.POST, produces = "application/json")
//	public AdvertDiscription create(@RequestBody @Valid AdvertDiscription entity, HttpServletRequest request,
//			HttpServletResponse response) {
//		
//		System.out.println(entity);
//		System.out.println(entity.getTypeOfDeal());
//		getService().save(entity);
//		return entity;
//	}

}
