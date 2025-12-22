package pe.com.almacen.restcontroller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import pe.com.almacen.entity.ProductoEntity;
import pe.com.almacen.service.ProductoService;
import java.util.List;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;

@RestController
@RequestMapping("/api/producto")
public class ProductoRestController {

    @Autowired
    private ProductoService productoService;

    @GetMapping
    public List<ProductoEntity> findAll() {
        return productoService.findAll();
    }

    @GetMapping("/custom")
    public List<ProductoEntity> findAllCustom() {
        return productoService.findAllCustom();
    }

    @GetMapping("/{id}")
    public ProductoEntity findById(@PathVariable Integer id) {
        return productoService.findById(id);
    }

    @PostMapping
    public ProductoEntity save(@RequestBody ProductoEntity producto) {
        return productoService.save(producto);
    }

    @PutMapping
    public ProductoEntity update(@RequestBody ProductoEntity producto) {
        return productoService.update(producto);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable Integer id) {
        productoService.delete(id);
    }
}