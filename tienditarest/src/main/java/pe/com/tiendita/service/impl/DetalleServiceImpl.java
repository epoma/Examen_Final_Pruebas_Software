/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package pe.com.tiendita.service.impl;

import java.util.List;
import java.util.Optional;
import org.springframework.stereotype.Service;

import org.springframework.beans.factory.annotation.Autowired;
import pe.com.tiendita.repository.CategoriaRepository;
import org.springframework.beans.*;
import pe.com.tiendita.entity.DetallePedidoEntity;
import pe.com.tiendita.repository.DetallePedidoRepository;
import pe.com.tiendita.service.DetallePedidoService;

@Service
public class DetalleServiceImpl implements DetallePedidoService{

    
    @Autowired
    private DetallePedidoRepository repositorio;
    
    @Override
    public List<DetallePedidoEntity> findAll() {
       return repositorio.findAll();
    }

    @Override
    public Optional<DetallePedidoEntity> findById(long id) {
        return repositorio.findById(id);
    }

    @Override
    public DetallePedidoEntity add(DetallePedidoEntity c) {
        return repositorio.save(c);
    
    }

    @Override
    public DetallePedidoEntity update(DetallePedidoEntity c) {
        DetallePedidoEntity objcategoria = repositorio.getById(c.getCodigo());
        BeanUtils.copyProperties(c, objcategoria);
        return repositorio.save(objcategoria);
    }

    @Override
    public DetallePedidoEntity delete(DetallePedidoEntity c) {
        DetallePedidoEntity objdetallepedido = repositorio.getById(c.getCodigo());
        repositorio.delete(objdetallepedido);
        return objdetallepedido;
    
    }
    
}
