package pe.com.almacen.service;

import java.util.List;
import pe.com.almacen.entity.ProveedoresEntity;

public interface ProveedoresService {

    List<ProveedoresEntity> findAll();

    List<ProveedoresEntity> findAllCustom();

    ProveedoresEntity findById(Integer id);

    ProveedoresEntity save(ProveedoresEntity proveedor);

    ProveedoresEntity update(ProveedoresEntity proveedor);

    void delete(Integer id);
}
