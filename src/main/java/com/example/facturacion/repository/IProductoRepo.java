package com.example.facturacion.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.facturacion.entity.Producto;

@Repository
public interface IProductoRepo extends JpaRepository<Producto, Integer> {

}
