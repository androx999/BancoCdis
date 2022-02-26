package com.bancoCdisAABC.springoot.app.models.dao;

import java.util.List;

import com.bancoCdisAABC.springoot.app.models.entity.Tarjeta;


public interface ITarjetaDao {

	public List<Tarjeta> findAll();
	
	public void save(Tarjeta tarjeta);
	
	public Tarjeta findOne(Long id);
	public List<Tarjeta> findByCuentaId(String term);
	
	public void delete(Long id);
}
