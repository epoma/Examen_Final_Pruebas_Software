/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package pe.com.tiendita.service;

import java.util.List;
import java.util.Optional;
import pe.com.tiendita.entity.UsuarioRolEntity;

public interface UsuarioRolService {
    List<UsuarioRolEntity> findAll();

    List<UsuarioRolEntity> findAllCustom();

    Optional<UsuarioRolEntity> findById(long id);

    UsuarioRolEntity add(UsuarioRolEntity c);

    UsuarioRolEntity update(UsuarioRolEntity c);

    UsuarioRolEntity delete(UsuarioRolEntity c);
}
