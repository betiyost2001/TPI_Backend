package org.example.vehiculosData.models;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity(name = "Notificaciones")
@Data
@AllArgsConstructor
@NoArgsConstructor(force = true)
public class Notificacion {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "prueba_id", nullable = false)
    private Prueba prueba;

    private String mensaje;
    private String tipo;  // Ejemplo: "Radio excedido", "Zona peligrosa"
}
