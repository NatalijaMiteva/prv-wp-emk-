package mk.ukim.finki.wp.repository;

import java.util.List;

import mk.ukim.finki.wp.model.OrderItem;

public interface OrderItemRepository extends JpaSpecificationRepository<OrderItem> {

  List<OrderItem> findByUserToken(String s);

  List<OrderItem> findByUserUsername(String username);

}
