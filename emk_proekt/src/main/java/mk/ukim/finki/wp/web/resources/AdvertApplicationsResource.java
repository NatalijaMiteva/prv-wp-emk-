package mk.ukim.finki.wp.web.resources;

import mk.ukim.finki.wp.model.Advert;
import mk.ukim.finki.wp.model.AdvertApplications;
import mk.ukim.finki.wp.model.OrderItem;
import mk.ukim.finki.wp.model.User;
import mk.ukim.finki.wp.service.AdvertApplicationsService;
import mk.ukim.finki.wp.service.AdvertService;
import mk.ukim.finki.wp.service.OrderItemService;
import mk.ukim.finki.wp.service.UserService;
import mk.ukim.finki.wp.web.CrudResource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.PathVariable;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.LinkedList;
import java.util.List;

@RestController
@RequestMapping("/data/rest/advert")
public class AdvertApplicationsResource extends
        CrudResource<AdvertApplications, AdvertApplicationsService> {

  @Autowired
  private AdvertApplicationsService service;

  @Autowired
  private UserService userService;

  @Autowired
  private AdvertService advertService;

  @Override
  public AdvertApplicationsService getService() {
    return service;
  }

  @RequestMapping( value="/apply", method=RequestMethod.POST, produces = "application/json")
  public AdvertApplications create(@RequestBody AdvertApplications entity, HttpServletRequest request,
                          HttpServletResponse response) {

    User user = userService.findByUsername(entity.getUser().getUsername());
    entity.setUser(user);

    User owner = userService.findByUsername(entity.getOwner().getUsername());
    entity.setOwner(owner);

    Advert advert = advertService.findById(entity.getAdvert().getId());
    entity.setAdvert(advert);

    getService().save(entity);
    return entity;
  }

  @RequestMapping(value = "/apply/details/{id}", method = RequestMethod.GET, produces = "application/json")
  public List<User> getUserList(@PathVariable Long id, HttpServletRequest request,
               HttpServletResponse response) {
    List<AdvertApplications> list = getService().findAllByAdvertId(id);
    List<User> users = new LinkedList<User>();
    for(AdvertApplications advert : list) {
      User u = userService.findByUsername(advert.getUser().getUsername());
      users.add(u);
    }
    return users;
  }

  @RequestMapping(value = "/apply/adverts/{id}", method = RequestMethod.GET, produces = "application/json")
  public List<Advert> getAdvertList(@PathVariable Long id, HttpServletRequest request,
                                HttpServletResponse response) {
    List<AdvertApplications> list = getService().findAllByOwnerId(id);
    List<Advert> adverts = new LinkedList<Advert>();
    for(AdvertApplications advert : list) {
      Advert a = advertService.findById(advert.getAdvert().getId());
      if(!adverts.contains(a)) {
        adverts.add(a);
      }
    }
    return adverts;
  }

}
