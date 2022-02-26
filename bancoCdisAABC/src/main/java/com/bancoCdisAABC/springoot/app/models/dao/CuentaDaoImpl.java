package com.bancoCdisAABC.springoot.app.models.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.bancoCdisAABC.springoot.app.models.entity.Cuenta;
import com.bancoCdisAABC.springoot.app.models.entity.Tarjeta;

@Repository
public class CuentaDaoImpl implements ICuentaDao {

	@PersistenceContext
	private EntityManager em;
	
	@SuppressWarnings("unchecked")
	@Transactional(readOnly = true)
	@Override
	public List<Cuenta> findAll() {
		return em.createQuery("from Cuenta").getResultList();
	}

	@Override
	@Transactional
	public void save(Cuenta cuenta) {
		if(cuenta.getId()!= null && cuenta.getId() > 0) {
			em.merge(cuenta);
		}else {
		em.persist(cuenta);
	}

}

	@Override
	public Tarjeta findOne(Long id) {
	  return em.find(Tarjeta.class, id);
	}

	@Override
	public void delete(Long id) {
		em.remove(findOne(id));
		
	}
	
}
