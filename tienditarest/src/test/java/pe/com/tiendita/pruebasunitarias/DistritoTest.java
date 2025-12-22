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
import pe.com.tiendita.entity.DistritoEntity;
import pe.com.tiendita.repository.DistritoRepository;

@DataJpaTest
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
public class DistritoTest {
    private DistritoEntity objdistrito;

    //inyeccion de dependencia
    @Autowired
    private DistritoRepository repositorio;

    @BeforeEach
    public void Inicio() {
        objdistrito = new DistritoEntity();
        System.out.println("@BeforeEach -> Inicio");
    }

    @AfterEach
    private void Final() {
        objdistrito = null;
        System.out.println("AfterEach->Final");
    }

    //pruebas al repositorio
    @Test
    public void MostrarDistritoTest() {
        List<DistritoEntity> listadistrito = repositorio.findAllCustom();
        assertNotNull(listadistrito);
        System.out.println("@Test -> MostrarDistritoTest");
    }

    @Test
    public void MostrarDistritoTodoTest() {
        List<DistritoEntity> listadistrito = repositorio.findAll();
        assertNotNull(listadistrito);
        System.out.println("@Test -> MostrarDistritoTodoTest");
    }

    @Test
    public void BuscarDistritoXCodigoTest() {
        long id = 2;
        //CategoriaEntity listacategoria=repositorio.findById(id).get();
        Optional<DistritoEntity> listadistrito = repositorio.findById(id);
        assertNotNull(listadistrito);
        System.out.println("@Test ->BuscarDistritoXCodigoTest");
    }

    @Test
    //Rollback -> sirve para controlar si los cambios se mantienen o no
    @Rollback(false)
    public void RegistrarDistrito() {
        objdistrito.setNombre("Prueba Unitaria distrito 2");
        objdistrito.setEstado(true);
        DistritoEntity categoria = repositorio.save(objdistrito);
        assertNotNull(categoria);
        System.out.println("@Test ->RegistrarDistrito");
    }

    @Test
    @Rollback(false)
    public void ActualizarCategoria() {
        objdistrito.setCodigo(3L);
        objdistrito.setNombre("Prueba actualizacion distrito");
        objdistrito.setEstado(true);
        DistritoEntity categoria = repositorio.save(objdistrito);
        assertNotNull(categoria);
        System.out.println("@Test -> ActualizarDistrito");
    }

    @Test
    @Rollback(false)
    public void EliminarCategoria() {
        objdistrito.setCodigo(3L);
        objdistrito.setNombre("Prueba actualizacion distrito");
        objdistrito.setEstado(false);
        DistritoEntity distrito = repositorio.save(objdistrito);
        assertNotNull(distrito);
        System.out.println("@Test -> EliminarDistrito");
    }
}
