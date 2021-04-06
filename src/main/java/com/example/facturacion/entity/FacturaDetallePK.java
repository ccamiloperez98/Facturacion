package com.example.facturacion.entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;


@Embeddable
public class FacturaDetallePK implements Serializable {

	private static final long serialVersionUID = 1L;
	
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="num_detalle")
	private Integer idDetalle;
	
	@ManyToOne
    @JoinColumn(name = "id_factura", nullable = false)
	private Factura factura;

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((factura == null) ? 0 : factura.hashCode());
		result = prime * result + ((idDetalle == null) ? 0 : idDetalle.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		FacturaDetallePK other = (FacturaDetallePK) obj;
		if (factura == null) {
			if (other.factura != null)
				return false;
		} else if (!factura.equals(other.factura))
			return false;
		if (idDetalle == null) {
			if (other.idDetalle != null)
				return false;
		} else if (!idDetalle.equals(other.idDetalle))
			return false;
		return true;
	}
}
