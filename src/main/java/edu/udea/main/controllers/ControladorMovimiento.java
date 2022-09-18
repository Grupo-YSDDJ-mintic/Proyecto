package edu.udea.webapp.controllers;

import edu.udea.webapp.entities.MovimientoDinero;
import edu.udea.webapp.entities.ObjectoRespuesta;
import edu.udea.webapp.services.GestorMovimientoDinero;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
public class ControladorMovimiento {

    @Autowired
    private GestorMovimientoDinero gestorMovimiento;

    @GetMapping("/enterprises/{id}/movements")
    public ResponseEntity<Object> getMovimientos(@PathVariable(name = "id") long id) {
       return new ResponseEntity<>(gestorMovimiento.getMovimientos(id), HttpStatus.ACCEPTED);

        /* try {
            List<MovimientoDinero> movimientosEmpresa = gestorMovimiento.getMovimientos(id);

            return new ResponseEntity<>(movimientosEmpresa, HttpStatus.ACCEPTED);
        } catch (Exception e) {
            return new ResponseEntity<>(e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
        }

        */
    }

    @GetMapping("/enterprises/{id}/movements/{idMov}")
    public ResponseEntity<Object> getMovimiento(@PathVariable(name = "id") long idEmpresa, @PathVariable(name = "idMov") long idMovimiento) {
        try {
            MovimientoDinero buscarMovimiento = gestorMovimiento.getMovimiento(idEmpresa, idMovimiento);
            return new ResponseEntity<>(buscarMovimiento, HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @PostMapping("/enterprises/{id}/movements")
    public ResponseEntity<String> postMovimiento(@RequestBody MovimientoDinero nuevoMovimiento, @PathVariable long id) {
        try {
            String mensaje = gestorMovimiento.postMovimiento(nuevoMovimiento, id);
            return new ResponseEntity<>(mensaje, HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @PatchMapping("/enterprises/{idEmpresa}/movements/{idMov}")
    public ResponseEntity<ObjectoRespuesta> patchMovimiento(@RequestBody MovimientoDinero editarMovimiento, @PathVariable(name = "idEmpresa") long idEmpresa, @PathVariable(name = "idMov") long idMovimiento) {
        try {
            Object movimientoFinal = gestorMovimiento.patchMovimiento(editarMovimiento, idEmpresa, idMovimiento);
            return new ResponseEntity<>(new ObjectoRespuesta("Datos de movimiento modificados", movimientoFinal), HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(new ObjectoRespuesta(e.getMessage(), editarMovimiento), HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @DeleteMapping("/enterprises/{idEmpresa}/movements/{idMov}")
    public ResponseEntity<String> deleteMovimiento(@RequestBody MovimientoDinero eliminarMovimiento, @PathVariable(name = "idEmpresa") long idEmpresa, @PathVariable(name = "idMov") long idMovimiento) {
        try {
            String mensajeEliminacion = gestorMovimiento.deleteMovimiento(eliminarMovimiento, idEmpresa, idMovimiento);
            return new ResponseEntity<>(mensajeEliminacion, HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}

