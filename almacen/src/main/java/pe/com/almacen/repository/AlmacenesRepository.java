package pe.com.almacen.repository;

import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import pe.com.almacen.entity.AlmacenesEntity;

public interface AlmacenesRepository extends JpaRepository<AlmacenesEntity, Integer> {

    @Query("select a from AlmacenesEntity a where a.estado = 1")
    List<AlmacenesEntity> findAllCustom();
}
