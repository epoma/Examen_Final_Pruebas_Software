package pe.com.almacen.service.impl;

import java.util.List;
import java.util.Optional;
import pe.com.almacen.entity.ProductoEntity;
import pe.com.almacen.repository.ProductoRepository;
import pe.com.almacen.service.ProductoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ProductoServiceImpl implements ProductoService {

    @Autowired
    private ProductoRepository productoRepository;

    @Override
    public List<ProductoEntity> findAll() {
        return productoRepository.findAll();
    }

    @Override
    public List<ProductoEntity> findAllCustom() {
        return productoRepository.findAllCustom();
    }

    @Override
    public ProductoEntity findById(Integer id) {
        Optional<ProductoEntity> producto = productoRepository.findById(id);
        return producto.orElse(null);
    }

    @Override
    public ProductoEntity save(ProductoEntity producto) {
        return productoRepository.save(producto);
    }

    @Override
    public ProductoEntity update(ProductoEntity producto) {
        return productoRepository.save(producto);
    }

    @Override
    public void delete(Integer id) {
        ProductoEntity producto = findById(id);
        if (producto != null) {
            producto.setEstado(0); // eliminado lógico
            productoRepository.save(producto);
        }
    }
}