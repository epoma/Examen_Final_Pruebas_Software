
package pe.com.tiendita.restcontroller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import java.util.List;
import java.util.Optional;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import pe.com.tiendita.entity.TicketPedidoEntity;
import pe.com.tiendita.service.TicketPedidoService;

@RestController
@RequestMapping("/ticketpedido")
public class TicketPedidoRestController {
    @Autowired
    private TicketPedidoService servicio;
    
    @GetMapping
    public List<TicketPedidoEntity> findAll(){
        return servicio.findAll();
    }
    
    @GetMapping("/custom")
    public List<TicketPedidoEntity> findAllCustom(){
        return servicio.findAllCustom();
    }
    
    @GetMapping("/{id}")
    public Optional<TicketPedidoEntity> findById(@PathVariable Long  id){
        return servicio.findById(id);
    }
    
    @PostMapping
    public TicketPedidoEntity add(@RequestBody TicketPedidoEntity c){
        return servicio.add(c);
    }
    
    @PutMapping("/{id}")
    public TicketPedidoEntity update(@PathVariable Long  id,@RequestBody TicketPedidoEntity c){
        c.setCodigo(id);
        return servicio.update(c);
    }
    
    @DeleteMapping("/{id}")
    public TicketPedidoEntity delete(@PathVariable Long  id){
        TicketPedidoEntity objticket = new TicketPedidoEntity();
        objticket.setEstado(false);
        return servicio.delete(TicketPedidoEntity.builder().codigo(id).build());
    }
}
