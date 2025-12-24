
package pe.com.tiendita.service.impl;

import java.util.List;
import java.util.Optional;
import org.springframework.stereotype.Service;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.*;
import pe.com.tiendita.entity.TicketPedidoEntity;
import pe.com.tiendita.repository.TicketPedidoRepository;
import pe.com.tiendita.service.TicketPedidoService;

@Service
public class TicketPedidoServiceImpl implements TicketPedidoService{
    @Autowired
    private TicketPedidoRepository repositorio;

    @Override
    public List<TicketPedidoEntity> findAll() {
        return repositorio.findAll();
    }

    @Override
    public List<TicketPedidoEntity> findAllCustom() {
        return repositorio.findAllCustom();
    }

    @Override
    public Optional<TicketPedidoEntity> findById(long id) {
        return repositorio.findById(id);
    }

    @Override
    public TicketPedidoEntity add(TicketPedidoEntity c) {
        return repositorio.save(c);
    
    }

    @Override
    public TicketPedidoEntity update(TicketPedidoEntity c) {
        TicketPedidoEntity objticketpedido = repositorio.getById(c.getCodigo());
        BeanUtils.copyProperties(c, objticketpedido);
        return repositorio.save(objticketpedido);
    }

    @Override
    public TicketPedidoEntity delete(TicketPedidoEntity c) {
        TicketPedidoEntity objticketpedido = repositorio.getById(c.getCodigo());
        objticketpedido.setEstado(false);
        return repositorio.save(objticketpedido);
    
    }
}
