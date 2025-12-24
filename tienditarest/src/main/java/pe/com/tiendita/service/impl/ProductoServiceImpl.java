/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package pe.com.tiendita.service.impl;

import java.util.List;
import java.util.Optional;
import pe.com.tiendita.entity.ProductoEntity;
import pe.com.tiendita.repository.ProductoRepository;
import pe.com.tiendita.service.ProductoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.*;
import org.springframework.stereotype.Service;

@Service
public class ProductoServiceImpl implements ProductoService {

    @Autowired
    private ProductoRepository repositorio;

    @Override
    public List<ProductoEntity> findAll() {
        return repositorio.findAll();
    }

    @Override
    public List<ProductoEntity> findAllCustom() {
        return repositorio.findAllCustom();
    }

    @Override
    public Optional<ProductoEntity> findById(long id) {
        return repositorio.findById(id);
    }

    @Override
    public ProductoEntity add(ProductoEntity p) {
        return repositorio.save(p);
    }

    @Override
    public ProductoEntity update(ProductoEntity p) {
        ProductoEntity objproducto = repositorio.getById(p.getCodigo());
        BeanUtils.copyProperties(p, objproducto);
        return repositorio.save(objproducto);
    }

    @Override
    public ProductoEntity delete(ProductoEntity p) {
        ProductoEntity objproducto = repositorio.getById(p.getCodigo());
        objproducto.setEstado(false);
        return repositorio.save(objproducto);
    }

}
