/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package pe.com.tiendita.service;

import java.util.List;
import java.util.Optional;
import pe.com.tiendita.entity.DistritoEntity;

public interface DistritoService {
    
    List<DistritoEntity> findAll();

    List<DistritoEntity> findAllCustom();

    Optional<DistritoEntity> findById(long id);

    DistritoEntity add(DistritoEntity c);

    DistritoEntity update(DistritoEntity c);

    DistritoEntity delete(DistritoEntity c);
}
