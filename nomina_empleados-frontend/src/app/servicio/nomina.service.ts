import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { Nomina } from '../entidades/nomina';

@Injectable({
  providedIn: 'root'
})
export class NominaService {
  private bdURL ="http://localhost:8080/ver/nomina/buscarT";

  constructor(private HttpClient:HttpClient) {

   }


obtenerListaNomina(): Observable<Nomina[]>{
return this.HttpClient.get<Nomina[]>(`${this.bdURL}`)

}

parafiscalesU():Observable<any>{
  return this.HttpClient.get(`http://localhost:8080/ver/nomina/parafiscalesU`)
}

parafiscalesT():Observable<any>{
  return this.HttpClient.get(`http://localhost:8080/ver/nomina/parafiscales`)
}

cesantia():Observable<any>{
  return this.HttpClient.get(`http://localhost:8080/ver/nomina/cesantias`)
}

}
