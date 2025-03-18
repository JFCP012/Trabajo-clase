package com.example.demo.repositorio;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.demo.controlador.producto;
import com.example.demo.modelo.productos;



public interface productoRepositorio extends JpaRepository<productos,Long> {

}
