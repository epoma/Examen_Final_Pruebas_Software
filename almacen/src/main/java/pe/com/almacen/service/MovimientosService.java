package pe.com.almacen.service;

import java.util.List;
import pe.com.almacen.entity.MovimientosEntity;

public interface MovimientosService {

    List<MovimientosEntity> findAll();

    MovimientosEntity findById(Integer id);

    MovimientosEntity save(MovimientosEntity movimiento);

    MovimientosEntity update(MovimientosEntity movimiento);

    void delete(Integer id);
}
