package pe.com.tiendita.repository;

import java.util.List;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.jpa.repository.JpaRepository;
import pe.com.tiendita.entity.CategoriaEntity;
/**
 *
 * @author ronal
 */
public interface CategoriaRepository extends JpaRepository<CategoriaEntity, Long>{
    @Query("select c from CategoriaEntity c where c.estado=true")
    List<CategoriaEntity> findAllCustom();
}
