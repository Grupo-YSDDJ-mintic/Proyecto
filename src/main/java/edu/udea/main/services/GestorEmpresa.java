package edu.udea.main.services;

import edu.udea.main.entities.Empresa;
import edu.udea.main.repositories.EmpresaRepositorio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class GestorEmpresa {

    @Autowired
    private EmpresaRepositorio empresaRepositorio;

    public List<Empresa> getEmpresas(){
        return empresaRepositorio.findAll();
    }

    public Empresa save(Empresa empresa){
        return empresaRepositorio.save(empresa);
    }

    public Empresa getEmpresa(Long id) {
        return empresaRepositorio.findById(id).get();
    }

    public Empresa updateEmpresa(Empresa empresa_update, Long id){
        Empresa empresa_upd = getEmpresa(id);
        if (empresa_update.getNit() != null && !empresa_update.getNit().equals("")){
            empresa_upd.setNit(empresa_update.getNit());
        }
        if (empresa_update.getNombre() != null && !empresa_update.getNombre().equals("")){
            empresa_upd.setNombre(empresa_update.getNombre());
        }
        if (empresa_update.getDireccion() != null && !empresa_update.getDireccion().equals("")){
            empresa_upd.setDireccion(empresa_update.getDireccion());
        }
        if (empresa_update.getTelefono() != null && !empresa_update.getTelefono().equals("")){
            empresa_upd.setTelefono(empresa_update.getTelefono());
        }
        return empresaRepositorio.save(empresa_upd);
    }

    public void deleteEmpresa(Long id){
        empresaRepositorio.deleteById(id);
    }

    }
