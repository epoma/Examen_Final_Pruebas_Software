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
import pe.com.tiendita.entity.DistritoEntity;
import pe.com.tiendita.repository.DistritoRepository;
import pe.com.tiendita.service.DistritoService;

@Service
public class DistritoServiceImpl implements DistritoService{
    
    @Autowired
    private DistritoRepository repositorio;

    @Override
    public List<DistritoEntity> findAll() {
        return repositorio.findAll();
    }

    @Override
    public List<DistritoEntity> findAllCustom() {
        return repositorio.findAllCustom();
    }

    @Override
    public Optional<DistritoEntity> findById(long id) {
        return repositorio.findById(id);
    }

    @Override
    public DistritoEntity add(DistritoEntity c) {
        return repositorio.save(c);
    
    }

    @Override
    public DistritoEntity update(DistritoEntity c) {
        DistritoEntity objdistrito = repositorio.getById(c.getCodigo());
        BeanUtils.copyProperties(c, objdistrito);
        return repositorio.save(objdistrito);
    }

    @Override
    public DistritoEntity delete(DistritoEntity c) {
        DistritoEntity objdistrito = repositorio.getById(c.getCodigo());
        objdistrito.setEstado(false);
        return repositorio.save(objdistrito);
    
    }
}
