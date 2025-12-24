package pe.com.almacen.service;

import java.util.List;
import pe.com.almacen.entity.EmpleadosEntity;

public interface EmpleadosService {

    List<EmpleadosEntity> findAll();

    List<EmpleadosEntity> findAllCustom();

    EmpleadosEntity findById(Integer id);

    EmpleadosEntity save(EmpleadosEntity empleado);

    EmpleadosEntity update(EmpleadosEntity empleado);

    void delete(Integer id);
}
