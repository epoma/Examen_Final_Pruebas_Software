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
import pe.com.tiendita.entity.DetallePedidoEntity;
import pe.com.tiendita.entity.ProductoEntity;
import pe.com.tiendita.entity.TicketPedidoEntity;
import pe.com.tiendita.repository.DetallePedidoRepository;

@DataJpaTest
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
public class DetallePedidoTest {
    private DetallePedidoEntity objdetallep;

    //inyeccion de dependencia
    @Autowired
    private DetallePedidoRepository repositorio;

    @BeforeEach
    public void Inicio() {
        objdetallep = new DetallePedidoEntity();
        System.out.println("@BeforeEach -> Inicio");
    }

    @AfterEach
    private void Final() {
        objdetallep = null;
        System.out.println("AfterEach->Final");
    }

   

    @Test
    public void MostrarDetallePedidoTodoTest() {
        List<DetallePedidoEntity> listadetallep = repositorio.findAll();
        assertNotNull(listadetallep);
        System.out.println("@Test -> MostrarDetallePedidoTodoTest");
    }

    @Test
    public void BuscarDetallePedidoXCodigoTest() {
        long id = 2;
        //DetallePedidoEntity listadetallepedido=repositorio.findById(id).get();
        Optional<DetallePedidoEntity> listadetallep = repositorio.findById(id);
        assertNotNull(listadetallep);
        System.out.println("@Test ->BuscarDetallePedidoXCodigoTest");
    }

    @Test
    //Rollback -> sirve para controlar si los cambios se mantienen o no
    @Rollback(false)
    public void RegistrarDetallePedido() {

        TicketPedidoEntity ticketp = new TicketPedidoEntity();
        ticketp.setCodigo(1L); 
        objdetallep.setTicketpedido(ticketp);


        ProductoEntity producto = new ProductoEntity();
        producto.setCodigo(1L); // Asumiendo que ya existe en BD
        objdetallep.setProducto(producto);
        
        objdetallep.setCantidad(2);
        objdetallep.setPrecio(35.0);

        DetallePedidoEntity detallep = repositorio.save(objdetallep);
        assertNotNull(detallep);
        System.out.println("@Test ->RegistrarDetallePedido");
    }

    @Test
    @Rollback(false)
    public void ActualizarDetallePedido() {
                TicketPedidoEntity ticketp = new TicketPedidoEntity();
        ticketp.setCodigo(3L); 
        objdetallep.setTicketpedido(ticketp);


        ProductoEntity producto = new ProductoEntity();
        producto.setCodigo(1L); // Asumiendo que ya existe en BD
        objdetallep.setProducto(producto);
        
        objdetallep.setCantidad(2);
        objdetallep.setPrecio(80.0);

        DetallePedidoEntity detallep = repositorio.save(objdetallep);
        assertNotNull(detallep);
        System.out.println("@Test -> ActualizarDetallePedido");
    }

    @Test
    @Rollback(false)
    public void EliminarDetallePedido() {
        TicketPedidoEntity ticketp = new TicketPedidoEntity();
        ticketp.setCodigo(1L); 
        objdetallep.setTicketpedido(ticketp);


        ProductoEntity producto = new ProductoEntity();
        producto.setCodigo(1L); // Asumiendo que ya existe en BD
        objdetallep.setProducto(producto);
        
        objdetallep.setCantidad(2);
        objdetallep.setPrecio(20.0);

        DetallePedidoEntity detallep = repositorio.save(objdetallep);
        assertNotNull(detallep);
        System.out.println("@Test -> EliminarDetallePedido");
    }
}
