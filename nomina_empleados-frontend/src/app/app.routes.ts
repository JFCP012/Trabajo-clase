import { NavegadorComponent } from './navegador/navegador.component';
import { Routes } from '@angular/router';
import { EmpleadosComponent } from './empleados/empleados.component';
import { NominaEmpleadosComponent } from './nomina-empleados/nomina-empleados.component';
import { CompraComponent } from './compra/compra.component';

export const routes: Routes = [
    {path:'empleado',component:EmpleadosComponent},
    {path:'nomina',component:NominaEmpleadosComponent},
    {path:'compra',component:CompraComponent}
];
