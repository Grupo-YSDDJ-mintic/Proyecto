package edu.udea.main.controllers;

import edu.udea.main.entities.Empresa;
import edu.udea.main.entities.ObjetoRespuesta;
import edu.udea.main.services.GestorEmpresa;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class EmpresaControlador {

    @Autowired
    private GestorEmpresa gestorEmpresa;

    @GetMapping("/enterprises")
    public ResponseEntity<List<Empresa>> getEmpresas(){
        return new ResponseEntity<>(gestorEmpresa.getEmpresas(),HttpStatus.OK);
    }

    @PostMapping("/enterprises")
    public ResponseEntity<Empresa> postEmpresa(@RequestBody Empresa empresa_parametro){
            return new ResponseEntity<>(gestorEmpresa.save(empresa_parametro),HttpStatus.OK);
    }

    @GetMapping("/enterprises/{id}")
    public ResponseEntity<Empresa> getEmpresa(@PathVariable Long id){
        return new ResponseEntity<>(gestorEmpresa.getEmpresa(id),HttpStatus.OK);
    }

    @PatchMapping("/enterprises/{id}")
    public ResponseEntity<Empresa> patchEmpresa(@RequestBody Empresa empresa_update, @PathVariable Long id) {
        gestorEmpresa.updateEmpresa(empresa_update, id);
        return new ResponseEntity<>(empresa_update,HttpStatus.OK);
    }

    @DeleteMapping("/enterprises/{id}")
    public ResponseEntity<String> deleteEmpresa(@PathVariable Long id){
        gestorEmpresa.deleteEmpresa(id);
        return new ResponseEntity<>(null,HttpStatus.OK);
    }

}
