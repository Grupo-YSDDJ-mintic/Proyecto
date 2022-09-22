package edu.udea.webapp.repositories;

import edu.udea.webapp.entities.MovimientoDinero;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


import java.util.List;

@Repository
public interface RepositorioMovimientoDinero extends JpaRepository<MovimientoDinero, Long> {

    public List<MovimientoDinero> findAllByEmpresaId(long id);

}
