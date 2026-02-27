package repository;

import java.util.List;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import model.Item;
@Repository
public class ItemsRepositoryImpl implements ItemsRepository {
	@PersistenceContext
	EntityManager eManager;
	@Transactional
	@Override
	public void save(Item item) {
		// TODO Auto-generated method stub
		eManager.persist(item);
	}

	@Override
	public List<Item> findByTematica(String tematica) {
		// pendiente...
		return null;
	}

	@Override
	public Item findFirstByUrl(String url) {
		// pendiente....
		return null;
	}

}
