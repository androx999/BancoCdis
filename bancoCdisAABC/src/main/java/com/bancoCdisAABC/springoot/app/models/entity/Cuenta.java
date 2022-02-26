package com.bancoCdisAABC.springoot.app.models.entity;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

@Entity
@Table(name = "cuentas")
public class Cuenta implements Serializable {

	private static final long serialVersionUID = 2990602998676380780L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@Column
	@NotEmpty
	private String nombre;

	@Column
	@NotNull
	private double saldo;

	@Column(name = "numero_telefono")
	private String numeroTelefono;

	@Column(name = "dia_creacion")
	// @Temporal(TemporalType.DATE)
	// @DateTimeFormat(pattern = "yyyy-MM-dd")
	private Date diaCreacion;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}


	public String getNombre() {
		return nombre;
	}

	
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	
	public double getSaldo() {
		return saldo;
	}

	
	public void setSaldo(double saldo) {
		this.saldo = saldo;
	}

	
	public String getNumeroTelefono() {
		return numeroTelefono;
	}


	public void setNumeroTelefono(String numeroTelefono) {
		this.numeroTelefono = numeroTelefono;
	}

	
	public Date getDiaCreacion() {
		return diaCreacion;
	}


	public void setDiaCreacion(Date diaCreacion) {
		this.diaCreacion = diaCreacion;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

}
