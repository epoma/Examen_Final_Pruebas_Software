/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package pe.com.tiendita.service;

import java.util.List;
import java.util.Optional;
import pe.com.tiendita.entity.RolEntity;

public interface RolService {
    
    List<RolEntity> findAll();

    List<RolEntity> findAllCustom();

    Optional<RolEntity> findById(long id);

    RolEntity add(RolEntity r);

    RolEntity update(RolEntity r);

    RolEntity delete(RolEntity r);
}
