package edu.udea.webapp.entities;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "Usuario")
public class Empleado {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "idUsuario")
    private long id;

    @Column(name = "nombre")
    private String nombreEmpleado;

    @Column(name = "correo")
    private String correoEmpleado;

    @ManyToOne
    private Empresa empresaEmpleado;

    @Enumerated(EnumType.STRING)
    @Column(name = "Rol")
    private Enum_RoleName rolEmpleado;

    @OneToMany(mappedBy = "empleado")
    @JsonIgnore
    private List<MovimientoDinero> transacciones;

    public Empleado(long id, String nombreEmpleado, String correoEmpleado, Empresa empresaEmpleado, Enum_RoleName rolEmpleado, List<MovimientoDinero> transacciones) {
        this.id = id;
        this.nombreEmpleado = nombreEmpleado;
        this.correoEmpleado = correoEmpleado;
        this.empresaEmpleado = empresaEmpleado;
        this.rolEmpleado = rolEmpleado;
        this.transacciones = transacciones;
    }

    public Empleado() {}

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getNombreEmpleado() {
        return nombreEmpleado;
    }

    public void setNombreEmpleado(String nombreEmpleado) {
        this.nombreEmpleado = nombreEmpleado;
    }

    public String getCorreoEmpleado() {
        return correoEmpleado;
    }

    public void setCorreoEmpleado(String correoEmpleado) {
        this.correoEmpleado = correoEmpleado;
    }

    public Empresa getEmpresaEmpleado() {
        return empresaEmpleado;
    }

    public void setEmpresaEmpleado(Empresa empresaEmpleado) {
        this.empresaEmpleado = empresaEmpleado;
    }

    public Enum_RoleName getRolEmpleado() {
        return rolEmpleado;
    }

    public void setRolEmpleado(Enum_RoleName rolEmpleado) {
        this.rolEmpleado = rolEmpleado;
    }

    public List<MovimientoDinero> getTransacciones() {
        return transacciones;
    }

    public void setTransacciones(List<MovimientoDinero> transacciones) {
        this.transacciones = transacciones;
    }
}
