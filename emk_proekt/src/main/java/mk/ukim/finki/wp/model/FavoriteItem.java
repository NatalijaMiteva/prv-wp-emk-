package mk.ukim.finki.wp.model;

import javax.persistence.Entity;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

/**
 * Created by riste_000 on 4/15/2015.
 */
@Entity
@Table(name = "emk_favorite_items")
public class FavoriteItem extends BaseEntity {

  @ManyToOne
  private Advert advert;

  @ManyToOne
  private User user;

  private String userToken;

  private boolean inCart;

  public Advert getAdvert() {
    return advert;
  }

  public void setAdvert(Advert advert) {
    this.advert = advert;
  }

  public User getUser() {
    return user;
  }

  public void setUser(User user) {
    this.user = user;
  }

  public String getUserToken() {
    return userToken;
  }

  public void setUserToken(String userToken) {
    this.userToken = userToken;
  }

  public boolean isInCart() {
    return inCart;
  }

  public void setInCart(boolean inCart) {
    this.inCart = inCart;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) return true;
    if (o == null || getClass() != o.getClass()) return false;
    if (!super.equals(o)) return false;

    FavoriteItem that = (FavoriteItem) o;

    if (advert != null ? !advert.equals(that.advert) : that.advert != null) return false;
    return userToken != null ? userToken.equals(that.userToken) : that.userToken == null;

  }

  @Override
  public int hashCode() {
    int result = super.hashCode();
    result = 31 * result + (advert != null ? advert.hashCode() : 0);
    result = 31 * result + (userToken != null ? userToken.hashCode() : 0);
    return result;
  }
}
