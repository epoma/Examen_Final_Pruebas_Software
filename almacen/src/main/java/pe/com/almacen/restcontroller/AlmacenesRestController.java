package pe.com.almacen.restcontroller;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import pe.com.almacen.entity.AlmacenesEntity;
import pe.com.almacen.service.AlmacenesService;

@RestController
@RequestMapping("/api/almacenes")
public class AlmacenesRestController {

    @Autowired
    private AlmacenesService almacenService;

    @GetMapping
    public List<AlmacenesEntity> findAll() {
        return almacenService.findAll();
    }

    @GetMapping("/custom")
    public List<AlmacenesEntity> findAllCustom() {
        return almacenService.findAllCustom();
    }

    @GetMapping("/{id}")
    public AlmacenesEntity findById(@PathVariable Integer id) {
        return almacenService.findById(id);
    }

    @PostMapping
    public AlmacenesEntity save(@RequestBody AlmacenesEntity almacen) {
        return almacenService.save(almacen);
    }

    @PutMapping
    public AlmacenesEntity update(@RequestBody AlmacenesEntity almacen) {
        return almacenService.update(almacen);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable Integer id) {
        almacenService.delete(id);
    }
}
