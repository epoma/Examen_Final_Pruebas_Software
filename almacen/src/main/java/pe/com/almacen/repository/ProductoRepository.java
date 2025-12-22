package pe.com.almacen.repository;

import java.util.List;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.jpa.repository.JpaRepository;
import pe.com.almacen.entity.ProductoEntity;

public interface ProductoRepository extends JpaRepository<ProductoEntity, Integer> {

    @Query("select p from ProductoEntity p where p.estado = 1")
    List<ProductoEntity> findAllCustom();
}