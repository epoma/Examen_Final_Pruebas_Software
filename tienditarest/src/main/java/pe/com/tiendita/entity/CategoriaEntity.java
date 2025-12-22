package pe.com.tiendita.entity;

import jakarta.persistence.*;
import java.io.Serializable;
import lombok.*;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Entity(name = "CategoriaEntity")
@Table(name="t_categoria")
public class CategoriaEntity implements Serializable{
    private static final long serialVersionUID=1L;
    
    @Id
    @Column(name = "codcat")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long codigo;
    
    @Column(name = "nomcat")
    private String nombre;
    
    @Column(name = "estcat")
    private boolean estado;
    
    
}
