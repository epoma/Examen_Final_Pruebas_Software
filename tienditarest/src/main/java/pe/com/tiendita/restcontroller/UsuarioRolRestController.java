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
import pe.com.tiendita.entity.UsuarioRolEntity;
import pe.com.tiendita.service.UsuarioRolService;

@RestController
@RequestMapping("/usuariorol")
public class UsuarioRolRestController {
    @Autowired
    private UsuarioRolService servicio;
    
    @GetMapping
    public List<UsuarioRolEntity> findAll(){
        return servicio.findAll();
    }
    
    @GetMapping("/custom")
    public List<UsuarioRolEntity> findAllCustom(){
        return servicio.findAllCustom();
    }
    
    @GetMapping("/{id}")
    public Optional<UsuarioRolEntity> findById(@PathVariable Long  id){
        return servicio.findById(id);
    }
    
    @PostMapping
    public UsuarioRolEntity add(@RequestBody UsuarioRolEntity c){
        return servicio.add(c);
    }
    
    @PutMapping("/{id}")
    public UsuarioRolEntity update(@PathVariable Long  id,@RequestBody UsuarioRolEntity c){
        c.setCodigo(id);
        return servicio.update(c);
    }
    
    @DeleteMapping("/{id}")
    public UsuarioRolEntity delete(@PathVariable Long  id){
        UsuarioRolEntity objusuariorol = new UsuarioRolEntity();
        objusuariorol.setEstado(false);
        return servicio.delete(UsuarioRolEntity.builder().codigo(id).build());
    }
}
