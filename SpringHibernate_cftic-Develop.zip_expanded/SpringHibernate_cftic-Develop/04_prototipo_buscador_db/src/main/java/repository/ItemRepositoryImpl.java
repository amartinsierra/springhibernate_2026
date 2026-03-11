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

	public Item findFirstByUrl(String tematica) {
		String jpql="select i from Item i where i.tematica=?1";
		TypedQuery<Item> query = eManager.createQuery(jpql, Item.class);
		query.setParameter(1, tematica);
		return query.getSingleResult();
	}

	public List<Item> findByTematica(String tematica) {
		String jpql="select i from Item i where i.tematica=?1";
		TypedQuery<Item> query = eManager.createQuery(jpql, Item.class);
		query.setParameter(1, tematica);
		return query.getResultList();
	}

	@Transactional
	public void save(Item item) {
		eManager.persist(item);
	}
	
}
