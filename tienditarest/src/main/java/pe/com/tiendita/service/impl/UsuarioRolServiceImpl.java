/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package pe.com.tiendita.service.impl;

import java.util.List;
import java.util.Optional;
import org.springframework.stereotype.Service;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.*;
import pe.com.tiendita.entity.UsuarioRolEntity;
import pe.com.tiendita.repository.UsuarioRolRepository;
import pe.com.tiendita.service.UsuarioRolService;

@Service
public class UsuarioRolServiceImpl implements UsuarioRolService{

   @Autowired
    private UsuarioRolRepository repositorio;

    @Override
    public List<UsuarioRolEntity> findAll() {
        return repositorio.findAll();
    }

    @Override
    public List<UsuarioRolEntity> findAllCustom() {
        return repositorio.findAllCustom();
    }

    @Override
    public Optional<UsuarioRolEntity> findById(long id) {
        return repositorio.findById(id);
    }

    @Override
    public UsuarioRolEntity add(UsuarioRolEntity c) {
        return repositorio.save(c);
    
    }

    @Override
    public UsuarioRolEntity update(UsuarioRolEntity c) {
        UsuarioRolEntity objusuariorol = repositorio.getById(c.getCodigo());
        BeanUtils.copyProperties(c, objusuariorol);
        return repositorio.save(objusuariorol);
    }

    @Override
    public UsuarioRolEntity delete(UsuarioRolEntity c) {
        UsuarioRolEntity objusuariorol = repositorio.getById(c.getCodigo());
        objusuariorol.setEstado(false);
        return repositorio.save(objusuariorol);
    
    }
    
}
