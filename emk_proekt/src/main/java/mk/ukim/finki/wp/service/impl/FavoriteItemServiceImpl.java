package mk.ukim.finki.wp.service.impl;

import mk.ukim.finki.wp.model.FavoriteItem;
import mk.ukim.finki.wp.repository.FavoriteItemRepository;
import mk.ukim.finki.wp.service.FavoriteItemService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class FavoriteItemServiceImpl extends
        BaseEntityCrudServiceImpl<FavoriteItem, FavoriteItemRepository> implements
        FavoriteItemService {

    @Autowired
    private FavoriteItemRepository repository;

    @Override
    protected FavoriteItemRepository getRepository() {
        return repository;
    }

    @Override
    public List<FavoriteItem> findByUserToken(String s) {
        return getRepository().findByUserToken(s);
    }

    @Override
    public List<FavoriteItem> findByUserUsername(String username) {
        return getRepository().findByUserUsername(username);
    }


}
