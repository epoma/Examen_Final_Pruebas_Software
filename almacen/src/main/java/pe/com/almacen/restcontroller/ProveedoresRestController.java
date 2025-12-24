package pe.com.almacen.restcontroller;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import pe.com.almacen.entity.ProveedoresEntity;
import pe.com.almacen.service.ProveedoresService;

@RestController
@RequestMapping("/api/proveedores")
public class ProveedoresRestController {

    @Autowired
    private ProveedoresService proveedorService;

    @GetMapping
    public List<ProveedoresEntity> findAll() {
        return proveedorService.findAll();
    }

    @GetMapping("/custom")
    public List<ProveedoresEntity> findAllCustom() {
        return proveedorService.findAllCustom();
    }

    @GetMapping("/{id}")
    public ProveedoresEntity findById(@PathVariable Integer id) {
        return proveedorService.findById(id);
    }

    @PostMapping
    public ProveedoresEntity save(@RequestBody ProveedoresEntity proveedor) {
        return proveedorService.save(proveedor);
    }

    @PutMapping
    public ProveedoresEntity update(@RequestBody ProveedoresEntity proveedor) {
        return proveedorService.update(proveedor);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable Integer id) {
        proveedorService.delete(id);
    }
}
