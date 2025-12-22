/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package pe.com.tiendita.pruebasunitarias;
import java.util.Optional;
import java.util.List;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.Assertions;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.data.jpa.test.autoconfigure.DataJpaTest;
import org.springframework.boot.jdbc.test.autoconfigure.AutoConfigureTestDatabase;
import pe.com.tiendita.entity.CategoriaEntity;
import pe.com.tiendita.repository.CategoriaRepository;
import org.springframework.test.annotation.Rollback;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.AfterEach;

@DataJpaTest
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
public class CategoriaTest {
    private CategoriaEntity objcategoria;

    //inyeccion de dependencia
    @Autowired
    private CategoriaRepository repositorio;

    @BeforeEach
    public void Inicio() {
        objcategoria = new CategoriaEntity();
        System.out.println("@BeforeEach -> Inicio");
    }

    @AfterEach
    private void Final() {
        objcategoria = null;
        System.out.println("AfterEach->Final");
    }

    //pruebas al repositorio
    @Test
    public void MostrarCategoriaTest() {
        List<CategoriaEntity> listacategoria = repositorio.findAllCustom();
        assertNotNull(listacategoria);
        System.out.println("@Test -> MostrarCategoriaTest");
    }

    @Test
    public void MostrarCategoriaTodoTest() {
        List<CategoriaEntity> listacategoria = repositorio.findAll();
        assertNotNull(listacategoria);
        System.out.println("@Test -> MostrarCategoriaTodoTest");
    }

    @Test
    public void BuscarCategoriaXCodigoTest() {
        long id = 2;
        //CategoriaEntity listacategoria=repositorio.findById(id).get();
        Optional<CategoriaEntity> listacategoria = repositorio.findById(id);
        assertNotNull(listacategoria);
        System.out.println("@Test ->BuscarCategoriaXCodigoTest");
    }

    @Test
    //Rollback -> sirve para controlar si los cambios se mantienen o no
    @Rollback(false)
    public void RegistrarCategoria() {
        objcategoria.setNombre("Prueba Unitaria Categoria 2");
        objcategoria.setEstado(true);
        CategoriaEntity categoria = repositorio.save(objcategoria);
        assertNotNull(categoria);
        System.out.println("@Test ->RegistrarCategoria");
    }

    @Test
    @Rollback(false)
    public void ActualizarCategoria() {
        objcategoria.setCodigo(3L);
        objcategoria.setNombre("Prueba actualizacion Categoria");
        objcategoria.setEstado(true);
        CategoriaEntity categoria = repositorio.save(objcategoria);
        assertNotNull(categoria);
        System.out.println("@Test -> ActualizarCategoria");
    }

    @Test
    @Rollback(false)
    public void EliminarCategoria() {
        objcategoria.setCodigo(3L);
        objcategoria.setNombre("Prueba actualizacion Categoria");
        objcategoria.setEstado(false);
        CategoriaEntity categoria = repositorio.save(objcategoria);
        assertNotNull(categoria);
        System.out.println("@Test -> EliminarCategoria");
    }
    
}
