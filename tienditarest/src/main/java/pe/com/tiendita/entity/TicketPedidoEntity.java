/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package pe.com.tiendita.entity;

import jakarta.persistence.*;
import java.io.Serializable;
import lombok.*;
import java.time.LocalDateTime;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Entity(name = "TicketPedidoEntity")
@Table(name="t_ticketpedido")
public class TicketPedidoEntity implements Serializable{
    private static final long serialVersionUID=1L;

    @Id
    @Column(name = "nrotic")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long codigo;
    
    @Column(name = "fectic")
    private LocalDateTime fecha;
    
    @Column(name = "esttic")
    private boolean estado;
    
    @ManyToOne
    @JoinColumn(name = "codcli", nullable = false)
    private ClienteEntity cliente;
    
    @ManyToOne
    @JoinColumn(name = "codusu", nullable = false)
    private UsuarioEntity usuario;
}
