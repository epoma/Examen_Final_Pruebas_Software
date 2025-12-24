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
@Entity(name = "UsuarioEntity")
@Table(name="t_usuario")
public class UsuarioEntity implements Serializable{
    private static final long serialVersionUID=1L;
    
    @Id
    @Column(name = "codusu")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long codigo;
    
    @Column(name = "nomusu")
    private String nombre;
    
    @Column(name = "clausu")
    private String clave;
    
    @Column(name = "estusu")
    private boolean estado;
    
}
