package com.example.demo.controlador;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.modelo.Empleado;
import com.example.demo.modelo.Nomina_Empleado;
import com.example.demo.repositorio.EmpleadoRepositorio;
import com.example.demo.repositorio.NominaRepositorio;

@RestController
@RequestMapping("/ver/empleado/")
@CrossOrigin(origins = "http://localhost:4200/")
public class EmpleadoControlador {

	@Autowired
	private EmpleadoRepositorio repositorio;
	
	@Autowired
	private NominaRepositorio repositorioN;
	
	
	@GetMapping ("/empleados")
	public List<Empleado> verTodosEmpleados(){
		return repositorio.findAll();
		
	}
	
	@PostMapping ("/guardar")
	public Empleado GuardarE(
			@RequestBody Empleado e
			){		
		return this.repositorio.save(e);
	}
	
	@GetMapping ("/buscar")
	public Optional<Empleado> BuscarE(
			@RequestParam Long id){
		return this.repositorio.findById(id);
		
	}
	
	@GetMapping ("/buscar/{id}")
	public String verEmpleados(@PathVariable("id")Long idE){
		 Optional<Empleado> e=this.repositorio.findById(idE);
		 return e.get().getNombre()+" " + e.get().getApellidos();
			 
		 }
	
	@GetMapping ("/buscarEm")
	public Empleado BuscarEm(){
		return this.repositorio.findByEmail("jfcp12@gmail.com");
		
	}
	
	@GetMapping ("/buscarNom")
	public List<Empleado> BuscarNom(){
		return this.repositorio.findByNombre("Juan");
		
	}

	@GetMapping ("/buscarApell")
	public List<Empleado> BuscarApell(){
		return this.repositorio.findByApellidos("Prieto");
		
	}
	
	@GetMapping ("/eliminar")
	public List<Empleado>EliminarE(){
		 this.repositorio.deleteById((long)1114);
		 return this.repositorio.findAll();
		
	}
	@PostMapping ("/actualizar")
	public List<Empleado>ActualizarE(@RequestBody Empleado E){
    Empleado e=this.repositorio.findById((long)1112).get();
    		this.repositorio.save(e);
	return this.repositorio.findAll();
		
	}
	
	@GetMapping ("/buscarEmpleadosNomina")
	public List<Object> buscarNomina(){
		return this.repositorio.buscarNominaE(1112L);
	}
	@GetMapping ("/buscarTotalNomina")
	public List<Object> buscarTotalNomina(){
		return this.repositorio.totalNomina("2025");
			
		}
	
	@GetMapping ("/buscarTotalMes")
	public List<Object> buscarTotalMes(){
		return this.repositorio.totalMes();
			
		}
	@GetMapping ("/buscarTotalEmp")
	public List<Object> buscarTotalEmp(){
		return this.repositorio.totalEmp();
			
		}
	
	@GetMapping ("/buscarPagos")
	public List<Object> buscarPagos(){
		return this.repositorio.Pagos();
			
		}
	
	@GetMapping ("/buscarMayorS")
	public List<Object> buscarMayors(){
		return this.repositorio.MayorS();
			
		}
	@GetMapping ("/buscarPromedio")
	public List<Object> buscarPromedio(){
		return this.repositorio.promedioMes();
			
		}
	@GetMapping ("/buscarTotalEmpl")
	public List<Object> buscarTotalEmpl(){
		return this.repositorio.totalEmpl("02",1112L);
			
		}
	@PostMapping("/borrarEmpleadoId")
	public Optional<Empleado> eliminarEmpleado(@RequestBody Long n){
		Empleado e = this.repositorio.findById(n).get();
		List <Nomina_Empleado> nE= this.repositorioN.findByEmpleado(e);
		for(int i=0;i<nE.size();i++) {
			this.repositorioN.deleteById(nE.get(i).getId_nomina());
		}		
		this.repositorio.deleteById(n);
	 return Optional.empty();
	}


@PostMapping("/actualizarEmpleadoId")
public List<Empleado> actualizarEmpleado(@RequestBody Empleado e){
	List <Empleado> nE= this.repositorio.findAll();
	for(int i=0;i<nE.size();i++) {
		Long identificacion=nE.get(i).getIdentificacion();
		Long id=e.getIdentificacion();
		 if (identificacion.equals(id)){
		nE.get(i).setNombre(e.getNombre());
		nE.get(i).setApellidos(e.getApellidos());
		nE.get(i).setEmail(e.getEmail());
		nE.get(i).setIdentificacion(e.getIdentificacion());
	}
		 }
	return this.repositorio.saveAll(nE);		
}
}
