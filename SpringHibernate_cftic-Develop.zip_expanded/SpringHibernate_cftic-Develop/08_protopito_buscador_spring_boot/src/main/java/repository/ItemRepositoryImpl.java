package repository;

import java.util.List;

import org.springframework.stereotype.Repository;

import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.persistence.TypedQuery;
import jakarta.transaction.Transactional;
import model.Item;

@Repository
public class ItemRepositoryImpl implements ItemRepository{

	@PersistenceContext
	private EntityManager eManager;

	public List<Item> findByTematica(String tematica) {
		String jpql="select i from Item i where i.tematica=?1";
		TypedQuery<Item> query = eManager.createQuery(jpql, Item.class);
		query.setParameter(1, tematica);
		return query.getResultList().isEmpty() ? null : query.getResultList();
	}

	@Transactional
	public boolean save(Item item) {
		String jpql = "select i from Item i where i.url=?1 and i.tematica=?2";
		TypedQuery<Item> query = eManager.createQuery(jpql,Item.class);
		query.setParameter(1, item.getUrl());
		query.setParameter(2,item.getTematica());
		if(query.getResultList().isEmpty()) {
			eManager.persist(item);
			return true;
		}
		return false;
	}
	
}
