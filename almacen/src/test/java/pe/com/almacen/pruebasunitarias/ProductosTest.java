package pe.com.almacen.pruebasunitarias;

import java.math.BigDecimal;
import java.util.List;
import java.util.Optional;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.data.jpa.test.autoconfigure.DataJpaTest;
import org.springframework.boot.jdbc.test.autoconfigure.AutoConfigureTestDatabase;
import org.springframework.test.annotation.Rollback;
import pe.com.almacen.entity.ProductosEntity;
import pe.com.almacen.repository.ProductosRepository;

@DataJpaTest
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
public class ProductosTest {

    private ProductosEntity producto;

    @Autowired
    private ProductosRepository repository;

    @BeforeEach
    public void inicio() {
        producto = new ProductosEntity();
        System.out.println("@BeforeEach -> Inicio");
    }

    @AfterEach
    public void fin() {
        producto = null;
        System.out.println("@AfterEach -> Fin");
    }

    @Test
    public void pruebaInicialTest() {
        System.out.println("@Test -> PruebaInicialTest");
        assertTrue(true);
    }

    @Test
    public void mostrarProductosActivosTest() {
        List<ProductosEntity> lista = repository.findAllCustom();
        assertNotNull(lista);
        System.out.println("@Test -> MostrarProductosActivosTest");
    }

    @Test
    public void mostrarTodosLosProductosTest() {
        List<ProductosEntity> lista = repository.findAll();
        assertNotNull(lista);
        System.out.println("@Test -> MostrarTodosLosProductosTest");
    }

    @Test
    public void buscarProductoPorIdTest() {
        Integer id = 1;
        Optional<ProductosEntity> producto = repository.findById(id);
        assertNotNull(producto);
        System.out.println("@Test -> BuscarProductoPorIdTest");
    }

    @Test
    @Rollback(false)
    public void registrarProductoTest() {
        producto.setNombre("Producto Prueba Unit Test");
        producto.setDescripcion("Registro desde prueba unitaria");
        producto.setPrecioCompra(new BigDecimal("120.50"));
        producto.setPrecioVenta(new BigDecimal("180.00"));
        producto.setEstado(1);

        ProductosEntity guardado = repository.save(producto);
        assertNotNull(guardado);
        System.out.println("@Test -> RegistrarProductoTest");
    }

    @Test
    @Rollback(false)
    public void actualizarProductoTest() {
        Integer id = 1;

        producto.setIdProducto(id);
        producto.setNombre("Producto Actualizado Test");
        producto.setDescripcion("Actualización desde prueba");
        producto.setPrecioCompra(new BigDecimal("200.00"));
        producto.setPrecioVenta(new BigDecimal("260.00"));
        producto.setEstado(1);

        ProductosEntity actualizado = repository.save(producto);
        assertNotNull(actualizado);
        System.out.println("@Test -> ActualizarProductoTest");
    }

    @Test
    @Rollback(false)
    public void eliminarProductoLogicoTest() {
        Integer id = 1;

        producto.setIdProducto(id);
        producto.setNombre("Producto Eliminado Test");
        producto.setEstado(0); // borrado lógico

        ProductosEntity eliminado = repository.save(producto);
        assertNotNull(eliminado);
        System.out.println("@Test -> EliminarProductoLogicoTest");
    }
}
