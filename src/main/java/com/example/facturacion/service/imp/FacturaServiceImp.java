package com.example.facturacion.service.imp;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.facturacion.entity.Detalle;
import com.example.facturacion.entity.Factura;
import com.example.facturacion.entity.Producto;
import com.example.facturacion.exception.ModelNotFoundException;
import com.example.facturacion.repository.IDetalleRepo;
import com.example.facturacion.repository.IFacturaRepo;
import com.example.facturacion.repository.IProductoRepo;
import com.example.facturacion.service.IFacturaService;

@Service
public class FacturaServiceImp implements IFacturaService {
	
	@Autowired
	private IFacturaRepo repoFactura;
	
	@Autowired
	private IProductoRepo repoProducto;
	
	@Autowired
	private IDetalleRepo repoDetalle;

	@Override
	public List<Factura> listarFacturas() {
		List<Factura> listaFacturas= repoFactura.findAll();
		return listaFacturas;
	}

	@Override
	public void guardarFactura(Factura factura) {
		if(factura.getCliente()==null) throw new ModelNotFoundException("no ingreso cliente");
		if (factura.getDetalles()==null) throw new ModelNotFoundException("no ingreso detalles de la factura");
		Factura facturaAux=new Factura();
		facturaAux.setCliente(factura.getCliente());
		facturaAux.setFecha(factura.getFecha());
		facturaAux=repoFactura.save(facturaAux);
	
		
		for(Detalle detalle: factura.getDetalles() ) {
			Optional<Producto> prod= repoProducto.findById(detalle.getIdProducto().getIdProducto());
			if(prod==null) {throw new ModelNotFoundException("El producto ingresado no existe"); }else{
				repoDetalle.guardar(detalle.getCantidad(), detalle.getPrecio(),facturaAux.getIdFactura() ,
						detalle.getIdProducto().getIdProducto());
			};
	
		}
		
	}

}
