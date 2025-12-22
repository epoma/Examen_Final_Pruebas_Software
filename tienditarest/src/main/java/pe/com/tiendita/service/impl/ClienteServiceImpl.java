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
import pe.com.tiendita.entity.ClienteEntity;
import pe.com.tiendita.repository.ClienteRepository;
import pe.com.tiendita.service.ClienteService;

@Service
public class ClienteServiceImpl implements ClienteService{
    
    @Autowired
    private ClienteRepository repositorio;

    @Override
    public List<ClienteEntity> findAll() {
        return repositorio.findAll();
    }

    @Override
    public List<ClienteEntity> findAllCustom() {
        return repositorio.findAllCustom();
    }

    @Override
    public Optional<ClienteEntity> findById(long id) {
        return repositorio.findById(id);
    }

    @Override
    public ClienteEntity add(ClienteEntity c) {
        return repositorio.save(c);
    
    }

    @Override
    public ClienteEntity update(ClienteEntity c) {
        ClienteEntity objcliente = repositorio.getById(c.getCodigo());
        BeanUtils.copyProperties(c, objcliente);
        return repositorio.save(objcliente);
    }

    @Override
    public ClienteEntity delete(ClienteEntity c) {
        ClienteEntity objcliente = repositorio.getById(c.getCodigo());
        objcliente.setEstado(false);
        return repositorio.save(objcliente);
    
    }
}
