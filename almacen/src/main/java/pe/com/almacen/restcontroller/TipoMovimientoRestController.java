package pe.com.almacen.restcontroller;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import pe.com.almacen.entity.TipoMovimientoEntity;
import pe.com.almacen.service.TipoMovimientoService;

@RestController
@RequestMapping("/api/tipo-movimientos")
public class TipoMovimientoRestController {

    @Autowired
    private TipoMovimientoService tipoMovimientoService;

    @GetMapping
    public List<TipoMovimientoEntity> findAll() {
        return tipoMovimientoService.findAll();
    }

    @GetMapping("/{id}")
    public TipoMovimientoEntity findById(@PathVariable Integer id) {
        return tipoMovimientoService.findById(id);
    }

    @PostMapping
    public TipoMovimientoEntity save(@RequestBody TipoMovimientoEntity tipoMovimiento) {
        return tipoMovimientoService.save(tipoMovimiento);
    }

    @PutMapping
    public TipoMovimientoEntity update(@RequestBody TipoMovimientoEntity tipoMovimiento) {
        return tipoMovimientoService.update(tipoMovimiento);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable Integer id) {
        tipoMovimientoService.delete(id);
    }
}
