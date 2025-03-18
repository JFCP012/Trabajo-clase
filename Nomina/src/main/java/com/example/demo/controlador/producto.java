package com.example.demo.controlador;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.modelo.compra;
import com.example.demo.repositorio.compraRepositorio;

@RestController
@RequestMapping("/ver/producto")
@CrossOrigin(origins = "http://localhost:4200")


  
    

public class producto {

	  @Autowired 
	    private compraRepositorio repositorio;
	    
	 
}
