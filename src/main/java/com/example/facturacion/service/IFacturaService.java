package com.example.facturacion.service;

import java.util.List;
import org.springframework.stereotype.Component;
import com.example.facturacion.entity.Factura;

@Component
public interface IFacturaService {

	public List<Factura> listarFacturas();
	
	public void guardarFactura(Factura factura);
}
