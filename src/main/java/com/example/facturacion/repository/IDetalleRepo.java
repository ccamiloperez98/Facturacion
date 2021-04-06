package com.example.facturacion.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.example.facturacion.entity.Detalle;

@Repository
public interface IDetalleRepo extends JpaRepository<Detalle, Integer> {

	@Transactional
	@Modifying
	@Query(value = "insert into detalle(cantidad, precio, id_factura,id_producto) " + 
			" values (:cantidad,:total,:idfactura,:idproducto)", nativeQuery = true)
	Integer guardar(@Param("cantidad") Integer cantidad, @Param("total") Integer total,
			@Param("idfactura") Integer idfactura,@Param("idproducto") Integer idproducto);	
	
}
