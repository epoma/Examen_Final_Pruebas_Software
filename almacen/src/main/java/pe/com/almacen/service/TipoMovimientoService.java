package pe.com.almacen.service;

import java.util.List;
import pe.com.almacen.entity.TipoMovimientoEntity;

public interface TipoMovimientoService {

    List<TipoMovimientoEntity> findAll();

    TipoMovimientoEntity findById(Integer id);

    TipoMovimientoEntity save(TipoMovimientoEntity tipoMovimiento);

    TipoMovimientoEntity update(TipoMovimientoEntity tipoMovimiento);

    void delete(Integer id);
}
