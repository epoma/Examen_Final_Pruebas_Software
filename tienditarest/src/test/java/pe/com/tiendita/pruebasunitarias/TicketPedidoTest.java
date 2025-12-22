/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package pe.com.tiendita.pruebasunitarias;
import java.time.LocalDateTime;
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
import pe.com.tiendita.entity.TicketPedidoEntity;
import pe.com.tiendita.entity.UsuarioEntity;
import pe.com.tiendita.repository.TicketPedidoRepository;


@DataJpaTest
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
public class TicketPedidoTest {
       private TicketPedidoEntity objticketp;

    //inyeccion de dependencia
    @Autowired
    private TicketPedidoRepository repositorio;

    @BeforeEach
    public void Inicio() {
        objticketp = new TicketPedidoEntity();
        System.out.println("@BeforeEach -> Inicio");
    }

    @AfterEach
    private void Final() {
        objticketp = null;
        System.out.println("AfterEach->Final");
    }

    //pruebas al repositorio
    @Test
    public void MostrarTicketPedidoTest() {
        List<TicketPedidoEntity> listaticketp = repositorio.findAllCustom();
        assertNotNull(listaticketp);
        System.out.println("@Test -> MostrarTicketPedidoTest");
    }

    @Test
    public void MostrarTicketPedidoTodoTest() {
        List<TicketPedidoEntity> listaticketp = repositorio.findAll();
        assertNotNull(listaticketp);
        System.out.println("@Test -> MostrarTicketPedidoTodoTest");
    }

    @Test
    public void BuscarTicketPedidoXCodigoTest() {
        long id = 2;
        //TicketPedidoEntity listaticketpedido=repositorio.findById(id).get();
        Optional<TicketPedidoEntity> listaticketp = repositorio.findById(id);
        assertNotNull(listaticketp);
        System.out.println("@Test ->BuscarTicketPedidoXCodigoTest");
    }

    @Test
    //Rollback -> sirve para controlar si los cambios se mantienen o no
    @Rollback(false)
    public void RegistrarTicketPedido() {
        objticketp.setFecha(LocalDateTime.now());
        objticketp.setEstado(true);
        ClienteEntity cliente = new ClienteEntity();
        cliente.setCodigo(1L); // Asumiendo que ya existe en BD
        objticketp.setCliente(cliente);


        UsuarioEntity usuario = new UsuarioEntity();
        usuario.setCodigo(1L); // Asumiendo que ya existe en BD
        objticketp.setUsuario(usuario);


        TicketPedidoEntity ticketpedido = repositorio.save(objticketp);

        assertNotNull(ticketpedido);
        System.out.println("@Test ->RegistrarTicketPedido");
    }

    @Test
    @Rollback(false)
    public void ActualizarTicketPedido() {
        objticketp.setFecha(LocalDateTime.now());
        objticketp.setEstado(true);
        ClienteEntity cliente = new ClienteEntity();
        cliente.setCodigo(1L); // Asumiendo que ya existe en BD
        objticketp.setCliente(cliente);


        UsuarioEntity usuario = new UsuarioEntity();
        usuario.setCodigo(1L); // Asumiendo que ya existe en BD
        objticketp.setUsuario(usuario);


        TicketPedidoEntity ticketpedido = repositorio.save(objticketp);
        assertNotNull(ticketpedido);
        System.out.println("@Test -> ActualizarTicketPedido");
    }

    @Test
    @Rollback(false)
    public void EliminarTicketPedido() {
        objticketp.setFecha(LocalDateTime.now());
        objticketp.setEstado(false);
        ClienteEntity cliente = new ClienteEntity();
        cliente.setCodigo(1L); // Asumiendo que ya existe en BD
        objticketp.setCliente(cliente);


        UsuarioEntity usuario = new UsuarioEntity();
        usuario.setCodigo(1L); // Asumiendo que ya existe en BD
        objticketp.setUsuario(usuario);


        TicketPedidoEntity ticketpedido = repositorio.save(objticketp);
        assertNotNull(ticketpedido);
        System.out.println("@Test -> EliminarTicketPedido");
    }
}
