package com.omada.pithia.service;

import com.omada.pithia.domain.xrhstes.Foititis;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;

@Repository("foititisService")
@org.springframework.stereotype.Service
@Transactional
public class FoititisService implements Service<Foititis,String> {

	@PersistenceContext
	private EntityManager entityManager;

	@Override
	public void save(Foititis foititis) {
		entityManager.persist(foititis);
	}

	@Override
	@Transactional(readOnly = true)
	public Foititis find(String onomaXrhsthFoititi) {
		return entityManager.find(Foititis.class,onomaXrhsthFoititi);
	}

	@Override
	public void delete(Foititis foititis) {
		entityManager.remove(foititis);
	}

	@Override
	@Transactional(readOnly = true)
	public List<Foititis> findAll() {
		return entityManager
				.createQuery("SELECT f FROM Foititis f",Foititis.class)
				.getResultList();
	}

	@Override
	public Foititis update(Foititis foititis) {
		return entityManager.merge(foititis);
	}
}
