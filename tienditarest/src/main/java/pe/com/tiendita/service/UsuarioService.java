/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package pe.com.tiendita.service;

import pe.com.tiendita.entity.UsuarioEntity;
import java.util.List;
import java.util.Optional;


public interface UsuarioService {
    List<UsuarioEntity> findAll();

    List<UsuarioEntity> findAllCustom();

    Optional<UsuarioEntity> findById(long id);

    UsuarioEntity add(UsuarioEntity c);

    UsuarioEntity update(UsuarioEntity c);

    UsuarioEntity delete(UsuarioEntity c);
}
