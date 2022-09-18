package edu.udea.webapp.repositories;

import edu.udea.webapp.entities.MovimientoDinero;
import org.springframework.data.jpa.repository.JpaRepository;


import java.util.List;

public interface RepositorioMovimientoDinero extends JpaRepository<MovimientoDinero, Long> {

    public List<MovimientoDinero> findAllByEmpresaId(long id);

}
