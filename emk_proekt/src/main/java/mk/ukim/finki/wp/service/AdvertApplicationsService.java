package mk.ukim.finki.wp.service;

import mk.ukim.finki.wp.model.AdvertApplications;
import mk.ukim.finki.wp.model.OrderItem;

import java.util.List;

public interface AdvertApplicationsService extends BaseEntityCrudService<AdvertApplications> {

  public List<AdvertApplications> findByOwnerUsername(String s);

  public List<AdvertApplications> findAllByAdvertId(Long id);

  public  List<AdvertApplications> findAllByOwnerId(Long id);

}
