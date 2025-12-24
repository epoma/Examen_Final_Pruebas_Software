package pe.com.tiendita.entity;

import jakarta.persistence.Column;
import jakarta.persistence.*;
import lombok.*;
import java.io.Serializable;


@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Entity(name = "ProductoEntity")
@Table(name="t_producto")
public class ProductoEntity implements Serializable{
    private static final long serialVersionUID=1L;
    @Id
    @Column(name = "codpro")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long codigo;
    
    @Column(name = "nompro")
    private String nombre;
    
    @Column(name = "preproc")
    private double preciocompra;
    
    @Column(name = "preprov")
    private double precioventa;
    
    @Column(name = "canpro")
    private double cantidad;
    
    @Column(name = "estpro")
    private boolean estado;
    
    @ManyToOne
    @JoinColumn(name = "codcat", nullable = false)
    private CategoriaEntity categoria;
    
}
