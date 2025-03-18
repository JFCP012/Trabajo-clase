import { CompraService } from './../servicio/compra.service';
import { Component, OnInit } from '@angular/core';
import { Compra } from '../entidades/compra';
import { CommonModule } from '@angular/common';
import { FormsModule } from '@angular/forms';
import { log } from 'console';

@Component({
  selector: 'app-compra',
  standalone: true,
  imports: [CommonModule,FormsModule],
  templateUrl: './compra.component.html',
  styleUrl: './compra.component.css'
})
export class CompraComponent implements OnInit {
  C :Compra =new Compra;
  compras: Compra[] = []; // Esto debería ser un array, no una función

  ngOnInit(): void {
    this.mostrar()
  }
  constructor(private CompraService:CompraService){}

  compra(){
    this.CompraService.compra(this.C).subscribe(dato=>{
console.log(dato)
    })

    }
    mostrar(){
      this.CompraService.mostrar().subscribe(dato=>{
        console.log(dato);
      })
    }
  }


