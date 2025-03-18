import { Empleados } from './../entidades/empleados';
import { Component, OnInit } from '@angular/core';
import { FormsModule } from '@angular/forms';
import { NominaService } from '../servicio/nomina.service';
import { EmpleadoService } from '../servicio/empleado.service';

@Component({
  selector: 'app-registro-empleado',
  standalone: true,
  imports: [FormsModule],
  templateUrl: './registro-empleado.component.html',
  styleUrl: './registro-empleado.component.css'
})
export class RegistroEmpleadoComponent implements OnInit {
  ngOnInit(): void {
  }
  Empleados:Empleados=new Empleados;

  constructor(private servicio:EmpleadoService
  ){

  }
 
  abrirRegistro(){
    const model=document.getElementById("registro")
    if(model!=null)
      model.style.display='block';  
  }

  cerrarRegistro(){
    const modal=document.getElementById("registro")
    if(modal!=null)
      modal.style.display='none'
  }
  
  guardarRegistro(){
    this.servicio.registrarEmpleado(this.Empleados).subscribe(dato=>{
      console.log(dato)
      if(dato!=null){
        alert("Empleado Registrado");
        this.cerrarRegistro();
        window.location.reload();
      }
else{
  alert("Registro no guardado")
}
    });
  }
}
