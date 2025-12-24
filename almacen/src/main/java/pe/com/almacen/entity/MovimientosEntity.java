package pe.com.almacen.entity;

import jakarta.persistence.*;
import java.io.Serializable;
import java.time.LocalDateTime;
import lombok.*;

@Entity
@Table(name = "movimientos")
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class MovimientosEntity implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_movimiento")
    private Integer idMovimiento;

    @ManyToOne
    @JoinColumn(name = "id_tipo_movimiento", nullable = false)
    private TipoMovimientoEntity tipoMovimiento;

    @Column(name = "fecha")
    private LocalDateTime fecha;

    @ManyToOne
    @JoinColumn(name = "id_producto", nullable = false)
    private ProductosEntity producto;

    @Column(name = "cantidad", nullable = false)
    private Integer cantidad;

    @ManyToOne
    @JoinColumn(name = "id_almacen_origen")
    private AlmacenesEntity almacenOrigen;

    @ManyToOne
    @JoinColumn(name = "id_almacen_destino")
    private AlmacenesEntity almacenDestino;

    @ManyToOne
    @JoinColumn(name = "id_empleado", nullable = false)
    private EmpleadosEntity empleado;

    @ManyToOne
    @JoinColumn(name = "id_proveedor")
    private ProveedoresEntity proveedor;

    @Column(name = "referencia", length = 100)
    private String referencia;

    @PrePersist
    protected void onCreate() {
        this.fecha = LocalDateTime.now();
    }
}
