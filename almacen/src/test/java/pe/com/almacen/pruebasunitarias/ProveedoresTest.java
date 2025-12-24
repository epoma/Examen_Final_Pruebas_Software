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

import pe.com.almacen.entity.ProveedoresEntity;
import pe.com.almacen.repository.ProveedoresRepository;

@DataJpaTest
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
public class ProveedoresTest {

    private ProveedoresEntity proveedor;

    @Autowired
    private ProveedoresRepository repository;

    @BeforeEach
    public void inicio() {
        proveedor = new ProveedoresEntity();
        System.out.println("@BeforeEach -> Inicio");
    }

    @AfterEach
    public void fin() {
        proveedor = null;
        System.out.println("@AfterEach -> Fin");
    }

    @Test
    public void pruebaInicialTest() {
        System.out.println("@Test -> PruebaInicialTest");
        assertTrue(true);
    }

    @Test
    public void mostrarProveedoresActivosTest() {
        List<ProveedoresEntity> lista = repository.findAllCustom();
        assertNotNull(lista);
        System.out.println("@Test -> MostrarProveedoresActivosTest");
    }

    @Test
    public void mostrarTodosLosProveedoresTest() {
        List<ProveedoresEntity> lista = repository.findAll();
        assertNotNull(lista);
        System.out.println("@Test -> MostrarTodosLosProveedoresTest");
    }

    @Test
    public void buscarProveedorPorIdTest() {
        Integer id = 1;
        Optional<ProveedoresEntity> proveedor = repository.findById(id);
        assertNotNull(proveedor);
        System.out.println("@Test -> BuscarProveedorPorIdTest");
    }

    @Test
    @Rollback(false)
    public void registrarProveedorTest() {
        proveedor.setNombre("Proveedor Prueba Unit Test");
        proveedor.setContacto("contacto@test.pe");
        proveedor.setUbicacion("Lima");
        proveedor.setRepresentante("Juan Pérez");
        proveedor.setEstado(1);

        ProveedoresEntity guardado = repository.save(proveedor);
        assertNotNull(guardado);
        System.out.println("@Test -> RegistrarProveedorTest");
    }

    @Test
    @Rollback(false)
    public void actualizarProveedorTest() {
        Integer id = 1;

        proveedor.setIdProveedor(id);
        proveedor.setNombre("Proveedor Actualizado Test");
        proveedor.setContacto("actualizado@test.pe");
        proveedor.setUbicacion("Lima");
        proveedor.setRepresentante("María López");
        proveedor.setEstado(1);

        ProveedoresEntity actualizado = repository.save(proveedor);
        assertNotNull(actualizado);
        System.out.println("@Test -> ActualizarProveedorTest");
    }

    @Test
    @Rollback(false)
    public void eliminarProveedorLogicoTest() {
        Integer id = 1;

        proveedor.setIdProveedor(id);
        proveedor.setNombre("Proveedor Eliminado Test");
        proveedor.setEstado(0); // borrado lógico

        ProveedoresEntity eliminado = repository.save(proveedor);
        assertNotNull(eliminado);
        System.out.println("@Test -> EliminarProveedorLogicoTest");
    }
}
