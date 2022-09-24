package edu.udea.webapp.repositories;

import edu.udea.webapp.entities.Empleado;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RepositorioEmpleado extends JpaRepository<Empleado, Long> {
}
