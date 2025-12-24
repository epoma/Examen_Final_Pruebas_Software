package pe.com.almacen.repository;

import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import pe.com.almacen.entity.ProveedoresEntity;

public interface ProveedoresRepository extends JpaRepository<ProveedoresEntity, Integer> {

    @Query("select p from ProveedoresEntity p where p.estado = 1")
    List<ProveedoresEntity> findAllCustom();
}
