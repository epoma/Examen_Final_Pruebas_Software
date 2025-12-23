package pe.com.almacen.restcontroller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import pe.com.almacen.entity.ProductosEntity;
import java.util.List;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import pe.com.almacen.service.ProductosService;

@RestController
@RequestMapping("/api/productos")
public class ProductosRestController {

    @Autowired
    private ProductosService productoService;

    @GetMapping
    public List<ProductosEntity> findAll() {
        return productoService.findAll();
    }

    @GetMapping("/custom")
    public List<ProductosEntity> findAllCustom() {
        return productoService.findAllCustom();
    }

    @GetMapping("/{id}")
    public ProductosEntity findById(@PathVariable Integer id) {
        return productoService.findById(id);
    }

    @PostMapping
    public ProductosEntity save(@RequestBody ProductosEntity producto) {
        return productoService.save(producto);
    }

    @PutMapping
    public ProductosEntity update(@RequestBody ProductosEntity producto) {
        return productoService.update(producto);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable Integer id) {
        productoService.delete(id);
    }
}