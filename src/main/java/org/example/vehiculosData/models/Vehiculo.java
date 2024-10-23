package org.example.vehiculosData.models;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity(name = "Vehiculos")
@Data
@AllArgsConstructor
@NoArgsConstructor(force = true)
public class Vehiculo {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String marca;
    private String modelo;
    private String patente;
    private Double kilometraje;
}
