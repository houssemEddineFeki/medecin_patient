package com.example.demo.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.transaction.Transactional;

import org.springframework.stereotype.Repository;

import com.example.demo.entities.Medecin;

@Repository
public class MedecinDAO implements IMedecinDAO {
	@PersistenceContext
	private EntityManager em;

	@Transactional
	public void addMedecin(Medecin obj) {
		em.persist(obj);

	}

	@Transactional
	public void deleteMedecin(Long id) {
		em.remove(em.find(Medecin.class, id));

	}

	@Transactional
	public void updateMedecin(Medecin obj) {
		em.merge(obj);

	}

	@Transactional
	public Medecin findMedecinByID(Long id) {

		return em.find(Medecin.class, id);
	}

	@Transactional
	public List<Medecin> findAll() {
		Query req = em.createQuery("select m from Medecin m");
		return req.getResultList();
	}

}
