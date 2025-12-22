/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package pe.com.tiendita.service;

import java.util.List;
import java.util.Optional;
import pe.com.tiendita.entity.DetallePedidoEntity;

public interface DetallePedidoService {
    
    List<DetallePedidoEntity> findAll();

    Optional<DetallePedidoEntity> findById(long id);

    DetallePedidoEntity add(DetallePedidoEntity c);

    DetallePedidoEntity update(DetallePedidoEntity c);

    DetallePedidoEntity delete(DetallePedidoEntity c);
}
