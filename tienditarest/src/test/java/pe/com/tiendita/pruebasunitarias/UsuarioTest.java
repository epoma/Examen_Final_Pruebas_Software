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
import pe.com.tiendita.entity.UsuarioEntity;
import pe.com.tiendita.repository.UsuarioRepository;



@DataJpaTest
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
public class UsuarioTest {
    private UsuarioEntity objusuario;

    //inyeccion de dependencia
    @Autowired
    private UsuarioRepository repositorio;

    @BeforeEach
    public void Inicio() {
        objusuario = new UsuarioEntity();
        System.out.println("@BeforeEach -> Inicio");
    }

    @AfterEach
    private void Final() {
        objusuario = null;
        System.out.println("AfterEach->Final");
    }

    //pruebas al repositorio
    @Test
    public void MostrarUsuarioTest() {
        List<UsuarioEntity> listausuario = repositorio.findAllCustom();
        assertNotNull(listausuario);
        System.out.println("@Test -> MostrarUsuarioTest");
    }

    @Test
    public void MostrarUsuarioTodoTest() {
        List<UsuarioEntity> listausuario = repositorio.findAll();
        assertNotNull(listausuario);
        System.out.println("@Test -> MostrarUsuarioTodoTest");
    }

    @Test
    public void BuscarUsuarioXCodigoTest() {
        long id = 2;
        //UsuarioEntity listacategoria=repositorio.findById(id).get();
        Optional<UsuarioEntity> listausuario = repositorio.findById(id);
        assertNotNull(listausuario);
        System.out.println("@Test ->BuscarUsuarioXCodigoTest");
    }

    @Test
    //Rollback -> sirve para controlar si los cambios se mantienen o no
    @Rollback(false)
    public void RegistrarUsuario() {
        objusuario.setNombre("Prueba Unitaria usuario 2");
        objusuario.setClave("Prueba Unitaria clave");
        objusuario.setEstado(true);
        UsuarioEntity categoria = repositorio.save(objusuario);
        assertNotNull(categoria);
        System.out.println("@Test ->RegistrarUsuario");
    }

    @Test
    @Rollback(false)
    public void ActualizarUsuario() {
        objusuario.setCodigo(3L);
        objusuario.setNombre("Prueba actualizacion usuario");
        objusuario.setClave("Prueba actualizacion usuario");
        objusuario.setEstado(true);
        UsuarioEntity categoria = repositorio.save(objusuario);
        assertNotNull(categoria);
        System.out.println("@Test -> ActualizarUsuario");
    }

    @Test
    @Rollback(false)
    public void EliminarUsuario() {
        objusuario.setCodigo(3L);
        objusuario.setNombre("Prueba actualizacion usuario");
        objusuario.setClave("prueba actualizacion usuario");
        objusuario.setEstado(false);
        UsuarioEntity usuario = repositorio.save(objusuario);
        assertNotNull(usuario);
        System.out.println("@Test -> EliminarUsuario");
    }
}
