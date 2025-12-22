/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package pe.com.tiendita.repository;

import java.util.List;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.jpa.repository.JpaRepository;
import pe.com.tiendita.entity.UsuarioRolEntity;

public interface UsuarioRolRepository extends JpaRepository<UsuarioRolEntity, Long>{
    @Query("select c from UsuarioRolEntity c where c.estado=true")
    List<UsuarioRolEntity> findAllCustom();
}
