package com.omada.pithia.service;

import com.omada.pithia.domain.xrhstes.Kathigitis;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import java.util.List;

@Repository(value = "kathigitisService")
@org.springframework.stereotype.Service
@Transactional
public class KathigitisService implements Service<Kathigitis,String> {

	@PersistenceContext
	private EntityManager entityManager;

	@Override
	public void save(Kathigitis kathigitis) {
		entityManager.persist(kathigitis);
	}

	@Override
	@Transactional(readOnly = true)
	public Kathigitis find(String onomaXrhsthKathigiti) {
		return entityManager.find(Kathigitis.class,onomaXrhsthKathigiti);
	}

	@Override
	public void delete(Kathigitis kathigitis) {
		entityManager.remove(kathigitis);
	}

	@Override
	@Transactional(readOnly = true)
	public List<Kathigitis> findAll() {
		TypedQuery<Kathigitis> find_all_kathigites = entityManager
				.createQuery("SELECT k FROM Kathigitis k", Kathigitis.class);
		return find_all_kathigites
				.getResultList();
	}

	@Override
	public Kathigitis update(Kathigitis kathigitis) {
		return entityManager.merge(kathigitis);
	}
}
