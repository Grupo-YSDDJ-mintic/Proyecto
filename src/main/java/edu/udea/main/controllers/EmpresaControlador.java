package com.udea.proyectoYSDDJ.controller;

import com.udea.proyectoYSDDJ.model.Empresa;
import com.udea.proyectoYSDDJ.model.ObjetoRespuesta;
import com.udea.proyectoYSDDJ.service.GestorEmpresa;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;

@RestController
public class EmpresaControlador {

    private GestorEmpresa gestorEmpresa = new GestorEmpresa();
    //@Autowired
    //private GestorEmpresa gestorEmpresa;

    @GetMapping("/enterprises")
    public ResponseEntity<ArrayList<Empresa>> getEmpresas(){
        return new ResponseEntity<>(gestorEmpresa.getEmpresas(),HttpStatus.OK);
    }

    @GetMapping("/empresa")
    public ResponseEntity<Object> getEmpresa(@RequestParam String id){
        try {
            Empresa empresa = gestorEmpresa.getEmpresa(id);
            return new ResponseEntity<>(empresa,HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(e.getMessage(),HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @GetMapping("/enterprises/{id}")
    public ResponseEntity<String> getEmpresaPath(@PathVariable String id){
        return new ResponseEntity<>(id,HttpStatus.OK);
    }

    @PostMapping("/enterprises")
    public ResponseEntity<String> postEmpresa(@RequestBody Empresa empresa_parametro){
        try {
            String mensaje = gestorEmpresa.setEmpresa(empresa_parametro);
            return new ResponseEntity<>(mensaje,HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(e.getMessage(),HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @PatchMapping("/enterprises/{id}")
    public ResponseEntity<ObjetoRespuesta> patchEmpresa(@RequestBody Empresa empresa_update, @PathVariable String id) {
        try {
            Empresa empresa_bd = gestorEmpresa.updateEmpresa(empresa_update, id);
            return new ResponseEntity<>(new ObjetoRespuesta("Actualización exitosa",empresa_bd),HttpStatus.OK);
        } catch (Exception e) {
            e.printStackTrace();
            return new ResponseEntity<>(new ObjetoRespuesta(e.getMessage(),null),HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @DeleteMapping("/enterprises/{id}")
    public ResponseEntity<ObjetoRespuesta> deleteEmpresa(@PathVariable String id){
        try {
            String mensaje = gestorEmpresa.deleteEmpresa(id);
            return new ResponseEntity<>(new ObjetoRespuesta(mensaje,null),HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(new ObjetoRespuesta(e.getMessage(),null),HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

}
