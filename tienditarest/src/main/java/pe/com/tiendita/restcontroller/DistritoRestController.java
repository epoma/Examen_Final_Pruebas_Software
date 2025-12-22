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
import pe.com.tiendita.entity.DistritoEntity;
import pe.com.tiendita.service.DistritoService;

@RestController
@RequestMapping("/distrito")


public class DistritoRestController {
    @Autowired
    private DistritoService servicio;
    
    @GetMapping
    public List<DistritoEntity> findAll(){
        return servicio.findAll();
    }
    
    @GetMapping("/custom")
    public List<DistritoEntity> findAllCustom(){
        return servicio.findAllCustom();
    }
    
    @GetMapping("/{id}")
    public Optional<DistritoEntity> findById(@PathVariable Long  id){
        return servicio.findById(id);
    }
    
    @PostMapping
    public DistritoEntity add(@RequestBody DistritoEntity c){
        return servicio.add(c);
    }
    
    @PutMapping("/{id}")
    public DistritoEntity update(@PathVariable Long  id,@RequestBody DistritoEntity c){
        c.setCodigo(id);
        return servicio.update(c);
    }
    
    @DeleteMapping("/{id}")
    public DistritoEntity delete(@PathVariable Long  id){
        DistritoEntity objdistrito = new DistritoEntity();
        objdistrito.setEstado(false);
        return servicio.delete(DistritoEntity.builder().codigo(id).build());
    }
}
