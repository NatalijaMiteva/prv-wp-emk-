package mk.ukim.finki.wp.model;

import javax.persistence.Entity;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

/**
 * Created by riste_000 on 4/15/2015.
 */
@Entity
@Table(name = "emk_order_items")
public class OrderItem extends BaseEntity {

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
}
