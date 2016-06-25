package mk.ukim.finki.wp.service;

import java.util.List;

import mk.ukim.finki.wp.model.OrderItem;

public interface OrderItemService extends BaseEntityCrudService<OrderItem> {

  List<OrderItem> findByUserToken(String s);

  List<OrderItem> findByUserUsername(String username);

}
