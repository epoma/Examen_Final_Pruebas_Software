/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package pe.com.tiendita.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import pe.com.tiendita.entity.RolEntity;
import java.util.List;
import org.springframework.data.jpa.repository.Query;

public interface RolRepository extends JpaRepository<RolEntity, Long>{
    @Query("select r from RolEntity r where r.estado=true")
    List<RolEntity> findAllCustom();
}
