import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { Empleados } from '../entidades/empleados';

@Injectable({
  providedIn: 'root'
})
export class EmpleadoService {
  private bdURL ="http://localhost:8080/ver/empleado/empleados";
  private bdUR2L= "http://localhost:8080/ver/empleado/guardar";
  private bdURL3= "http://localhost:8080/ver/empleado/borrarEmpleadoId";
  private bdURL4= "http://localhost:8080/ver/empleado/actualizarEmpleadoId";
 

  constructor(private httpClient:HttpClient) { 
    
    }
    obtenerListaEmpleados():Observable<Empleados[]>{
      return this.httpClient.get<Empleados[]>(`${this.bdURL}`)
    }

      registrarEmpleado(empleado:Empleados):Observable<Object>{
        return this.httpClient.post(`${this.bdUR2L}`,empleado);
    }

    buscarEmpleadoId(
      id:number
    ):Observable<any>{
      return this.httpClient.get(`http://localhost:8080/ver/empleado/buscar?id=${id}`);
    }

    Eliminar(
      id:number
    ):Observable<any>{
      return this.httpClient.post(`${this.bdURL3}`,id);
    }

    actualizar(
      empleado:Empleados
    ):Observable<object>{
      return this.httpClient.post(`${this.bdURL4}`,empleado)
    }
 
}
