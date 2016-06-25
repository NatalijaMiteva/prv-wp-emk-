package mk.ukim.finki.wp.service.impl;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;

import mk.ukim.finki.wp.model.Advert;
import mk.ukim.finki.wp.repository.AdvertRepository;
import mk.ukim.finki.wp.service.AdvertService;

import org.hibernate.search.jpa.FullTextEntityManager;
import org.hibernate.search.jpa.Search;
import org.hibernate.search.query.dsl.QueryBuilder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AdvertServiceImpl extends
		BaseEntityCrudServiceImpl<Advert, AdvertRepository> implements
		AdvertService {

	@Autowired
	private AdvertRepository repository;

	@PersistenceContext
	private EntityManager em;

	@Override
	public List<Advert> findByCategoryId(Long id) {
		return repository.findByCategoryId(id);
	}

	@Override
	public List<Advert> findByCityId(Long id){ return  repository.findByCityId(id);}

	@Override
	protected AdvertRepository getRepository() {
		return repository;
	}

	@Transactional
	public List search(String text) {
		FullTextEntityManager fullTextEntityManager = Search
				.getFullTextEntityManager(em);

		QueryBuilder qb = fullTextEntityManager.getSearchFactory()
				.buildQueryBuilder().forEntity(Advert.class).get();

		org.apache.lucene.search.Query luceneQuery = qb
				.keyword()
				.onFields("advertName", "category.name", "city.name",
						"advertDescription.typeOfDeal",
						"advertDescription.optionalDescription").matching(text)
				.createQuery();

		// wrap Lucene query in a javax.persistence.Query
		javax.persistence.Query jpaQuery = fullTextEntityManager
				.createFullTextQuery(luceneQuery, Advert.class);

		// execute search
		return jpaQuery.getResultList();
	}

	@Override
	public Advert findById(Long id) {
		return repository.findById(id);
	}

}
