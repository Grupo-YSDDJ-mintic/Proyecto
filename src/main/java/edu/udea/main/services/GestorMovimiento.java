package edu.udea.main.services;

import edu.udea.main.entities.MovimientoDinero;

import java.util.ArrayList;

public class GestorMovimiento {

    private ArrayList<MovimientoDinero> movimientos = new ArrayList<>();

    public GestorMovimiento() {
    }

    public ArrayList<MovimientoDinero> getMovimientos(String id) {

        ArrayList<MovimientoDinero> losMovimientos = new ArrayList<>();
        for (MovimientoDinero todosLosMovimientos : movimientos) {
            //if (todosLosMovimientos.getEmpresaEncargada().getNombreEmpresa().equals(id)) {
            if(todosLosMovimientos.getEmpleadoEncargado().getEmpresaEmpleado().getNombreEmpresa().equals(id)) {
                losMovimientos.add(todosLosMovimientos);
            }
        }

        return losMovimientos;
    }

    public String postMovimiento(MovimientoDinero nuevoMovimiento, String id) throws Exception {
        for (MovimientoDinero verificarMovimientos : movimientos) {
            if (verificarMovimientos.getEmpleadoEncargado().getEmpresaEmpleado().getNombreEmpresa().equals(id)) {
                if ((nuevoMovimiento.getMontoMovimiento() == verificarMovimientos.getMontoMovimiento()) && (nuevoMovimiento.getMotivoMovimiento() == verificarMovimientos.getMotivoMovimiento())) {
                    throw new Exception("Movimiento repetido");
                }
            }
        }

        movimientos.add(nuevoMovimiento);
        return "Movimiento añadido";
    }

    public MovimientoDinero patchMovimiento(MovimientoDinero nuevosDatosMovimiento, String id) throws Exception {
        // try {
            ArrayList<MovimientoDinero> verificarMovimientos = getMovimientos(id);
            for (MovimientoDinero existeMovimiento : verificarMovimientos) {
                if ((existeMovimiento.getMontoMovimiento() == nuevosDatosMovimiento.getMontoMovimiento()) && (existeMovimiento.getEmpleadoEncargado().getNombreEmpleado().equals(nuevosDatosMovimiento.getEmpleadoEncargado().getNombreEmpleado())) || (existeMovimiento.getMotivoMovimiento().equals(nuevosDatosMovimiento.getMotivoMovimiento()) && (existeMovimiento.getEmpleadoEncargado().getNombreEmpleado().equals(nuevosDatosMovimiento.getEmpleadoEncargado().getNombreEmpleado())))) {
                    if ((nuevosDatosMovimiento.getMontoMovimiento() != 0)) {
                        existeMovimiento.setMontoMovimiento(nuevosDatosMovimiento.getMontoMovimiento());
                    }

                    if ((nuevosDatosMovimiento.getMotivoMovimiento() != null) && (nuevosDatosMovimiento.getMotivoMovimiento() != "")) {
                        existeMovimiento.setMotivoMovimiento(nuevosDatosMovimiento.getMotivoMovimiento());
                    }

                    return existeMovimiento;
                }
            }
        //} catch (Exception e) {
            throw new Exception("No se encontró el movimiento");
        //}
    }

    public String deleteMovimiento(MovimientoDinero movimientoAEliminar, String id) throws Exception {
        for (MovimientoDinero verificarMovimientos : movimientos) {
            if (verificarMovimientos.getEmpleadoEncargado().getEmpresaEmpleado().getNombreEmpresa().equals(id)) {
                if ((movimientoAEliminar.getMontoMovimiento() == verificarMovimientos.getMontoMovimiento()) && (movimientoAEliminar.getMotivoMovimiento().equals(verificarMovimientos.getMotivoMovimiento()))) {
                    movimientos.remove(verificarMovimientos);
                    return "Movimiento eliminado";
                }
            }
        }

        throw new Exception("No se encontró el movimiento");
    }
}
