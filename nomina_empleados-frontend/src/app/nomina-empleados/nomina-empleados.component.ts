import { Nomina } from './../entidades/nomina';
import { CommonModule } from '@angular/common';
import { NominaService } from './../servicio/nomina.service';
import { Component, OnInit } from '@angular/core';

@Component({
  selector: 'app-nomina-empleados',
  standalone: true,
  imports: [CommonModule],
  templateUrl: './nomina-empleados.component.html',
  styleUrl: './nomina-empleados.component.css'
})
export class NominaEmpleadosComponent implements OnInit  {

  title: String
  Nomina:Nomina[];
  mensaje : boolean
  numero: any



  ngOnInit(): void { 
      this.title = "NOMINA"
     
  this.verNomina();
  }
  constructor(private NominaService:NominaService){

  }
  private verNomina(){

    this.title= "JUAN FELIPE CELY"
    this.NominaService.obtenerListaNomina().subscribe(datos=>{
      console.log(datos);
      this.Nomina=datos;
    })
  }

  parafiscales(){
    this.NominaService.parafiscalesU().subscribe(datos=>{
      console.log(datos);
      alert(datos);
    })
  }

  paafiscalesT(){
    this.NominaService.parafiscalesT().subscribe(datos=>{
      console.log(datos)
      alert(datos)
    })
  }

  cesantias(){
    this.NominaService.cesantia().subscribe(datos=>{
      console.log(datos)
      alert(datos)
    })
  }

}
