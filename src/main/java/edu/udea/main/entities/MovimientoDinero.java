package edu.udea.project.entities;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

public class MovimientoDinero {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;
    private float montoMovimiento;
    private String motivoMovimiento;
    private Empleado empleadoEncargado;
    private Empresa empresaEncargada;

    public MovimientoDinero(float montoMovimiento, String motivoMovimiento, Empleado empleadoEncargado) {
        this.montoMovimiento = montoMovimiento;
        this.motivoMovimiento = motivoMovimiento;
        this.empleadoEncargado = empleadoEncargado;
    }

    public float getMontoMovimiento() {
        return montoMovimiento;
    }

    public void setMontoMovimiento(float montoMovimiento) {
        this.montoMovimiento = montoMovimiento;
    }

    public String getMotivoMovimiento() {
        return motivoMovimiento;
    }

    public void setMotivoMovimiento(String motivoMovimiento) {
        this.motivoMovimiento = motivoMovimiento;
    }

    public Empleado getEmpleadoEncargado() {
        return empleadoEncargado;
    }

    public void setEmpleadoEncargado(Empleado empleadoEncargado) {
        this.empleadoEncargado = empleadoEncargado;
    }

    public Empresa getEmpresaEncargada() {
        return empresaEncargada;
    }

    public void setEmpresaEncargada(Empresa empresaEncargada) {
        this.empresaEncargada = empresaEncargada;
    }
}
