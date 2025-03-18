package com.example.demo.repositorio;

import java.util.Date;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.demo.modelo.Empleado;
import com.example.demo.modelo.Nomina_Empleado;

public interface NominaRepositorio extends JpaRepository<Nomina_Empleado,Long> {

	public List<Nomina_Empleado> findBysalario(Float salario);
	public List<Nomina_Empleado> findBydeducidos(Float deducidos);
	public List<Nomina_Empleado> findByingresos(Float ingresos);
	public List<Nomina_Empleado> findBytotalsalario(Float totalSalario);
	public List<Nomina_Empleado> findByfecha(Date fecha);
	public List<Nomina_Empleado> findByEmpleado(Empleado id);
	

}
