package mk.ukim.finki.wp.repository;

import mk.ukim.finki.wp.model.AdvertApplications;
import mk.ukim.finki.wp.model.OrderItem;

import java.util.List;

public interface AdvertApplicationsRepository extends JpaSpecificationRepository<AdvertApplications> {

  List<AdvertApplications> findByOwnerUsername(String s);

  List<AdvertApplications> findAllByAdvertId(Long id);

  List<AdvertApplications> findAllByOwnerId(Long id);

}
