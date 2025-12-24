package pe.com.almacen.restcontroller;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import pe.com.almacen.entity.EmpleadosEntity;
import pe.com.almacen.service.EmpleadosService;

@RestController
@RequestMapping("/api/empleados")
public class EmpleadosRestController {

    @Autowired
    private EmpleadosService empleadoService;

    @GetMapping
    public List<EmpleadosEntity> findAll() {
        return empleadoService.findAll();
    }

    @GetMapping("/custom")
    public List<EmpleadosEntity> findAllCustom() {
        return empleadoService.findAllCustom();
    }

    @GetMapping("/{id}")
    public EmpleadosEntity findById(@PathVariable Integer id) {
        return empleadoService.findById(id);
    }

    @PostMapping
    public EmpleadosEntity save(@RequestBody EmpleadosEntity empleado) {
        return empleadoService.save(empleado);
    }

    @PutMapping
    public EmpleadosEntity update(@RequestBody EmpleadosEntity empleado) {
        return empleadoService.update(empleado);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable Integer id) {
        empleadoService.delete(id);
    }
}
