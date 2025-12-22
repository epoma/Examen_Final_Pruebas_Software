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
@Entity(name = "ClienteEntity")
@Table(name="t_cliente")
public class ClienteEntity implements Serializable{
    private static final long serialVersionUID=1L;
    
    @Id
    @Column(name = "codcli")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long codigo;
    
    @Column(name = "nomcli")
    private String nombre;
    
    @Column(name = "apepcli")
    private String apellido;
    
    @Column(name = "apemcli")
    private String apellidom;
    
    @Column(name = "dnicli")
    private String dni;
    
    @Column(name = "dircli")
    private String direccion;
    
    @Column(name = "telcli")
    private String telefono;
    
    @Column(name = "celcli")
    private String celular;
    
    @Column(name = "corcli")
    private String correo;
    
    @Column(name = "sexcli")
    private String sexo;
    
    @Column(name = "estcli")
    private boolean estado;
    
    @ManyToOne
    @JoinColumn(name = "coddis", nullable = false)
    private DistritoEntity distrito;
}
