package mk.ukim.finki.wp.service.impl;

import java.util.List;

import mk.ukim.finki.wp.model.OrderItem;
import mk.ukim.finki.wp.repository.OrderItemRepository;
import mk.ukim.finki.wp.service.OrderItemService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class OrderItemServiceImpl extends
        BaseEntityCrudServiceImpl<OrderItem, OrderItemRepository> implements
        OrderItemService {

    @Autowired
    private OrderItemRepository repository;

    @Override
    protected OrderItemRepository getRepository() {
        return repository;
    }

    @Override
    public List<OrderItem> findByUserToken(String s) {
        return getRepository().findByUserToken(s);
    }

    @Override
    public List<OrderItem> findByUserUsername(String username) {
        return getRepository().findByUserUsername(username);
    }


}
