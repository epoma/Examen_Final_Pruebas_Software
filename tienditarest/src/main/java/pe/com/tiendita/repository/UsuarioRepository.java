/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package pe.com.tiendita.repository;

import java.util.List;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.jpa.repository.JpaRepository;
import pe.com.tiendita.entity.UsuarioEntity;

public interface UsuarioRepository extends JpaRepository<UsuarioEntity, Long>{
    @Query("select u from UsuarioEntity u where u.estado=true")
    List<UsuarioEntity> findAllCustom();
}
