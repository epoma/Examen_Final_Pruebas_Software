package pe.com.almacen.pruebasunitarias;

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

import pe.com.almacen.entity.*;
import pe.com.almacen.repository.MovimientosRepository;

@DataJpaTest
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
public class MovimientosTest {

    private MovimientosEntity movimiento;

    @Autowired
    private MovimientosRepository repository;

    @BeforeEach
    public void inicio() {
        movimiento = new MovimientosEntity();
        System.out.println("@BeforeEach -> Inicio");
    }

    @AfterEach
    public void fin() {
        movimiento = null;
        System.out.println("@AfterEach -> Fin");
    }

    @Test
    public void pruebaInicialTest() {
        System.out.println("@Test -> PruebaInicialTest");
        assertTrue(true);
    }

    @Test
    public void mostrarTodosLosMovimientosTest() {
        List<MovimientosEntity> lista = repository.findAll();
        assertNotNull(lista);
        System.out.println("@Test -> MostrarTodosLosMovimientosTest");
    }

    @Test
    public void buscarMovimientoPorIdTest() {
        Integer id = 1;
        Optional<MovimientosEntity> movimiento = repository.findById(id);
        assertNotNull(movimiento);
        System.out.println("@Test -> BuscarMovimientoPorIdTest");
    }

    @Test
    @Rollback(false)
    public void registrarMovimientoTest() {

        // ===== Claves foráneas (IDs existentes) =====
        TipoMovimientoEntity tipo = new TipoMovimientoEntity();
        tipo.setIdTipoMovimiento(1); // ENTRADA

        ProductosEntity producto = new ProductosEntity();
        producto.setIdProducto(1);

        AlmacenesEntity almacenDestino = new AlmacenesEntity();
        almacenDestino.setIdAlmacen(1); // Almacén Central

        EmpleadosEntity empleado = new EmpleadosEntity();
        empleado.setIdEmpleado(1);

        ProveedoresEntity proveedor = new ProveedoresEntity();
        proveedor.setIdProveedor(1);

        // ===== Movimiento =====
        movimiento.setTipoMovimiento(tipo);
        movimiento.setProducto(producto);
        movimiento.setCantidad(5);
        movimiento.setAlmacenDestino(almacenDestino);
        movimiento.setEmpleado(empleado);
        movimiento.setProveedor(proveedor);
        movimiento.setReferencia("Prueba Movimiento Unit Test");

        MovimientosEntity guardado = repository.save(movimiento);
        assertNotNull(guardado);
        System.out.println("@Test -> RegistrarMovimientoTest");
    }

    @Test
    @Rollback(false)
    public void actualizarMovimientoTest() {
        Integer id = 1;

        TipoMovimientoEntity tipo = new TipoMovimientoEntity();
        tipo.setIdTipoMovimiento(2); // SALIDA

        ProductosEntity producto = new ProductosEntity();
        producto.setIdProducto(1);

        AlmacenesEntity almacenOrigen = new AlmacenesEntity();
        almacenOrigen.setIdAlmacen(1);

        EmpleadosEntity empleado = new EmpleadosEntity();
        empleado.setIdEmpleado(1);

        movimiento.setIdMovimiento(id);
        movimiento.setTipoMovimiento(tipo);
        movimiento.setProducto(producto);
        movimiento.setCantidad(2);
        movimiento.setAlmacenOrigen(almacenOrigen);
        movimiento.setEmpleado(empleado);
        movimiento.setReferencia("Movimiento Actualizado Test");

        MovimientosEntity actualizado = repository.save(movimiento);
        assertNotNull(actualizado);
        System.out.println("@Test -> ActualizarMovimientoTest");
    }

    @Test
    @Rollback(false)
    public void eliminarMovimientoFisicoTest() {
        Integer id = 2;

        repository.deleteById(id);
        System.out.println("@Test -> EliminarMovimientoFisicoTest");
        assertTrue(true);
    }
}
