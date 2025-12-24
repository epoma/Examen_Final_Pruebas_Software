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
@Entity(name = "RolEntity")
@Table(name="t_rol")
public class RolEntity implements Serializable{
    private static final long serialVersionUID=1L;
    
    @Id
    @Column(name = "codrol")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long codigo;
    
    @Column(name = "nomrol")
    private String nombre;
    
    @Column(name = "estrol")
    private boolean estado;
    
}
