package mk.ukim.finki.wp.service.impl;

import mk.ukim.finki.wp.model.AdvertApplications;
import mk.ukim.finki.wp.model.OrderItem;
import mk.ukim.finki.wp.repository.AdvertApplicationsRepository;
import mk.ukim.finki.wp.repository.OrderItemRepository;
import mk.ukim.finki.wp.service.AdvertApplicationsService;
import mk.ukim.finki.wp.service.OrderItemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AdvertApplicationsServiceImpl extends
        BaseEntityCrudServiceImpl<AdvertApplications, AdvertApplicationsRepository> implements
        AdvertApplicationsService {

  @Autowired
  private AdvertApplicationsRepository repository;

  @Override
  protected AdvertApplicationsRepository getRepository() {
    return repository;
  }

  @Override
  public List<AdvertApplications> findByOwnerUsername(String s) {
    return getRepository().findByOwnerUsername(s);
  }

  @Override
  public List<AdvertApplications> findAllByAdvertId(Long id) {
    return  getRepository().findAllByAdvertId(id);
  }

  @Override
  public List<AdvertApplications> findAllByOwnerId(Long id) { return  getRepository().findAllByOwnerId(id);
  }
}
