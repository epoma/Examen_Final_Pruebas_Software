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
import pe.com.tiendita.entity.ClienteEntity;
import pe.com.tiendita.entity.DistritoEntity;
import pe.com.tiendita.repository.ClienteRepository;


@DataJpaTest
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
public class ClienteTest {
    private ClienteEntity objcliente;
    private DistritoEntity objdistrito;

    @Autowired
    private ClienteRepository repositorio;

    @BeforeEach
    public void Inicio() {
        objcliente = new ClienteEntity();
        objdistrito = new DistritoEntity();
        System.out.println("@BeforeEach -> Inicio");
    }

    @AfterEach
    public void Final() {
        objcliente = null;
        objdistrito = null;
        System.out.println("@AfterEach -> Final");
    }

    @Test
    public void PruebaInicialTest() {
        System.out.println("Pruebas con Spring");
        System.out.println("@Test -> PruebaInicial");
    }

    @Test
    public void MostrarClienteTest() {
        List<ClienteEntity> listacliente = repositorio.findAllCustom();
        assertNotNull(listacliente);
        System.out.println("@Test -> MostrarCliente");
    }

    @Test
    public void MostrarClienteTodoTest() {
        List<ClienteEntity> listacliente = repositorio.findAll();
        assertNotNull(listacliente);
        System.out.println("@Test -> MostrarClienteTodoTest");
    }

    @Test
    public void BuscarClienteXCodigo() {
        long id = 1;
        Optional<ClienteEntity> listacliente = repositorio.findById(id);
        assertNotNull(listacliente);
        System.out.println("@Test -> BuscarClienteXCodigo");
    }

    @Test
    @Rollback(false)
    public void RegistrarCliente() {
        objcliente.setNombre("Prueba Registro Cliente 2025");
        objcliente.setApellido("Ramirez");
        objcliente.setApellidom("Linares");
        objcliente.setDni("78945698");
        objcliente.setDireccion("prueba");
        objcliente.setTelefono("4587458");
        objcliente.setCelular("987474789");
        objcliente.setCorreo("ramirez@gmail.com");
        objcliente.setSexo("masculino");
        objcliente.setEstado(true);

        //claves foraneas
        objdistrito.setCodigo(2L);
        objcliente.setDistrito(objdistrito);

        ClienteEntity cliente = repositorio.save(objcliente);
        assertNotNull(cliente);
        System.out.println("@Test -> RegistrarCliente");
    }

    @Test
    @Rollback(false)
    public void ActualizarCliente() {
        long id = 1;
        objcliente.setCodigo(id);
        objcliente.setNombre("Prueba Actualizacion Cliente 2025");
        objcliente.setApellido("Ramirez Prueba");
        objcliente.setApellidom("LinaresPrueba");
        objcliente.setDni("88888888");
        objcliente.setDireccion("prueba");
        objcliente.setTelefono("7777777");
        objcliente.setCelular("999999999");
        objcliente.setCorreo("ramirez@gmail.com Prueba");
        objcliente.setSexo("masculino Prueba");
        objcliente.setEstado(true);

        //claves foraneas
        objdistrito.setCodigo(2L);
        objcliente.setDistrito(objdistrito);

        ClienteEntity cliente = repositorio.save(objcliente);
        assertNotNull(cliente);
        System.out.println("@Test -> ActualizarCliente");
    }
    
    @Test
    @Rollback(false)
    public void EliminarCliente() {
        long id = 2;
        objcliente.setCodigo(id);
        objcliente.setNombre("Prueba Actualizacion Cliente 2025");
        objcliente.setApellido("Ramirez Prueba");
        objcliente.setApellidom("LinaresPrueba");
        objcliente.setDni("88888888");
        objcliente.setDireccion("prueba");
        objcliente.setTelefono("7777777");
        objcliente.setCelular("999999999");
        objcliente.setCorreo("ramirez@gmail.com Prueba");
        objcliente.setSexo("masculino Prueba");
        objcliente.setEstado(false);

        //claves foraneas
        objdistrito.setCodigo(2L);
        objcliente.setDistrito(objdistrito);

        ClienteEntity cliente = repositorio.save(objcliente);
        assertNotNull(cliente);
        System.out.println("@Test -> EliminarCliente");
    }
}
