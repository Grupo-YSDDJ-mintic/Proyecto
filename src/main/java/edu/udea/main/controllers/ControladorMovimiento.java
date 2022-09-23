package edu.udea.main.controllers;

import edu.udea.main.entities.MovimientoDinero;
import edu.udea.main.entities.ObjetoRespuesta;
import edu.udea.main.services.GestorMovimientoDinero;
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
    public ResponseEntity<ObjetoRespuesta> patchMovimiento(@RequestBody MovimientoDinero editarMovimiento, @PathVariable(name = "idEmpresa") long idEmpresa, @PathVariable(name = "idMov") long idMovimiento) {
        try {
            Object movimientoFinal = gestorMovimiento.patchMovimiento(editarMovimiento, idEmpresa, idMovimiento);
            return new ResponseEntity<>(new ObjetoRespuesta("Datos de movimiento modificados", movimientoFinal), HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(new ObjetoRespuesta(e.getMessage(), editarMovimiento), HttpStatus.INTERNAL_SERVER_ERROR);
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

