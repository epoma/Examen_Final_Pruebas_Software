package pe.com.almacen.service;

import java.util.List;
import pe.com.almacen.entity.AlmacenesEntity;

public interface AlmacenesService {

    List<AlmacenesEntity> findAll();

    List<AlmacenesEntity> findAllCustom();

    AlmacenesEntity findById(Integer id);

    AlmacenesEntity save(AlmacenesEntity almacen);

    AlmacenesEntity update(AlmacenesEntity almacen);

    void delete(Integer id);
}
