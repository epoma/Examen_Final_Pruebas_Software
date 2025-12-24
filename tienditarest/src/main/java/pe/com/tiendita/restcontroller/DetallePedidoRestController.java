/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
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
import pe.com.tiendita.entity.DetallePedidoEntity;
import pe.com.tiendita.service.DetallePedidoService;

@RestController
@RequestMapping("/detallepedido")
public class DetallePedidoRestController {
    @Autowired
    private DetallePedidoService servicio;
    
    @GetMapping
    public List<DetallePedidoEntity> findAll(){
        return servicio.findAll();
    }
    
    
    @GetMapping("/{id}")
    public Optional<DetallePedidoEntity> findById(@PathVariable Long  id){
        return servicio.findById(id);
    }
    
    @PostMapping
    public DetallePedidoEntity add(@RequestBody DetallePedidoEntity c){
        return servicio.add(c);
    }
    
    @PutMapping("/{id}")
    public DetallePedidoEntity update(@PathVariable Long  id,@RequestBody DetallePedidoEntity c){
        c.setCodigo(id);
        return servicio.update(c);
    }
    
    @DeleteMapping("/{id}")
    public DetallePedidoEntity delete(@PathVariable Long id) {
    return servicio.delete(
        DetallePedidoEntity.builder()
            .codigo(id)
            .build());
    }
}
