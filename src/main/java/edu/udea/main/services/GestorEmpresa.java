package edu.udea.main.services;

import edu.udea.main.entities.Empleado;
import edu.udea.main.entities.Empresa;
import edu.udea.main.entities.MovimientoDinero;

import java.util.ArrayList;

public class GestorEmpresa {

    //ArrayList provicional
    private ArrayList<Empresa> empresas;

    //Constructor
    public GestorEmpresa() {
        this.empresas = new ArrayList<>();
        this.empresas.add(new Empresa("Apple", "Calle falsa 123", "331222", "11102"));
    }

    //Muestra todas las empresas
    public ArrayList<Empresa> getEmpresas() {
        return empresas;
    }

    //Esto no tiene utilidad de momento
    public void setEmpresas(ArrayList<Empresa> empresas) {
        this.empresas = empresas;
    }

    //Se obtienen todas las empresas en el arrayList
    public Empresa getEmpresa(String laEmpresa) throws Exception {
        for (Empresa miEmpresa : this.empresas) {
            if (miEmpresa.getNombreEmpresa().equals(laEmpresa)) {
                return miEmpresa;
            }
        }

        throw new Exception("Empresa no existe");
    }

    //Método put para crear nuevas empresas
    public String setEmpresa(Empresa nuevaEmpresa) throws Exception {
        try {
            getEmpresa(nuevaEmpresa.getNombreEmpresa());
        } catch (Exception e) {
            this.empresas.add(nuevaEmpresa);
            return "Creación de empresa exitosa";
        }

        throw new Exception("Empresa ya existe");
    }

    //Método patch para editar algunos atributos de la empresa
    public Empresa patchEmpresa(Empresa actualizarEmpresa, String id) throws Exception {
        try {
            Empresa empresaActualizada = getEmpresa(id);

            if ((actualizarEmpresa.getNombreEmpresa() != null) && (actualizarEmpresa.getNombreEmpresa() != "")) {
                empresaActualizada.setNombreEmpresa(actualizarEmpresa.getNombreEmpresa());
            }

            if ((actualizarEmpresa.getTelefonoEmpresa() != null) && (actualizarEmpresa.getTelefonoEmpresa() != "")) {
                empresaActualizada.setTelefonoEmpresa(actualizarEmpresa.getTelefonoEmpresa());
            }

            if ((actualizarEmpresa.getDireccionEmpresa() != null) && (actualizarEmpresa.getDireccionEmpresa() != "")) {
                empresaActualizada.setDireccionEmpresa(actualizarEmpresa.getDireccionEmpresa());
            }

            if ((actualizarEmpresa.getNitEmpresa() != null) && (actualizarEmpresa.getNitEmpresa() != "")) {
                empresaActualizada.setNitEmpresa(actualizarEmpresa.getNitEmpresa());
            }

            return empresaActualizada;

        } catch (Exception e) {
            throw new Exception("No existe la empresa");
        }
    }

    public Empresa putEmpresa(Empresa nuevaEmpresa, String id) throws Exception {
        try {
            Empresa nuevaEmpresaFinal = getEmpresa(id);
            nuevaEmpresaFinal.setNombreEmpresa(nuevaEmpresa.getNombreEmpresa());
            nuevaEmpresaFinal.setTelefonoEmpresa(nuevaEmpresa.getTelefonoEmpresa());
            nuevaEmpresaFinal.setDireccionEmpresa(nuevaEmpresa.getDireccionEmpresa());
            nuevaEmpresaFinal.setNitEmpresa(nuevaEmpresa.getNitEmpresa());

            return nuevaEmpresaFinal;
        } catch (Exception e) {
            throw new Exception("No existe la empresa");
        }
    }

    public String deleteEmpresa(String id) throws Exception {
        try {
            empresas.remove(getEmpresa(id));
            return "Empresa eliminada";

        } catch (Exception e) {
            throw new Exception("No se encuentra empresa a eliminar");
        }

    }

    // Servicios movimientoDinero

    // Muestra todos los movimientos de la empresa

    public ArrayList<MovimientoDinero> getMovimientos(String id) throws Exception {
        try {
            Empresa verificarEmpresa = getEmpresa(id);
            return verificarEmpresa.getMovimientosEmpresa();
        } catch (Exception e) {
            throw new Exception("No existe la empresa");
        }
    }

    // Añade nuevos movimientos a la empresa

    public String postMovimiento(MovimientoDinero nuevoMovimiento, String id) throws Exception {
        try {
            Empresa verificarEmpresa = getEmpresa(id);
            verificarEmpresa.getMovimientosEmpresa().add(nuevoMovimiento);

            return "Nuevo movimiento añadido exitosamente";
        } catch (Exception e) {
            throw new Exception("No existe la empresa");
        }
    }

    // Edita información del movimiento de dinero

    public Object patchMovimiento(MovimientoDinero editarMovimiento, String id) throws Exception {
        ArrayList<MovimientoDinero> verificarEmpresa = getMovimientos(id);

        for (MovimientoDinero miMovimiento : verificarEmpresa) {
            if (miMovimiento.getUsuario().equals(editarMovimiento.getUsuario())) {
                if ((editarMovimiento.getMontoMovimiento()) != null) {
                    miMovimiento.setMontoMovimiento(editarMovimiento.getMontoMovimiento());
                    return miMovimiento;
                }

                if ((editarMovimiento.getMotivoMovimiento() != null) && (editarMovimiento.getMotivoMovimiento() != "")) {
                    miMovimiento.setMotivoMovimiento(editarMovimiento.getMotivoMovimiento());
                    return miMovimiento;
                }
            }
        }


        throw new Exception("Movimiento no encontrado");
    }

    // Eliminar movimiento

    public String deleteMovimiento(MovimientoDinero eliminarMovimiento, String id) throws Exception {
            try {
                Empresa eliminarMovimientoEmpresa = getEmpresa(id);

                for (MovimientoDinero movimientoAEliminar : eliminarMovimientoEmpresa.getMovimientosEmpresa()) {
                    if (movimientoAEliminar.getUsuario().equals(eliminarMovimiento.getUsuario())) {
                        eliminarMovimientoEmpresa.getMovimientosEmpresa().remove(movimientoAEliminar);
                    }
                }
                return "Movimiento Eliminado";
            } catch (Exception e) {
                throw new Exception("No se encontro el movimiento a eliminar");
            }


    }
}