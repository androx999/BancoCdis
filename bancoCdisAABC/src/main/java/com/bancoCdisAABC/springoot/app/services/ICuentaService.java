package com.bancoCdisAABC.springoot.app.services;

import java.util.List;

import com.bancoCdisAABC.springoot.app.models.entity.Cuenta;

public interface ICuentaService {

	public Cuenta getById(Long id, List<Cuenta> lista);
	
}
