package pe.com.almacen.repository;

import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import pe.com.almacen.entity.EmpleadosEntity;

public interface EmpleadosRepository extends JpaRepository<EmpleadosEntity, Integer> {

    @Query("select e from EmpleadosEntity e where e.estado = 1")
    List<EmpleadosEntity> findAllCustom();
}
