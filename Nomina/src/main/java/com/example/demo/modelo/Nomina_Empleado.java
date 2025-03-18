package com.example.demo.modelo;

import java.util.Date;

import org.springframework.format.annotation.DateTimeFormat;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import jakarta.persistence.Temporal;
import jakarta.persistence.TemporalType;

@Entity
@Table(name="Nomina_Emp")

public class Nomina_Empleado {

@Id
@GeneratedValue(strategy =GenerationType.SEQUENCE)
private Long id_nomina;

@ManyToOne()
@JoinColumn(name="identificacionE",referencedColumnName="identificacion")
private Empleado empleado;

@Column(name= "salario", length = 80,nullable=false)
private Float salario; 

@Column(name= "deducidos", length = 80,nullable=false)
private Float deducidos; 

@Column(name= "ingresos", length = 80,nullable=false)
private Float ingresos; 

@Column(name= "totalsalario",length =80,nullable=false)
private Float totalsalario; 

@Temporal(TemporalType.DATE)
//@DateTimeFormat(iso=ISO.DATE)
@DateTimeFormat(pattern ="MM/dd/yyyy")
@Column(name= "fecha", length = 20,nullable=false)
private Date fecha;



public Nomina_Empleado() {
	super();
}



public Nomina_Empleado( Empleado empleado, Float salario, Float deducidos, Float ingresos,
		Float totalsalario, Date fecha) {
	super();
	this.empleado = empleado;
	this.salario = salario;
	this.deducidos = deducidos;
	this.ingresos = ingresos;
	this.totalsalario = totalsalario;
	this.fecha = fecha;
}



public Long getId_nomina() {
	return id_nomina;
}



public void setId_nomina(Long id_nomina) {
	this.id_nomina = id_nomina;
}



public Empleado getEmpleado() {
	return empleado;
}



public void setEmpleado(Empleado empleado) {
	this.empleado = empleado;
}



public Float getSalario() {
	return salario;
}



public void setSalario(Float salario) {
	this.salario = salario;
}



public Float getDeducidos() {
	return deducidos;
}



public void setDeducidos(Float deducidos) {
	this.deducidos = deducidos;
}



public Float getIngresos() {
	return ingresos;
}



public void setIngresos(Float ingresos) {
	this.ingresos = ingresos;
}



public Float getTotalsalario() {
	return totalsalario;
}



public void setTotalsalario(Float totalsalario) {
	this.totalsalario = totalsalario;
}



public Date getFecha() {
	return fecha;
}



public void setFecha(Date fecha) {
	this.fecha = fecha;
}






}
