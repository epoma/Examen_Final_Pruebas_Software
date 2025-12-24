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

import pe.com.almacen.entity.TipoMovimientoEntity;
import pe.com.almacen.repository.TipoMovimientoRepository;

@DataJpaTest
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
public class TipoMovimientoTest {

    private TipoMovimientoEntity tipoMovimiento;

    @Autowired
    private TipoMovimientoRepository repository;

    @BeforeEach
    public void inicio() {
        tipoMovimiento = new TipoMovimientoEntity();
        System.out.println("@BeforeEach -> Inicio");
    }

    @AfterEach
    public void fin() {
        tipoMovimiento = null;
        System.out.println("@AfterEach -> Fin");
    }

    @Test
    public void pruebaInicialTest() {
        System.out.println("@Test -> PruebaInicialTest");
        assertTrue(true);
    }

    @Test
    public void mostrarTodosLosTiposMovimientoTest() {
        List<TipoMovimientoEntity> lista = repository.findAll();
        assertNotNull(lista);
        System.out.println("@Test -> MostrarTodosLosTiposMovimientoTest");
    }

    @Test
    public void buscarTipoMovimientoPorIdTest() {
        Integer id = 1;
        Optional<TipoMovimientoEntity> tipo = repository.findById(id);
        assertNotNull(tipo);
        System.out.println("@Test -> BuscarTipoMovimientoPorIdTest");
    }

    @Test
    @Rollback(false)
    public void registrarTipoMovimientoTest() {
        tipoMovimiento.setNombre("PRUEBA_TEST");

        TipoMovimientoEntity guardado = repository.save(tipoMovimiento);
        assertNotNull(guardado);
        System.out.println("@Test -> RegistrarTipoMovimientoTest");
    }

    @Test
    @Rollback(false)
    public void actualizarTipoMovimientoTest() {
        Integer id = 1;

        tipoMovimiento.setIdTipoMovimiento(id);
        tipoMovimiento.setNombre("ACTUALIZADO_TEST");

        TipoMovimientoEntity actualizado = repository.save(tipoMovimiento);
        assertNotNull(actualizado);
        System.out.println("@Test -> ActualizarTipoMovimientoTest");
    }

    @Test
    @Rollback(false)
    public void eliminarTipoMovimientoFisicoTest() {
        Integer id = 3;

        repository.deleteById(id);
        System.out.println("@Test -> EliminarTipoMovimientoFisicoTest");
        assertTrue(true);
    }
}
