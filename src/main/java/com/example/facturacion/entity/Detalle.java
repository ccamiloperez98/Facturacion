package com.example.facturacion.entity;


import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.ForeignKey;
import javax.persistence.Id;
import javax.persistence.IdClass;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;


@Entity
@Table(name = "detalle")
@IdClass(FacturaDetallePK.class)
public class Detalle {
	
	 @Id
	 private Integer idDetalle;
	
	 @Id
	 private Factura factura;	
	 
	 @ManyToOne
	 @JsonProperty(access = JsonProperty.Access.WRITE_ONLY)
	 @JoinColumn(name = "id_producto", nullable = false, foreignKey = @ForeignKey(name = "FK_Producto_Factura"))	
	 private Producto idProducto;
	 
	 
	 @Column(name="cantidad", nullable = false, length = 60)
	 private Integer cantidad;
	 
	 @Column(name="precio", nullable = false, length = 60)
	 private Integer precio;

	public Integer getIdDetalle() {
		return idDetalle;
	}

	public void setIdDetalle(Integer idDetalle) {
		this.idDetalle = idDetalle;
	}

	@JsonIgnore
	public Factura getFactura() {
		return factura;
	}

	public void setFactura(Factura factura) {
		this.factura = factura;
	}

	public Producto getIdProducto() {
		return idProducto;
	}

	public void setIdProducto(Producto idProducto) {
		this.idProducto = idProducto;
	}

	public Integer getCantidad() {
		return cantidad;
	}

	public void setCantidad(Integer cantidad) {
		this.cantidad = cantidad;
	}

	public Integer getPrecio() {
		return precio;
	}

	public void setPrecio(Integer precio) {
		this.precio = precio;
	}
}
