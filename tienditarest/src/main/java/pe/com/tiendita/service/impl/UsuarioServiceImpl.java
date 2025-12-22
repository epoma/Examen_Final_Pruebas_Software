/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package pe.com.tiendita.service.impl;

import java.util.List;
import java.util.Optional;
import org.springframework.stereotype.Service;
import org.springframework.beans.factory.annotation.Autowired;
import pe.com.tiendita.repository.UsuarioRepository;
import org.springframework.beans.*;
import pe.com.tiendita.entity.UsuarioEntity;
import pe.com.tiendita.service.UsuarioService;

@Service
public class UsuarioServiceImpl implements UsuarioService{
    
    @Autowired
    private UsuarioRepository repositorio;

    @Override
    public List<UsuarioEntity> findAll() {
        return repositorio.findAll();
    }

    @Override
    public List<UsuarioEntity> findAllCustom() {
        return repositorio.findAllCustom();
    }

    @Override
    public Optional<UsuarioEntity> findById(long id) {
        return repositorio.findById(id);
    }

    @Override
    public UsuarioEntity add(UsuarioEntity c) {
        return repositorio.save(c);
    
    }

    @Override
    public UsuarioEntity update(UsuarioEntity c) {
        UsuarioEntity objusuario = repositorio.getById(c.getCodigo());
        BeanUtils.copyProperties(c, objusuario);
        return repositorio.save(objusuario);
    }

    @Override
    public UsuarioEntity delete(UsuarioEntity c) {
        UsuarioEntity objusuario = repositorio.getById(c.getCodigo());
        objusuario.setEstado(false);
        return repositorio.save(objusuario);
    
    }
    
}
