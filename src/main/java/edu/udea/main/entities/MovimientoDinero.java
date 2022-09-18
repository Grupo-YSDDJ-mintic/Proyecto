package edu.udea.webapp.entities;

import javax.persistence.*;

@Entity
@Table(name = "Movimientos")
public class MovimientoDinero {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "idMovimiento")
    private long id;

    @Column(name = "motivo")
    private String motivo;

    @Column(name = "monto")
    private float monto;

    @ManyToOne
    private Empresa empresa;

    @ManyToOne
    private Empleado empleado;


    public MovimientoDinero(long id, String motivo, float monto, Empleado empleado, Empresa empresa) {
        this.id = id;
        this.motivo = motivo;
        this.monto = monto;
        this.empleado = empleado;
        this.empresa = empresa;
    }

    public MovimientoDinero() {}

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getMotivo() {
        return motivo;
    }

    public void setMotivo(String motivo) {
        this.motivo = motivo;
    }

    public float getMonto() {
        return monto;
    }

    public void setMonto(float monto) {
        this.monto = monto;
    }

    public Empleado getEmpleado() {
        return empleado;
    }

    public void setEmpleado(Empleado empleado) {
        this.empleado = empleado;
    }

    public Empresa getEmpresa() {
        return empresa;
    }

    public void setEmpresa(Empresa empresa) {
        this.empresa = empresa;
    }
}
