package pe.com.tiendita.service;

import pe.com.tiendita.entity.CategoriaEntity;
import java.util.List;
import java.util.Optional;

public interface CategoriaService {

    List<CategoriaEntity> findAll();

    List<CategoriaEntity> findAllCustom();

    Optional<CategoriaEntity> findById(long id);

    CategoriaEntity add(CategoriaEntity c);

    CategoriaEntity update(CategoriaEntity c);

    CategoriaEntity delete(CategoriaEntity c);
}
