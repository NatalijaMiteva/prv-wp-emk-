package mk.ukim.finki.wp.repository;

import mk.ukim.finki.wp.model.FavoriteItem;

import java.util.List;

public interface FavoriteItemRepository extends JpaSpecificationRepository<FavoriteItem> {

  List<FavoriteItem> findByUserToken(String s);

  List<FavoriteItem> findByUserUsername(String username);

}
