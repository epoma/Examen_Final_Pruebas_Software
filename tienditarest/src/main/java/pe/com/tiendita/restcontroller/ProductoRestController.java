package pe.com.tiendita.restcontroller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import pe.com.tiendita.entity.ProductoEntity;
import pe.com.tiendita.service.ProductoService;
import java.util.List;
import java.util.Optional;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;

@RestController
@RequestMapping("/producto")
public class ProductoRestController {

    @Autowired
    private ProductoService servicio;

    @GetMapping
    public List<ProductoEntity> findAll() {
        return servicio.findAll();
    }

    @GetMapping("/custom")
    public List<ProductoEntity> findAllCustom() {
        return servicio.findAllCustom();
    }

    @GetMapping("/{id}")
    public Optional<ProductoEntity> findById(@PathVariable Long id) {
        return servicio.findById(id);
    }

    @PostMapping
    public ProductoEntity add(@RequestBody ProductoEntity p) {
        return servicio.add(p);
    }

    @PutMapping("/{id}")
    public ProductoEntity update(@PathVariable Long id, @RequestBody ProductoEntity p) {
        p.setCodigo(id);
        return servicio.update(p);
    }

    @DeleteMapping("/{id}")
    public ProductoEntity delete(@PathVariable Long id) {
        ProductoEntity objcategoria = new ProductoEntity();
        objcategoria.setEstado(false);
        return servicio.delete(ProductoEntity.builder().codigo(id).build());
    }
}
