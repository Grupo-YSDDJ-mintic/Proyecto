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

    @GetMapping("/employes")
    public ResponseEntity<List<Empleado>> getEmpleados(){
        return new ResponseEntity<>(gestorEmpleado.getEmpleados(),HttpStatus.OK);
    }

    @PostMapping("/employes")
    public ResponseEntity<Empleado> postEmpleado(@RequestBody Empleado empleado_parametro){
            return new ResponseEntity<>(gestorEmpleado.save(empleado_parametro),HttpStatus.OK);
    }

    @GetMapping("/employes/{id}")
    public ResponseEntity<Empleado> getEmpleado(@PathVariable Long id){
        return new ResponseEntity<>(gestorEmpleado.getEmpleado(id),HttpStatus.OK);
    }

    @PatchMapping("/employes/{id}")
    public ResponseEntity<Empleado> patchEmpleado(@RequestBody Empleado empleado_update, @PathVariable Long id) {
        gestorEmpleado.updateEmpleado(empleado_update, id);
        return new ResponseEntity<>(empleado_update,HttpStatus.OK);
    }

    @DeleteMapping("/employes/{id}")
    public ResponseEntity<String> deleteEmpleado(@PathVariable Long id){
        gestorEmpleado.deleteEmpleado(id);
        return new ResponseEntity<>(null,HttpStatus.OK);
    }

}
