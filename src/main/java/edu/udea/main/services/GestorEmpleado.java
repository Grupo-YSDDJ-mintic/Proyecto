package edu.udea.main.services;

import clases.Empleado;
import edu.udea.main.entities.Empleado;
import edu.udea.main.entities.MovimientoDinero;

import java.util.ArrayList;

public class GestorEmpleado {

    //ArrayList provicional
    private ArrayList<Empleado> empleados;

    //Constructor
    public GestorEmpleado() {
        this.empleados = new ArrayList<>();
        this.empleados.add(new Empleado("Pepito Perez", "pepitoperez@gmail.com", "Apple", 01/02/2010,"01/02/2000,"Adm","500000""));
    }

    //Mostrar todos los empleados

    public ArrayList<Empleado> getEmpleado() {
        return empleados;
    }

    //Consulta de empleados

    public Empleado getEmpleado(String consultaEmpleado) throws Exception {
        for (Empleado empleado : this.empleados) {
            if (empleado.getNombreEmpleado().equals(consultaEmpleado)) {
                return empleado;
            }
        }

        throw new Exception("Empresa no existe");
    }

    // Creación de empleados

    public String setEmpleado(Empleado empleado_parametro) throws Exception {
        try {
            //Consulta de existencia de usuario
            getEmpleado(empleado_parametro.getNombreEmpleado());
        } catch (Exception e) {
            //Código para crear un usuario
            this.empleados.add(empleado_parametro);
            return "Creacion de usuario exitosa";
        }
        //Error si el usuario ya existe
        throw new Exception("Usuario Existe");
    }

    // Edición de empleado

    //USANDO PATCH

    public Empleado updateUsuario(Empleado empleado_update, String id) throws Exception {
        try {
            Empleado empleado_bd = getEmpleado(id);

            if (empleado_update.getNombreEmpleado() != null && !empleado_update.getNombreEmpleado().equals("")) {
                empleado_bd.setNombreEmpleado(empleado_update.getNombreEmpleado());
            }
            if (empleado_update.getCorreoEmpleado() != null && !empleado_update.getCorreoEmpleado().equals("")) {
                empleado_bd.setCorreoEmpleado(empleado_update.getCorreoEmpleado());
            }
            if (empleado_update.getUpdateAt() != null && !empleado_update.getUpdateAt().equals("")) {
                empleado_bd.setUpdateAt(empleado_update.getUpdateAt());
            }
            if(empleado_update.getCreatedAt() != null && !empleado_update.getCreatedAt().equals("")){
                empleado_bd.setCreatedAt(empleado_update.getCreatedAt());
            }
            if (empleado_update.getRolEmpleado() != null && !empleado_update.getRolEmpleado().equals("")){
                empleado_bd.setRolEmpleado(empleado_update.getRolEmpleado());
            }
            if(empleado_update.getTransaccion() != null && !empleado_update.getTransaccion().equals("")){
                empleado_bd.setTransaccion(empleado_update.getTransaccion());
            }

            return empleado_bd;
        } catch (Exception e) {
            throw new Exception("Usuario NO existe, fallo actualización de datos");
        }
    }


    //Eliminación de Empleado

    public void setEmpleados(ArrayList<Empleado> empleados) {
        this.empleados = empleados;
    }

    public String deleteEmpleado(String id) throws Exception {
        try {
            Empleado empleado = getEmpleado(id);

            this.empleados.remove(empleado);
            return "Usuario eliminado exitosamente.";

        } catch (Exception e) {
            throw new Exception("Usuario NO existe para eliminar");
        }
    }

}
