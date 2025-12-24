package pe.com.almacen.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import pe.com.almacen.entity.TipoMovimientoEntity;

public interface TipoMovimientoRepository
        extends JpaRepository<TipoMovimientoEntity, Integer> {
}
