package edu.udea.webapp.controllers;

import edu.udea.webapp.entities.Empleado;
import edu.udea.webapp.entities.ObjectoRespuesta;
import edu.udea.webapp.services.GestorEmpleado;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


import java.util.List;

@RestController
public class ControladorEmpleado {

    @Autowired
    private GestorEmpleado gestorEmpleado;

    @GetMapping("/users")
    public ResponseEntity<List<Empleado>> getUsers() {
        return new ResponseEntity<>(gestorEmpleado.getUsers(), HttpStatus.ACCEPTED);
    }

    @GetMapping("/user/{id}")
    public ResponseEntity<Object> getUser(@PathVariable long id) {
        try {
            Empleado miEmpleado = gestorEmpleado.getUser(id);
            return new ResponseEntity<>(miEmpleado, HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @PostMapping("/users")
    public ResponseEntity<String> postUser(@RequestBody Empleado nuevoEmpleado) {
        try{
            String existeEmpresa = gestorEmpleado.postUser(nuevoEmpleado);
            return new ResponseEntity<>(existeEmpresa, HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @PatchMapping("/user/{id}")
    public ResponseEntity<ObjectoRespuesta> patchUser(@RequestBody Empleado nuevoDatosEmpleado, @PathVariable long id) {
        try{
            Empleado verificarEmpleado = gestorEmpleado.patchUser(nuevoDatosEmpleado, id);
            return new ResponseEntity<>(new ObjectoRespuesta("InformaciÃ³n de empleado actualizada", verificarEmpleado), HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(new ObjectoRespuesta(e.getMessage(), nuevoDatosEmpleado), HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @DeleteMapping("/user/{id}")
    public ResponseEntity<String> deleteUser(@PathVariable long id) {
        try{
            String mensaje = gestorEmpleado.deleteUser(id);
            return new ResponseEntity<>(mensaje, HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}
