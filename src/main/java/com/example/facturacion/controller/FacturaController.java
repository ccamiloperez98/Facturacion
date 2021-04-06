package com.example.facturacion.controller;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.example.facturacion.entity.Factura;
import com.example.facturacion.service.IFacturaService;


@RestController
@RequestMapping("/api/facturas")
public class FacturaController {
	
	@Autowired
	private IFacturaService service;
	
	
	@GetMapping(path = "/listar")
	public ResponseEntity<List<Factura>> listar() {
		List<Factura> facturas = service.listarFacturas();
		System.out.print("prueba");
		return new ResponseEntity<List<Factura>>(facturas, HttpStatus.OK);
	}
	
	@PostMapping(path = "/guardar")
	public ResponseEntity<Factura> guardar(@RequestBody Factura factura) {
		service.guardarFactura(factura);
		return new ResponseEntity<Factura>(HttpStatus.CREATED);
	}
	

}
