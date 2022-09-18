package edu.udea.webapp.services;



import edu.udea.webapp.entities.MovimientoDinero;
import edu.udea.webapp.repositories.RepositorioMovimientoDinero;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
public class GestorMovimientoDinero {

    @Autowired
    private RepositorioMovimientoDinero repositorio;


    public List<MovimientoDinero> getMovimientos(long id) {
        return repositorio.findAllByEmpresaId(id);
    }


    public MovimientoDinero getMovimiento(long idEmpresa, long idMovimiento) throws Exception {
            List<MovimientoDinero> movimientosEmpresa = getMovimientos(idEmpresa);

            for (MovimientoDinero movimientoBuscado: movimientosEmpresa) {
                if(movimientoBuscado.getId() == idMovimiento) {
                    return movimientoBuscado;
                }
            }

            throw new Exception("Movimiento no encontrado");
        }



    public String postMovimiento(MovimientoDinero nuevoMovimiento, long id) {
        repositorio.save(nuevoMovimiento);
        return "Nuevo movimiento añadido";
    }


    public MovimientoDinero patchMovimiento(MovimientoDinero editarMovimiento, long idEmpresa, long idMovimiento) throws Exception {
        try {
            MovimientoDinero encontrarMovimiento = getMovimiento(idEmpresa, idMovimiento);

            if(editarMovimiento.getMonto() != encontrarMovimiento.getMonto()) {
                encontrarMovimiento.setMonto(editarMovimiento.getMonto());
            }

            if(editarMovimiento.getMotivo() != null && !editarMovimiento.getMotivo().equals("")) {
                encontrarMovimiento.setMotivo(editarMovimiento.getMotivo());
            }
            repositorio.save(encontrarMovimiento);
            return encontrarMovimiento;
        } catch (Exception e) {
            throw new Exception("Movimiento no encontrado");
        }
    }


    public String deleteMovimiento(MovimientoDinero movimientoAEliminar, long idEmpresa, long idMovimiento) throws Exception {
        try {
            MovimientoDinero encontrarMovimiento = getMovimiento(idEmpresa, idMovimiento);
            repositorio.deleteById(idMovimiento);
            return "Movimiento eliminado";
        } catch (Exception e) {
            return "Movimiento no encontrado";
        }
    }



}
