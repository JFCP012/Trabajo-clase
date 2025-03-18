import { ComponentFixture, TestBed } from '@angular/core/testing';

import { NominaEmpleadosComponent } from './nomina-empleados.component';

describe('NominaEmpleadosComponent', () => {
  let component: NominaEmpleadosComponent;
  let fixture: ComponentFixture<NominaEmpleadosComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      imports: [NominaEmpleadosComponent]
    })
    .compileComponents();
    
    fixture = TestBed.createComponent(NominaEmpleadosComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
