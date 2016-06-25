package mk.ukim.finki.wp.model;

import javax.persistence.Entity;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "emk_advert_applications")
public class AdvertApplications extends BaseEntity {

  @ManyToOne
  private Advert advert;

  @ManyToOne
  private User user;

  @ManyToOne
  private User owner;

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

  public User getOwner() {
    return owner;
  }

  public void setOwner(User owner) {
    this.owner = owner;
  }
}
