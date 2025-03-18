package com.example.demo.modelo;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

import jakarta.persistence.Table;


@Entity
@Table(name="producto")
public class productos {

	@Id
	@GeneratedValue(strategy =GenerationType.SEQUENCE)
	private Long idP;
	
	@Column(name ="valorU",length = 50 ,nullable=false)
	private Float valor;

	@Column(name ="nombre",length = 50 ,nullable=false)
	private String nombre;
	


	public productos() {
		super();
	}

	public productos(Long idP, Float valor, String nombre, Long cantidad) {
		super();
		this.idP = idP;
		this.valor = valor;
		this.nombre = nombre;

	}

	public Long getIdP() {
		return idP;
	}

	public void setIdP(Long idP) {
		this.idP = idP;
	}

	public Float getValor() {
		return valor;
	}

	public void setValor(Float valor) {
		this.valor = valor;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}


	
	

}
