package com.example.demo.modelo;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name="empleado")
public class Empleado {

@Id
@Column(name="identificacion")
private long identificacion;

@Column(name ="nombre",length = 50 ,nullable=false)
private String nombre;

@Column(name ="apellidos",length = 80 ,nullable=false)
private String apellidos;

@Column(name ="email",length = 100 ,nullable=false,unique=true)
private String email;

public Empleado() {
	
}



public Empleado(long identificacion, String nombre, String apellidos, String email) {
	super();
	this.identificacion = identificacion;
	this.nombre = nombre;
	this.apellidos = apellidos;
	this.email = email;
}

public long getIdentificacion() {
	return identificacion;
}

public void setIdentificacion(long identificacion) {
	this.identificacion = identificacion;
}

public String getNombre() {
	return nombre;
}

public void setNombre(String nombre) {
	this.nombre = nombre;
}

public String getApellidos() {
	return apellidos;
}

public void setApellidos(String apellidos) {
	this.apellidos = apellidos;
}

public String getEmail() {
	return email;
}

public void setEmail(String email) {
	this.email = email;
}


}
