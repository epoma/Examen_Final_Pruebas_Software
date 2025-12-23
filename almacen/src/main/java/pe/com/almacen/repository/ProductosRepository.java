package pe.com.almacen.repository;

import java.util.List;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.jpa.repository.JpaRepository;
import pe.com.almacen.entity.ProductosEntity;

public interface ProductosRepository extends JpaRepository<ProductosEntity, Integer> {

    @Query("select p from ProductosEntity p where p.estado = 1")
    List<ProductosEntity> findAllCustom();
}