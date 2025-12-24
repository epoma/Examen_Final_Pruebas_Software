/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package pe.com.tiendita.entity;

import jakarta.persistence.*;
import java.io.Serializable;
import lombok.*;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Entity(name = "UsuarioRolEntity")
@Table(name="t_usuariorol")
public class UsuarioRolEntity implements Serializable{
    private static final long serialVersionUID=1L;
    
    @Id
    @Column(name = "codusurol")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long codigo;
    
    @ManyToOne
    @JoinColumn(name = "codusu", nullable = false)
    private UsuarioEntity usuario;

    @ManyToOne
    @JoinColumn(name = "codrol", nullable = false)
    private RolEntity rol;
    
    @Column(name = "estusurol")
    private boolean estado;
}
