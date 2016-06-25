package mk.ukim.finki.wp.service;

import mk.ukim.finki.wp.model.FavoriteItem;

import java.util.List;

public interface FavoriteItemService extends BaseEntityCrudService<FavoriteItem> {

  List<FavoriteItem> findByUserToken(String s);

  List<FavoriteItem> findByUserUsername(String username);

}
