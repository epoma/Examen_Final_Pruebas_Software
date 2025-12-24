/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package pe.com.tiendita.repository;

import java.util.List;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.jpa.repository.JpaRepository;
import pe.com.tiendita.entity.ClienteEntity;

public interface ClienteRepository extends JpaRepository<ClienteEntity, Long>{
    @Query("select c from ClienteEntity c where c.estado=true")
    List<ClienteEntity> findAllCustom();
    
}
