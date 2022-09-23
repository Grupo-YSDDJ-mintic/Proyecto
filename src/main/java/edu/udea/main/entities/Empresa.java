package edu.udea.main.entities;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "empresa")
public class Empresa {
    @Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    private Long id;
    @Column
    private String nit;
    @Column
    private String nombre;
    @Column
    private String direccion;
    @Column
    private String telefono;
    @OneToMany(mappedBy = "empresa")
    @JsonIgnore
    private List<Empleado> empleados;
    @OneToMany(mappedBy = "empresa")
    @JsonIgnore
    private List<MovimientoDinero> movimientos;

    public Empresa(Long id, String nit, String nombre, String direccion, String telefono, List<Empleado> empleados, List<MovimientoDinero> movimientos) {
        this.id = id;
        this.nit = nit;
        this.nombre = nombre;
        this.direccion = direccion;
        this.telefono = telefono;
        this.empleados = empleados;
        this.movimientos = movimientos
    }

    public Empresa() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    public String getNit() {
        return nit;
    }

    public void setNit(String nit) {
        this.nit = nit;
    }

    public List<Empleado> getEmpleados() {
        return empleados;
    }

    public void setEmpleados(List<Empleado> empleados) {
        this.empleados = empleados;
    }

    public List<MovimientoDinero> getMovimientos() {
        return movimientos;
    }

    public void setMovimientos(List<MovimientoDinero> movimientos) {
        this.movimientos = movimientos;
    }
}
