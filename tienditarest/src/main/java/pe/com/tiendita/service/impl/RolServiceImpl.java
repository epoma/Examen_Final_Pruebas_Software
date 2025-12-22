/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package pe.com.tiendita.service.impl;

import java.util.List;
import java.util.Optional;
import pe.com.tiendita.entity.RolEntity;
import pe.com.tiendita.service.RolService;
import org.springframework.stereotype.Service;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.*;
import pe.com.tiendita.repository.RolRepository;

@Service
public class RolServiceImpl implements RolService{
    
    @Autowired
    private RolRepository repositorio;

    @Override
    public List<RolEntity> findAll() {
        return repositorio.findAll();
    }

    @Override
    public List<RolEntity> findAllCustom() {
        return repositorio.findAllCustom();
    }

    @Override
    public Optional<RolEntity> findById(long id) {
        return repositorio.findById(id);
    }

    @Override
    public RolEntity add(RolEntity c) {
        return repositorio.save(c);
    
    }

    @Override
    public RolEntity update(RolEntity c) {
        RolEntity objrol = repositorio.getById(c.getCodigo());
        BeanUtils.copyProperties(c, objrol);
        return repositorio.save(objrol);
    }

    @Override
    public RolEntity delete(RolEntity c) {
        RolEntity objrol = repositorio.getById(c.getCodigo());
        objrol.setEstado(false);
        return repositorio.save(objrol);
    
    }
    
}
