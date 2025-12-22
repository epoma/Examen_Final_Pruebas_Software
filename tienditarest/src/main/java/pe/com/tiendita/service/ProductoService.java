/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package pe.com.tiendita.service;

import pe.com.tiendita.entity.ProductoEntity;
import java.util.List;
import java.util.Optional;
public interface ProductoService {
    
    List<ProductoEntity> findAll();

    List<ProductoEntity> findAllCustom();

    Optional<ProductoEntity> findById(long id);

    ProductoEntity add(ProductoEntity p);

    ProductoEntity update(ProductoEntity p);

    ProductoEntity delete(ProductoEntity p);
}
