package mk.ukim.finki.wp.model;


import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import org.apache.lucene.analysis.charfilter.HTMLStripCharFilterFactory;
import org.apache.lucene.analysis.core.LowerCaseFilterFactory;
import org.apache.lucene.analysis.standard.StandardTokenizerFactory;
import org.hibernate.search.annotations.Analyze;
import org.hibernate.search.annotations.AnalyzerDef;
import org.hibernate.search.annotations.CharFilterDef;
import org.hibernate.search.annotations.Field;
import org.hibernate.search.annotations.Index;
import org.hibernate.search.annotations.Indexed;
import org.hibernate.search.annotations.IndexedEmbedded;
import org.hibernate.search.annotations.Store;
import org.hibernate.search.annotations.TokenFilterDef;
import org.hibernate.search.annotations.TokenizerDef;

@Entity
@Table(name = "adverts")
@Indexed
@AnalyzerDef(name = "customAnalyser",
        charFilters = {
                @CharFilterDef(factory = HTMLStripCharFilterFactory.class)
        },
        tokenizer = @TokenizerDef(factory = StandardTokenizerFactory.class),
        filters = {
                @TokenFilterDef(factory = LowerCaseFilterFactory.class)
        })
public class Advert extends BaseEntity {

	@Field(index=Index.YES, analyze=Analyze.YES, store=Store.NO)
	private String advertName;

	@ManyToOne
	@IndexedEmbedded
	private AdvertDiscription advertDescription;
	
	@ManyToOne
	@IndexedEmbedded
    private Category category;

	//treba da se smene order
//	@ManyToMany(mappedBy = "adverts")
//	private List<Order> orders;
	
	@ManyToOne
	@IndexedEmbedded
	private City city;
	
	@ManyToOne
	private User owner;

	private Date publishingDate;
	
	private Date endingDate;

	public String getAdvertName() {
		return advertName;
	}

	public void setAdvertName(String advertName) {
		this.advertName = advertName;
	}

	public AdvertDiscription getAdvertDescription() {
		return advertDescription;
	}

	public void setAdvertDescription(AdvertDiscription advertDescription) {
		this.advertDescription = advertDescription;
	}

	public Category getCategory() {
		return category;
	}

	public void setCategory(Category category) {
		this.category = category;
	}

	public City getCity() {
		return city;
	}

	public void setCity(City city) {
		this.city = city;
	}

	public Date getPublishingDate() {
		return publishingDate;
	}

	public void setPublishingDate(Date publishingDate) {
		this.publishingDate = publishingDate;
	}

	public Date getEndingDate() {
		return endingDate;
	}

	public void setEndingDate(Date endingDate) {
		this.endingDate = endingDate;
	}

	public User getOwner() {
		return owner;
	}

	public void setOwner(User owner) {
		this.owner = owner;
	}
}
