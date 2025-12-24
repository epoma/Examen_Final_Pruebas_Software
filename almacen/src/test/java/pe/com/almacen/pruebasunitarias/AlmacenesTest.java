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

import pe.com.almacen.entity.AlmacenesEntity;
import pe.com.almacen.repository.AlmacenesRepository;

@DataJpaTest
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
public class AlmacenesTest {

    private AlmacenesEntity almacen;

    @Autowired
    private AlmacenesRepository repository;

    @BeforeEach
    public void inicio() {
        almacen = new AlmacenesEntity();
        System.out.println("@BeforeEach -> Inicio");
    }

    @AfterEach
    public void fin() {
        almacen = null;
        System.out.println("@AfterEach -> Fin");
    }

    @Test
    public void pruebaInicialTest() {
        System.out.println("@Test -> PruebaInicialTest");
        assertTrue(true);
    }

    @Test
    public void mostrarAlmacenesActivosTest() {
        List<AlmacenesEntity> lista = repository.findAllCustom();
        assertNotNull(lista);
        System.out.println("@Test -> MostrarAlmacenesActivosTest");
    }

    @Test
    public void mostrarTodosLosAlmacenesTest() {
        List<AlmacenesEntity> lista = repository.findAll();
        assertNotNull(lista);
        System.out.println("@Test -> MostrarTodosLosAlmacenesTest");
    }

    @Test
    public void buscarAlmacenPorIdTest() {
        Integer id = 1;
        Optional<AlmacenesEntity> almacen = repository.findById(id);
        assertNotNull(almacen);
        System.out.println("@Test -> BuscarAlmacenPorIdTest");
    }

    @Test
    @Rollback(false)
    public void registrarAlmacenTest() {
        almacen.setNombre("Almacén Prueba Unit Test");
        almacen.setDireccion("Av. Pruebas 123 - Lima");
        almacen.setTipo("Sucursal");
        almacen.setEstado(1);

        AlmacenesEntity guardado = repository.save(almacen);
        assertNotNull(guardado);
        System.out.println("@Test -> RegistrarAlmacenTest");
    }

    @Test
    @Rollback(false)
    public void actualizarAlmacenTest() {
        Integer id = 1;

        almacen.setIdAlmacen(id);
        almacen.setNombre("Almacén Actualizado Test");
        almacen.setDireccion("Av. Actualización 456 - Lima");
        almacen.setTipo("Sucursal");
        almacen.setEstado(1);

        AlmacenesEntity actualizado = repository.save(almacen);
        assertNotNull(actualizado);
        System.out.println("@Test -> ActualizarAlmacenTest");
    }

    @Test
    @Rollback(false)
    public void eliminarAlmacenLogicoTest() {
        Integer id = 1;

        almacen.setIdAlmacen(id);
        almacen.setNombre("Almacén Eliminado Test");
        almacen.setEstado(0); // borrado lógico

        AlmacenesEntity eliminado = repository.save(almacen);
        assertNotNull(eliminado);
        System.out.println("@Test -> EliminarAlmacenLogicoTest");
    }
}
