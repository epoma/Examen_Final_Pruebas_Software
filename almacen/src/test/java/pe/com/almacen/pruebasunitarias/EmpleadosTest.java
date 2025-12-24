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

import pe.com.almacen.entity.EmpleadosEntity;
import pe.com.almacen.repository.EmpleadosRepository;

@DataJpaTest
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
public class EmpleadosTest {

    private EmpleadosEntity empleado;

    @Autowired
    private EmpleadosRepository repository;

    @BeforeEach
    public void inicio() {
        empleado = new EmpleadosEntity();
        System.out.println("@BeforeEach -> Inicio");
    }

    @AfterEach
    public void fin() {
        empleado = null;
        System.out.println("@AfterEach -> Fin");
    }

    @Test
    public void pruebaInicialTest() {
        System.out.println("@Test -> PruebaInicialTest");
        assertTrue(true);
    }

    @Test
    public void mostrarEmpleadosActivosTest() {
        List<EmpleadosEntity> lista = repository.findAllCustom();
        assertNotNull(lista);
        System.out.println("@Test -> MostrarEmpleadosActivosTest");
    }

    @Test
    public void mostrarTodosLosEmpleadosTest() {
        List<EmpleadosEntity> lista = repository.findAll();
        assertNotNull(lista);
        System.out.println("@Test -> MostrarTodosLosEmpleadosTest");
    }

    @Test
    public void buscarEmpleadoPorIdTest() {
        Integer id = 1;
        Optional<EmpleadosEntity> empleado = repository.findById(id);
        assertNotNull(empleado);
        System.out.println("@Test -> BuscarEmpleadoPorIdTest");
    }

    @Test
    @Rollback(false)
    public void registrarEmpleadoTest() {
        empleado.setNombre("Empleado Prueba Unit Test");
        empleado.setCargo("Auxiliar de Almacén");
        empleado.setEstado(1);

        EmpleadosEntity guardado = repository.save(empleado);
        assertNotNull(guardado);
        System.out.println("@Test -> RegistrarEmpleadoTest");
    }

    @Test
    @Rollback(false)
    public void actualizarEmpleadoTest() {
        Integer id = 1;

        empleado.setIdEmpleado(id);
        empleado.setNombre("Empleado Actualizado Test");
        empleado.setCargo("Supervisor de Almacén");
        empleado.setEstado(1);

        EmpleadosEntity actualizado = repository.save(empleado);
        assertNotNull(actualizado);
        System.out.println("@Test -> ActualizarEmpleadoTest");
    }

    @Test
    @Rollback(false)
    public void eliminarEmpleadoLogicoTest() {
        Integer id = 1;

        empleado.setIdEmpleado(id);
        empleado.setNombre("Empleado Eliminado Test");
        empleado.setEstado(0); // borrado lógico

        EmpleadosEntity eliminado = repository.save(empleado);
        assertNotNull(eliminado);
        System.out.println("@Test -> EliminarEmpleadoLogicoTest");
    }
}
