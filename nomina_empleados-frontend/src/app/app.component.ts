import { Component } from '@angular/core';
import { RouterOutlet } from '@angular/router';
import { EmpleadosComponent } from './empleados/empleados.component';
import { NavegadorComponent } from './navegador/navegador.component';
import { NominaEmpleadosComponent } from './nomina-empleados/nomina-empleados.component';

@Component({
  selector: 'app-root',
  standalone: true,
  imports: [RouterOutlet,EmpleadosComponent,NavegadorComponent,NominaEmpleadosComponent],
  templateUrl: './app.component.html',
  styleUrl: './app.component.css'
})
export class AppComponent {
  title = 'nomina_empleados-frontend';
}
