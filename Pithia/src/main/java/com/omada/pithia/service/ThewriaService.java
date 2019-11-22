package com.omada.pithia.service;

import com.omada.pithia.domain.mathimata.Thewria;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;

@Repository("thewriaService")
@Transactional
@org.springframework.stereotype.Service
public class ThewriaService implements Service<Thewria,String> {

	@PersistenceContext
	private EntityManager entityManager;

	@Override
	public void save(Thewria thewria) {
		entityManager.persist(thewria);
	}

	@Override
	@Transactional(readOnly = true)
	public Thewria find(String onomaThewrias) {
		return entityManager.find(Thewria.class,onomaThewrias);
	}

	@Override
	public void delete(Thewria thewria) {
		entityManager.remove(thewria);
	}

	@Override
	@Transactional(readOnly = true)
	public List<Thewria> findAll() {
		return entityManager
				.createQuery("SELECT t FROM Thewria T",Thewria.class)
				.getResultList();
	}

	@Override
	public Thewria update(Thewria thewria) {
		return entityManager.merge(thewria);
	}
}
