package com.example.demo.repositorio;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.example.demo.modelo.Empleado;

public interface EmpleadoRepositorio extends JpaRepository<Empleado,Long>{
	public Empleado findByEmail(String email);
    public List<Empleado> findByNombre(String nombre);	
    public List<Empleado> findByApellidos(String apellidos);

@Query(value="Select e.nombre,e.apellidos,e.identificacion,e.email,n.totalsalario,n.fecha from empleado e inner join"
+ " Nomina_Emp n on e.identificacion=n.identificacionE and e.identificacion =:idEmpleado",nativeQuery=true)

public List<Object> buscarNominaE(@Param("idEmpleado") Long idEmpleado);

@Query(value = "SELECT e.nombre, SUM(n.totalsalario) AS total_salario " +
        "FROM Nomina_Emp n " +
        "INNER JOIN empleado e ON e.identificacion = n.identificacionE " +
        "WHERE EXTRACT(YEAR FROM n.fecha) = :year " +
        "GROUP BY e.nombre",
nativeQuery = true)
public List<Object> totalNomina(@Param("year") String year);


@Query(value = "SELECT EXTRACT(month FROM n.fecha) AS mes, SUM(n.salario) AS total_salario " +
        "FROM Nomina_Emp n " +
        "GROUP BY mes ",nativeQuery = true)
public List<Object> totalMes();


@Query(value = "SELECT COUNT(*) from empleado",nativeQuery=true)
	
public List<Object> totalEmp();

@Query(value = "SELECT e.nombre, COUNT(n.totalsalario) FROM Nomina_Emp n INNER JOIN empleado e ON e.identificacion = n.identificacionE " +
        "GROUP BY e.nombre", nativeQuery = true)
public List<Object> Pagos();

@Query(value = "select e.nombre, count(n.totalsalario)from Nomina_Emp n " +
        "inner join empleado e ON e.identificacion = n.identificacionE " +
        "GROUP BY e.nombre",nativeQuery = true)
public List<Object> totalpago();


@Query(value = "select e.nombre,MAX(n.totalsalario) AS mayor from Nomina_Emp n " +
        "inner join empleado e on e.identificacion = n.identificacionE " +
        "GROUP BY e.nombre",nativeQuery = true)
public List<Object> MayorS();

@Query(value = "SELECT EXTRACT(month FROM n.fecha) AS mes, avg(n.salario) AS total_salario " +
        "FROM Nomina_Emp n " +
        "GROUP BY mes ",nativeQuery = true)
public List<Object> promedioMes();

@Query(value = "SELECT e.nombre, SUM(n.totalsalario)" +
        "FROM Nomina_Emp n " +
        "INNER JOIN empleado e ON e.identificacion = n.identificacionE " +
        "WHERE EXTRACT(MONTH FROM n.fecha) = :Mes and e.identificacion = :empl "+
        "GROUP BY e.nombre",
nativeQuery = true)
public List<Object> totalEmpl(@Param("Mes") String Mes,@Param("empl")Long empl );


}




