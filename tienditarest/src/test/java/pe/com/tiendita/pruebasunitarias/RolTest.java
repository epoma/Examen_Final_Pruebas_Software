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
import pe.com.tiendita.entity.RolEntity;
import pe.com.tiendita.repository.RolRepository;

@DataJpaTest
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
public class RolTest {
    private RolEntity objrol;

    //inyeccion de dependencia
    @Autowired
    private RolRepository repositorio;

    @BeforeEach
    public void Inicio() {
        objrol = new RolEntity();
        System.out.println("@BeforeEach -> Inicio");
    }

    @AfterEach
    private void Final() {
        objrol = null;
        System.out.println("AfterEach->Final");
    }

    //pruebas al repositorio
    @Test
    public void MostrarRolTest() {
        List<RolEntity> listarol = repositorio.findAllCustom();
        assertNotNull(listarol);
        System.out.println("@Test -> MostrarRolTest");
    }

    @Test
    public void MostrarRolTodoTest() {
        List<RolEntity> listarol = repositorio.findAll();
        assertNotNull(listarol);
        System.out.println("@Test -> MostrarRolTodoTest");
    }

    @Test
    public void BuscarRolXCodigoTest() {
        long id = 2;
     
        Optional<RolEntity> listarol = repositorio.findById(id);
        assertNotNull(listarol);
        System.out.println("@Test ->BuscarRolXCodigoTest");
    }

    @Test
    //Rollback -> sirve para controlar si los cambios se mantienen o no
    @Rollback(false)
    public void RegistrarRol() {
        objrol.setNombre("Prueba Unitaria rol 2");
        objrol.setEstado(true);
        RolEntity rol = repositorio.save(objrol);
        assertNotNull(rol);
        System.out.println("@Test ->RegistrarRol");
    }

    @Test
    @Rollback(false)
    public void ActualizarCategoria() {
        objrol.setCodigo(3L);
        objrol.setNombre("Prueba actualizacion rol");
        objrol.setEstado(true);
        RolEntity rol = repositorio.save(objrol);
        assertNotNull(rol);
        System.out.println("@Test -> ActualizarRol");
    }

    @Test
    @Rollback(false)
    public void EliminarCategoria() {
        objrol.setCodigo(3L);
        objrol.setNombre("Prueba actualizacion rol");
        objrol.setEstado(false);
        RolEntity rol = repositorio.save(objrol);
        assertNotNull(rol);
        System.out.println("@Test -> EliminarRol");
    }
}
