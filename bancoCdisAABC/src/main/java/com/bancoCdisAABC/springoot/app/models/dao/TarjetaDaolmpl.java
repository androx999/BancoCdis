package com.bancoCdisAABC.springoot.app.models.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.bancoCdisAABC.springoot.app.models.entity.Tarjeta;

@Repository
public class TarjetaDaolmpl implements ITarjetaDao{
	
	@PersistenceContext
	private EntityManager em; 
	
	@SuppressWarnings("unchecked")
	@Transactional(readOnly = true)//Con esta anotacion se marca este metodo como Transactional, con el el valor unico de lectura
	@Override
	public List<Tarjeta> findAll() {
		return em.createQuery("from Tarjeta").getResultList();
	}

	@Override
	@Transactional(readOnly = true)
	public void save(Tarjeta tarjeta) {
		if(tarjeta.getId()!=null && tarjeta.getId() > 0) {
			em.merge(tarjeta);
		} else {
			em.persist(tarjeta);
		}
	}

	@Override
	@Transactional(readOnly = true)
	public Tarjeta findOne(Long id) {
		return em.find(Tarjeta.class, id);
	}

	@Override
	public void delete(Long id) {
		em.remove(findOne(id));
		
	}

}
