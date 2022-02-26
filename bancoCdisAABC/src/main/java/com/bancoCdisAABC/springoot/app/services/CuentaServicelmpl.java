package com.bancoCdisAABC.springoot.app.services;

import java.util.List;

import org.springframework.stereotype.Service;

import com.bancoCdisAABC.springoot.app.models.entity.Cuenta;

@Service
public class CuentaServicelmpl implements ICuentaService {

	private List<Cuenta> lista;
	
	public CuentaServicelmpl() {
		
	}
	@Override
	public Cuenta getById(Long id, List<Cuenta> lista) {
		this.lista = lista;
		Cuenta cuentaResult = null;
		
		for(Cuenta cuenta : this.lista) {
			if(id == cuenta.getId()) {
				cuentaResult = cuenta;
				break;
			}
		}
		return cuentaResult;
	}

}
