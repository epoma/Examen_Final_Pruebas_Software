/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package pe.com.tiendita.restcontroller;

import java.util.List;
import java.util.Optional;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import pe.com.tiendita.entity.UsuarioEntity;
import pe.com.tiendita.service.UsuarioService;

@RestController
@RequestMapping("/usuario")
public class UsuarioRestController {
    @Autowired
    private UsuarioService servicio;
    
    @GetMapping
    public List<UsuarioEntity> findAll(){
        return servicio.findAll();
    }
    
    @GetMapping("/custom")
    public List<UsuarioEntity> findAllCustom(){
        return servicio.findAllCustom();
    }
    
    @GetMapping("/{id}")
    public Optional<UsuarioEntity> findById(@PathVariable Long  id){
        return servicio.findById(id);
    }
    
    @PostMapping
    public UsuarioEntity add(@RequestBody UsuarioEntity c){
        return servicio.add(c);
    }
    
    @PutMapping("/{id}")
    public UsuarioEntity update(@PathVariable Long  id,@RequestBody UsuarioEntity c){
        c.setCodigo(id);
        return servicio.update(c);
    }
    
    @DeleteMapping("/{id}")
    public UsuarioEntity delete(@PathVariable Long  id){
        UsuarioEntity objcategoria = new UsuarioEntity();
        objcategoria.setEstado(false);
        return servicio.delete(UsuarioEntity.builder().codigo(id).build());
    }
}
