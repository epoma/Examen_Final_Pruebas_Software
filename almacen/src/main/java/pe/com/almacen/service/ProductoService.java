package pe.com.almacen.service;

import pe.com.almacen.entity.ProductoEntity;
import java.util.List;

public interface ProductoService {

    List<ProductoEntity> findAll();

    List<ProductoEntity> findAllCustom();

    ProductoEntity findById(Integer id);

    ProductoEntity save(ProductoEntity producto);

    ProductoEntity update(ProductoEntity producto);

    void delete(Integer id);
}