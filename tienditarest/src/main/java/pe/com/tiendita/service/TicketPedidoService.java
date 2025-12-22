/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package pe.com.tiendita.service;


import java.util.List;
import java.util.Optional;
import pe.com.tiendita.entity.TicketPedidoEntity;


public interface TicketPedidoService {
    List<TicketPedidoEntity> findAll();

    List<TicketPedidoEntity> findAllCustom();

    Optional<TicketPedidoEntity> findById(long id);

    TicketPedidoEntity add(TicketPedidoEntity c);

    TicketPedidoEntity update(TicketPedidoEntity c);

    TicketPedidoEntity delete(TicketPedidoEntity c);
}
