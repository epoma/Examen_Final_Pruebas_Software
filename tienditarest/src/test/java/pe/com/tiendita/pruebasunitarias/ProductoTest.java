/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package pe.com.tiendita.pruebasunitarias;

import java.util.List;
import java.util.Optional;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.data.jpa.test.autoconfigure.DataJpaTest;
import org.springframework.boot.jdbc.test.autoconfigure.AutoConfigureTestDatabase;
import org.springframework.test.annotation.Rollback;
import pe.com.tiendita.entity.CategoriaEntity;
import pe.com.tiendita.entity.ProductoEntity;
import pe.com.tiendita.repository.ProductoRepository;

@DataJpaTest
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
public class ProductoTest {
    private ProductoEntity objproducto;
    private CategoriaEntity objcategoria;

    @Autowired
    private ProductoRepository repositorio;

    @BeforeEach
    public void Inicio() {
        objproducto = new ProductoEntity();
        objcategoria = new CategoriaEntity();
        System.out.println("@BeforeEach -> Inicio");
    }

    @AfterEach
    public void Final() {
        objproducto = null;
        objcategoria = null;
        System.out.println("@AfterEach -> Final");
    }

    @Test
    public void PruebaInicialTest() {
        System.out.println("Pruebas con Spring");
        System.out.println("@Test -> PruebaInicial");
    }

    @Test
    public void MostrarProductoTest() {
        List<ProductoEntity> listaproducto = repositorio.findAllCustom();
        assertNotNull(listaproducto);
        System.out.println("@Test -> MostrarProducto");
    }

    @Test
    public void MostrarProductoTodoTest() {
        List<ProductoEntity> listaproducto = repositorio.findAll();
        assertNotNull(listaproducto);
        System.out.println("@Test -> MostrarProductoTodoTest");
    }

    @Test
    public void BuscarProductoXCodigo() {
        long id = 1;
        Optional<ProductoEntity> listaproducto = repositorio.findById(id);
        assertNotNull(listaproducto);
        System.out.println("@Test -> BuscarProductoXCodigo");
    }

    @Test
    @Rollback(false)
    public void RegistrarProducto() {
        objproducto.setNombre("Prueba Registro Producto 2025");
        objproducto.setPreciocompra(480);
        objproducto.setPrecioventa(540);
        objproducto.setCantidad(30);
        objproducto.setEstado(true);

        //claves foraneas
        objcategoria.setCodigo(2L);
        objproducto.setCategoria(objcategoria);

        ProductoEntity producto = repositorio.save(objproducto);
        assertNotNull(producto);
        System.out.println("@Test -> RegistrarProducto");
    }

    @Test
    @Rollback(false)
    public void ActualizarProducto() {
        long id = 2;
        objproducto.setCodigo(id);
        objproducto.setNombre("Prueba Actualizacion Producto 2025");
        objproducto.setPreciocompra(680);
        objproducto.setPrecioventa(740);
        objproducto.setCantidad(300);
        objproducto.setEstado(true);

        //claves foraneas
        objcategoria.setCodigo(2L);
        objproducto.setCategoria(objcategoria);

        ProductoEntity producto = repositorio.save(objproducto);
        assertNotNull(producto);
        System.out.println("@Test -> ActualizarProducto");
    }
    
    @Test
    @Rollback(false)
    public void EliminarProducto() {
        long id = 2;
        objproducto.setCodigo(id);
        objproducto.setNombre("Prueba Actualizacion Producto 2025");
        objproducto.setPreciocompra(680);
        objproducto.setPrecioventa(740);
        objproducto.setCantidad(300);
        objproducto.setEstado(false);

        //claves foraneas
        objcategoria.setCodigo(2L);
        objproducto.setCategoria(objcategoria);

        ProductoEntity producto = repositorio.save(objproducto);
        assertNotNull(producto);
        System.out.println("@Test -> EliminarProducto");
    }
}
