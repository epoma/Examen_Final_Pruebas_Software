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
@Entity(name = "DetallePedidoEntity")
@Table(name = "t_detallepedido")
public class DetallePedidoEntity implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @Column(name = "nrodet")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long codigo;
    
    @ManyToOne
    @JoinColumn(name = "nrotic", nullable = false)
    private TicketPedidoEntity ticketpedido;

    @ManyToOne
    @JoinColumn(name = "codpro", nullable = false)
    private ProductoEntity producto;
    
    @Column(name = "cantic")
    private int cantidad;

    @Column(name = "pretic")
    private double  precio;

    
}
