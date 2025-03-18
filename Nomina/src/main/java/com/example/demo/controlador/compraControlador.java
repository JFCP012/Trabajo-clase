package com.example.demo.controlador;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.modelo.Empleado;
import com.example.demo.modelo.compra;

import com.example.demo.repositorio.compraRepositorio;



@RestController
@RequestMapping("/ver/compra/")
@CrossOrigin(origins = "http://localhost:4200")
public class compraControlador {

    @Autowired 
    private compraRepositorio repositorio;
    
    @PostMapping("/guardar")
    public compra guardar(@RequestBody compra nuevaCompra) { 
        return repositorio.save(nuevaCompra);
    }
    
    @GetMapping ("/compras")
	public List<compra> verCompra(){
		return repositorio.findAll();
	}
	
	
	
	 @GetMapping ("/total")
	 public void total(){
		 List<compra> adm = this.repositorio.findAll();
		 for(int i=0;i<adm.size();i++) {
			Long cantidad= adm.get(i).getCantidad();
			Float valor=adm.get(i).getProductos().getValor();
			Float Total=cantidad*valor;
		 }
		 
	 }
	 
	 
    
}

