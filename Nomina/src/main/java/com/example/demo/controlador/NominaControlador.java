package com.example.demo.controlador;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.time.temporal.ChronoUnit;
import java.util.Date;
import java.util.LinkedList;
import java.util.List;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.modelo.Empleado;
import com.example.demo.modelo.Nomina_Empleado;
import com.example.demo.repositorio.EmpleadoRepositorio;
import com.example.demo.repositorio.NominaRepositorio;

@RestController
@RequestMapping("/ver/nomina/")
@CrossOrigin(origins = "http://localhost:4200/")

public class NominaControlador {

	 @Autowired
	    private NominaRepositorio nominaRepositorio; 

	    @Autowired
	    private EmpleadoRepositorio empleadoRepositorio;
	
	    /*@GetMapping ("/guardar")
	public List<Nomina_Empleado> GuardarN(){
		Empleado empleado=this.empleadoRepositorio.findById((long)1114).orElse(null);
		if(empleado!=null) {
			Nomina_Empleado e = new Nomina_Empleado((float)10.000,(float)10.000,(float)10.000,(float)10.000,"02/12/2005",empleado);
			this.nominaRepositorio.save(e);
		}else {
            System.out.println("⚠️ Empleado con ID 1114 no encontrado.");
        }
		return nominaRepositorio.findAll();
	}*/
	@GetMapping ("/guardar")
	public List<Nomina_Empleado> GuardarN(
		@RequestParam Long id,
		@RequestParam Float salario,
		@RequestParam String fecha
		)throws ParseException{
		SimpleDateFormat sdf= new SimpleDateFormat("MM/dd/yyyy");
		Date fechas =sdf.parse(fecha);
		Empleado empleado=this.empleadoRepositorio.findById(id).orElse(null);
		if(empleado!=null) {
			Float deducidos=calculardeducidos(salario);
			Float ingresos=calcularbonificacion(salario);
			Float totalsalario=salario+ingresos-deducidos;
		Nomina_Empleado e = new Nomina_Empleado(empleado,salario,deducidos,ingresos,totalsalario,fechas);
		this.nominaRepositorio.save(e);
	}else {
	return null;
	}
		return this.nominaRepositorio.findByEmpleado(empleado);
		}
	
	private Float calculardeducidos(Float salario ) {
	    float descuentos = salario * 0.10f;
	    return descuentos;
	}
	
	private Float calcularbonificacion(Float salario ){
		float minimo=1400000;
		float bonificacion=0;
		if(salario<2* minimo) {
			 bonificacion = salario * 0.10f;
		}
		return bonificacion ;
	
	}
	@GetMapping("/parafiscalesU")
	public List<Object> parafiscalesU(){
		List<Object> nombre = new LinkedList <>();		
		float icbf=0;float sena=0;float cajaCompensacion=0;String Empleado;
	List<Nomina_Empleado> s =this.nominaRepositorio.findAll();
	for(int i=0;i<s.size();i++) {
		Empleado=s.get(i).getEmpleado().getNombre();
		 icbf =s.get(i).getSalario() * 0.03f;
		sena = s.get(i).getSalario() * 0.02f;
	   cajaCompensacion=s.get(i).getSalario()*0.04f;
	   nombre.add("\n");
	   nombre.add("Empleado: "+Empleado);
	   nombre.add("ICBF: "+icbf);
	   nombre.add("Sena: "+sena);
	   nombre.add("Caja de compensaciones: "+cajaCompensacion);
	   nombre.add("\n");
	}
	return nombre;
		}
	
	@GetMapping("/parafiscales")
	public List<Object> parafiscales(){
		List<Object> nombre = new LinkedList <>();		
		float parafiscales=0;
	List<Nomina_Empleado> s =this.nominaRepositorio.findAll();
	for(int i=0;i<s.size();i++) {
		 parafiscales =s.get(i).getSalario() * 0.09f;
		 nombre.add("\n");
	   nombre.add("Parafiscales totales por empleado: "+parafiscales);
	   nombre.add("\n");
	   
	}
	return nombre;
		}
	
	
	@GetMapping("/cesantias")
	public List<Object> cesantias() {
	    List<Object> em = new LinkedList<>();
	    List<Nomina_Empleado> e = this.nominaRepositorio.findAll();
	    Date hoy = new Date(); // Fecha actual

	    for (int i = 0; i < e.size(); i++) {
	        float salario = e.get(i).getSalario();
	        Date fechaIngreso =new Date( e.get(i).getFecha().getTime());
	        String Empleado = e.get(i).getEmpleado().getNombre();

	        long diferenciaDias = ChronoUnit.DAYS.between(
	            fechaIngreso.toInstant(), hoy.toInstant()
	        );

	        float cesantias = (salario * diferenciaDias) / 360;
	        float intereses = (cesantias * 0.12f * diferenciaDias) / 360;
	        float total = cesantias + intereses;
	        em.add("\n");
	        em.add("Empleado: " + Empleado);
	        em.add("Salario: " + salario);
	        em.add("Intereses: " + intereses);
	        em.add("Total: " + total);
	        em.add("\n");
	    }
	    return em;
	}

	@GetMapping ("/buscar")
	public List<Nomina_Empleado>BuscarN(){
		 this.nominaRepositorio.findById((long)2);
		 return this.nominaRepositorio.findAll();
		
	}
	@GetMapping ("/buscarT")
	public List<Nomina_Empleado>BuscarT(){
		 return this.nominaRepositorio.findAll();
		
	}
			
	
	
	@GetMapping ("/buscarSa")
	public List<Nomina_Empleado> BuscarSa(){
		this.nominaRepositorio.findBysalario((float)10.000);
		return this.nominaRepositorio.findAll();
		
	}
@GetMapping ("/buscarDed")
	public List<Nomina_Empleado> BuscarDe(){
		return this.nominaRepositorio.findBydeducidos((float)10.000);
		
	}
	@GetMapping ("/buscarIn")
	public List<Nomina_Empleado> BuscarIn(){
		return this.nominaRepositorio.findByingresos((float)10.000);
		
	}
	@GetMapping ("/buscarSaT")
	public List<Nomina_Empleado> BuscarSaT(){
		this.nominaRepositorio.findBytotalsalario((float)10.000);
		return this.nominaRepositorio.findAll();
		
	}
	
	@GetMapping("/fecha")
	public List<Nomina_Empleado> Buscarfecha(
	@RequestParam String fecha
	)throws ParseException{
	SimpleDateFormat sdf= new SimpleDateFormat("MM/dd/yyyy");
	Date fechas =sdf.parse(fecha);
	return	this.nominaRepositorio.findByfecha(fechas);
		
	}
	
	@GetMapping ("/mostrar")
	public List<Nomina_Empleado>MostrarN(){
		 return this.nominaRepositorio.findAll();
		
	}
	
	@GetMapping ("/eliminar")
	public List<Nomina_Empleado>EliminarN(){
		 this.nominaRepositorio.deleteById((long)1);
		 return this.nominaRepositorio.findAll();
	}	
	
	@GetMapping ("/actualizar")
	public List<Nomina_Empleado>ActualizarN(){
		Nomina_Empleado e=this.nominaRepositorio.findById((long)2).get();
    		e.setSalario(2000000f);
    		this.nominaRepositorio.save(e);
	return nominaRepositorio.findAll();
		
	}
	
	
		
	}
	