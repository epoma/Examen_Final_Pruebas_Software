package pe.com.almacen.service.impl;

import java.util.List;
import java.util.Optional;
import pe.com.almacen.entity.ProductosEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pe.com.almacen.repository.ProductosRepository;
import pe.com.almacen.service.ProductosService;

@Service
public class ProductosServiceImpl implements ProductosService {

    @Autowired
    private ProductosRepository productoRepository;

    @Override
    public List<ProductosEntity> findAll() {
        return productoRepository.findAll();
    }

    @Override
    public List<ProductosEntity> findAllCustom() {
        return productoRepository.findAllCustom();
    }

    @Override
    public ProductosEntity findById(Integer id) {
        Optional<ProductosEntity> producto = productoRepository.findById(id);
        return producto.orElse(null);
    }

    @Override
    public ProductosEntity save(ProductosEntity producto) {
        return productoRepository.save(producto);
    }

    @Override
    public ProductosEntity update(ProductosEntity producto) {
        return productoRepository.save(producto);
    }

    @Override
    public void delete(Integer id) {
        ProductosEntity producto = findById(id);
        if (producto != null) {
            producto.setEstado(0); // eliminado lógico
            productoRepository.save(producto);
        }
    }
}