package edu.udea.webapp.services;

import edu.udea.webapp.entities.Empleado;
import edu.udea.webapp.repositories.RepositorioEmpleado;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class GestorEmpleado implements GestorEmpleadoInterface {

    @Autowired
    private RepositorioEmpleado repositorio;

    @Override
    public List<Empleado> getUsers() {
        return repositorio.findAll();
    }

    @Override
    public Empleado getUser(long id) throws Exception {
        Optional<Empleado> usuarioBd = repositorio.findById(id);
        if(usuarioBd.isPresent()) {
            return usuarioBd.get();
        }

        throw new Exception("Usuario no encontrado");
    }

    @Override
    public String postUser(Empleado nuevoEmpleado) {
        repositorio.save(nuevoEmpleado);
        return "Nuevo empleado añadido";
    }

    @Override
    public Empleado patchUser(Empleado verificarEmpleado, long id) throws Exception {
        Empleado empleadoBd = getUser(id);

        if(verificarEmpleado.getNombreEmpleado() != null && !verificarEmpleado.getNombreEmpleado().equals("")) {
            empleadoBd.setNombreEmpleado(verificarEmpleado.getNombreEmpleado());
        }
        if(verificarEmpleado.getCorreoEmpleado() != null && !verificarEmpleado.getCorreoEmpleado().equals("")) {
            empleadoBd.setCorreoEmpleado(verificarEmpleado.getCorreoEmpleado());
        }
        if(verificarEmpleado.getRolEmpleado() != null && !verificarEmpleado.getRolEmpleado().equals("")) {
            empleadoBd.setRolEmpleado(verificarEmpleado.getRolEmpleado());
        }

        return repositorio.save(empleadoBd);
    }

    @Override
    public String deleteUser(long id) {
        repositorio.deleteById(id);
        return "Empleado Eliminado";
    }
}
