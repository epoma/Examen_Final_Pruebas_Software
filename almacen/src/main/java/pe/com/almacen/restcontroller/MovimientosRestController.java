package pe.com.almacen.restcontroller;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import pe.com.almacen.entity.MovimientosEntity;
import pe.com.almacen.service.MovimientosService;

@RestController
@RequestMapping("/api/movimientos")
public class MovimientosRestController {

    @Autowired
    private MovimientosService movimientosService;

    @GetMapping
    public List<MovimientosEntity> findAll() {
        return movimientosService.findAll();
    }

    @GetMapping("/{id}")
    public MovimientosEntity findById(@PathVariable Integer id) {
        return movimientosService.findById(id);
    }

    @PostMapping
    public MovimientosEntity save(@RequestBody MovimientosEntity movimiento) {
        return movimientosService.save(movimiento);
    }

    @PutMapping
    public MovimientosEntity update(@RequestBody MovimientosEntity movimiento) {
        return movimientosService.update(movimiento);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable Integer id) {
        movimientosService.delete(id);
    }
}
