import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { Compra } from '../entidades/compra';

@Injectable({
  providedIn: 'root'
})
export class CompraService {
  
  constructor(private httpClient :HttpClient) { }

  compra(compra:Compra):Observable<any>{
    return this.httpClient.post(`http://localhost:8080/ver/compra/guardar`,compra);
  }

  mostrar():Observable<Compra[]>{
    return this.httpClient.get<Compra[]>(`http://localhost:8080/ver/compra/compras`);
  }
}
