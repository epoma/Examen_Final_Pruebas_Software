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
import pe.com.tiendita.entity.RolEntity;
import pe.com.tiendita.service.RolService;

@RestController
@RequestMapping("/rol")
public class RolRestController {
    
    @Autowired
    private RolService servicio;
    @GetMapping
    public List<RolEntity> findAll(){
        return servicio.findAll();
    }
    
    @GetMapping("/custom")
    public List<RolEntity> findAllCustom(){
        return servicio.findAllCustom();
    }
    
    @GetMapping("/{id}")
    public Optional<RolEntity> findById(@PathVariable Long  id){
        return servicio.findById(id);
    }
    
    @PostMapping
    public RolEntity add(@RequestBody RolEntity c){
        return servicio.add(c);
    }
    
    @PutMapping("/{id}")
    public RolEntity update(@PathVariable Long  id,@RequestBody RolEntity c){
        c.setCodigo(id);
        return servicio.update(c);
    }
    
    @DeleteMapping("/{id}")
    public RolEntity delete(@PathVariable Long  id){
        RolEntity objcategoria = new RolEntity();
        objcategoria.setEstado(false);
        return servicio.delete(RolEntity.builder().codigo(id).build());
    }
}
