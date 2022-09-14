package controllers;

import entities.MovimientoDinero;
import entities.ObjetoRespuesta;
import Services.GestorMovimientoDinero;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;

@RestController
public class ControladorMovimientoDinero {
      
    private GestorMovimientoDinero gestorMovimientoDinero = new GestorMovimientoDinero();
    
    @GetMapping("/enterprises/{id}/movements")
    public ResponseEntity <Object> getMovimientos(@PathVariable String id){
        try{
            ArrayList<MovimientoDinero> movimientoEmpresa = gestorMovimientoDinero.getMovimientos(id);
            return new ResponseEntity<>(movimientoEmpresa, HttpStatus.OK);
        }
        catch(Exception e){
            return new  ResponseEntity<>(e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
    
    @PostMapping("/enterprises/{id}/movements")
    public ResponseEntity<String> postMovimiento(@RequestBody MovimientoDinero NuevoMovimiento, @PathVariable String id){
    try{
        String mensaje = gestorMovimientoDinero.postMovimiento(NuevoMovimiento, id);
        return new ResponseEntity<>(mensaje, HttpStatus.OK);
    }
    catch (Exception e){
        return new ResponseEntity<>(e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
    
    @PatchMapping("/enterprises/{id}/movements")
    public ResponseEntity<ObjetoRespuesta> patchMovimiento(@RequestBody MovimientoDinero editarMovimiento, @PathVariable String id){
    try{
        Object UltimoMovimiento = gestorMovimientoDinero.patchMovimiento(editarMovimiento, id);
        return new ResponseEntity<>(new ObjectoRespuesta("Datos de movimientos modificados", UltimoMovimiento), HttpStatus.OK);
    }
    catch (Exception e){
        return new ResponseEntity<>(new ObjetoRespuesta(e.getMessage(), editarMovimiento), HttpStatus.INTERNAL_SERVER_ERROR);
        } 
    } 
    
    @DeleteMapping("/enterprises/{id}/movements")
    public ResponseEntity<String> deleteMovimiento(@RequestBody movimientoDinero, eliminarMovimiento, @PathVariable String id){
    try{
        String mensajeEliminacion = gestorMovimientoDinero.deleteMovimiento(eliminarMovimiento, id);
        return new ResponseEntity<>(mensajeEliminacion, HttpStatus.OK);
    }
    catch(Exception e){
        return new ResponseEntity<>(e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
        }        
    }   
}




