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
import pe.com.tiendita.entity.ClienteEntity;
import pe.com.tiendita.service.ClienteService;

@RestController
@RequestMapping("/cliente")
public class ClienteRestController {
    @Autowired
    private ClienteService servicio;
    
    @GetMapping
    public List<ClienteEntity> findAll(){
        return servicio.findAll();
    }
    
    @GetMapping("/custom")
    public List<ClienteEntity> findAllCustom(){
        return servicio.findAllCustom();
    }
    
    @GetMapping("/{id}")
    public Optional<ClienteEntity> findById(@PathVariable Long  id){
        return servicio.findById(id);
    }
    
    @PostMapping
    public ClienteEntity add(@RequestBody ClienteEntity c){
        return servicio.add(c);
    }
    
    @PutMapping("/{id}")
    public ClienteEntity update(@PathVariable Long  id,@RequestBody ClienteEntity c){
        c.setCodigo(id);
        return servicio.update(c);
    }
    
    @DeleteMapping("/{id}")
    public ClienteEntity delete(@PathVariable Long  id){
        ClienteEntity objcliente = new ClienteEntity();
        objcliente.setEstado(false);
        return servicio.delete(ClienteEntity.builder().codigo(id).build());
    }
}
