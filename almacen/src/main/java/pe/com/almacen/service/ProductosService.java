package pe.com.almacen.service;

import pe.com.almacen.entity.ProductosEntity;
import java.util.List;

public interface ProductosService {

    List<ProductosEntity> findAll();

    List<ProductosEntity> findAllCustom();

    ProductosEntity findById(Integer id);

    ProductosEntity save(ProductosEntity producto);

    ProductosEntity update(ProductosEntity producto);

    void delete(Integer id);
}