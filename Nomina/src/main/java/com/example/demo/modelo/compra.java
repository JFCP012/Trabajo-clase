package com.example.demo.modelo;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table(name="compra")
public class compra {

	/*REALIZAR UN SISTEMA DE FACTURACION PARA COMPRAS XS POR PRODUCTOS SE DEBE REGISTRAR 
	 * POR CADA PRODUCTO NOMBRE VALOR UNITARIO Y CANTIDAD AL IR INGRESANDO CADA PRODUCTO 
	 * SE DEBE IR MOSTRANDO LO INGRESADO Y EL TOTAL POR PRODUCTO AL FINALIZAR DE LA COMPRA
	 *  DEBE APARECER EL TOTAL A PAGAR 
	*/
	@Id
	@GeneratedValue(strategy =GenerationType.SEQUENCE)
	private Long idCompra;
	
	@ManyToOne()
	@JoinColumn(name="idP",referencedColumnName="idP")
	private productos productos;
	
	@Column(name ="cantidad",length = 50 ,nullable=false)
	private Long cantidad;

	public compra() {
		super();

	}

	public compra(Long idCompra,productos productos, Long cantidad) {
		super();
		this.idCompra = idCompra;
		this.productos = productos;
		this.cantidad = cantidad;
	}

	public Long getIdCompra() {
		return idCompra;
	}

	public void setIdCompra(Long idCompra) {
		this.idCompra = idCompra;
	}

	public productos getProductos() {
		return productos;
	}

	public void setProductos(productos productos) {
		this.productos = productos;
	}

	public Long getCantidad() {
		return cantidad;
	}

	public void setCantidad(Long cantidad) {
		this.cantidad = cantidad;
	}

}