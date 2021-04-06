package com.example.facturacion.repository;


import org.springframework.data.jpa.repository.JpaRepository;

import org.springframework.stereotype.Repository;

import com.example.facturacion.entity.Factura;

@Repository
public interface IFacturaRepo extends JpaRepository<Factura, Integer>{
	
}
