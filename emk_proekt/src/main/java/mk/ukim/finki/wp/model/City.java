package mk.ukim.finki.wp.model;

import javax.persistence.Entity;
import javax.persistence.Table;

import org.hibernate.search.annotations.Analyze;
import org.hibernate.search.annotations.Field;
import org.hibernate.search.annotations.Index;
import org.hibernate.search.annotations.Indexed;
import org.hibernate.search.annotations.Store;

@Entity
@Table(name = "cities")
@Indexed
public class City extends BaseEntity {

	@Field(index=Index.YES, analyze=Analyze.YES, store=Store.NO)
	private String name;

	private String country = "Македонија";

	public String getCountry() {
		return country;
	}

	public void setCountry(String country) {
		this.country = country;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

}
