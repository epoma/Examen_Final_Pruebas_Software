package pe.com.almacen.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import pe.com.almacen.entity.MovimientosEntity;

public interface MovimientosRepository
        extends JpaRepository<MovimientosEntity, Integer> {
}
