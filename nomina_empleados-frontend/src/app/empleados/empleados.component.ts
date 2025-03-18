import { EmpleadoService } from './../servicio/empleado.service';
import { CommonModule } from '@angular/common';
import { Empleados } from './../entidades/empleados';
import { Component, OnInit } from '@angular/core';
import { RegistroEmpleadoComponent } from "../registro-empleado/registro-empleado.component";
import { FormsModule } from '@angular/forms';

@Component({
  selector: 'app-empleados',
  standalone: true,
  imports: [CommonModule, RegistroEmpleadoComponent,FormsModule],
  templateUrl: './empleados.component.html',
  styleUrl: './empleados.component.css'
})
export class EmpleadosComponent /*implements OnInit*/ {
  empleados:Empleados[];
  empleado:Empleados = new Empleados;
  identificacion:number;

  ngOnInit(): void {
    this.verEmpleado();
/*
    this.empleados=[{
      "identificacion":123,
      "nombre":"juan",
      "apellidos":"bernal",
      "email":"juanbernal@gmail.com"
    }]
    
    this.empleado=[{
      "identificacion":1112,
      "nombre":"Juan",
      "apellidos":"Cely",
      "email":"juanfecelprieto@gmail.com"
    }]
    } */

    }
    constructor (private empleadoService:EmpleadoService,
      private servicio:EmpleadoService
    ){

    }
    private verEmpleado(){
      this.empleadoService.obtenerListaEmpleados().subscribe(dato=>{
        console.log(dato)
        this.empleados=dato;
      })
    }

    abrir(id:number){
      this.buscarRegistro(id);
      this.identificacion=id;
      const model=document.getElementById("actualizar")
      if(model!=null)
        model.style.display='block';  
    }

    eliminar(
      id:number
    ){
      this.empleadoService.Eliminar(id).subscribe(dato=>{
      console.log(dato)
      window.location.reload()
    })

    }

    actualizar(id:number){
      
this.empleadoService.actualizar(this.empleado).subscribe(dato=>{
  console.log(dato)
  const model=document.getElementById("actualizar")
  if(model!=null)
    model.style.display='block';  
});
}

  buscarRegistro(id:number){
    console.log(id);
    this.empleadoService.buscarEmpleadoId(id).subscribe(dato=>{
      this.empleado=dato;
      console.log(this,this.empleado)

    })

  }

  abrirRegistro(){
    const model=document.getElementById("actualizar")
    if(model!=null)
      model.style.display='block';  
  }

  cerrarRegistro(){
    const modal=document.getElementById("actualizar")
    if(modal!=null)
      modal.style.display='none'
  }
  guardarRegistro(){
    this.empleadoService.registrarEmpleado(this.empleado).subscribe(dato=>{
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
  

       
  


