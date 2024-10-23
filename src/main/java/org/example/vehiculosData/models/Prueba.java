package org.example.vehiculosData.models;

import jakarta.persistence.*;
import java.time.LocalDateTime;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity(name = "Pruebas")
@Data
@AllArgsConstructor
@NoArgsConstructor(force = true)
public class Prueba {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "interesado_id", nullable = false)
    private Interesados interesados;

    @ManyToOne
    @JoinColumn(name = "vehiculo_id", nullable = false)
    private Vehiculo vehiculo;

    private LocalDateTime fechaInicio;
    private LocalDateTime fechaFin;
    private String comentario;
    private LocalDateTime fechaPrueba;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Interesados getInteresados() {
        return interesados;
    }

    public void setInteresados(Interesados interesados) {
        this.interesados = interesados;
    }

    public Vehiculo getVehiculo() {
        return vehiculo;
    }

    public void setVehiculo(Vehiculo vehiculo) {
        this.vehiculo = vehiculo;
    }

    public LocalDateTime getFechaInicio() {
        return fechaInicio;
    }

    public void setFechaInicio(LocalDateTime fechaInicio) {
        this.fechaInicio = fechaInicio;
    }

    public LocalDateTime getFechaFin() {
        return fechaFin;
    }

    public void setFechaFin(LocalDateTime fechaFin) {
        this.fechaFin = fechaFin;
    }

    public String getComentario() {
        return comentario;
    }

    public void setComentario(String comentario) {
        this.comentario = comentario;
    }

    public LocalDateTime getFechaPrueba() {
        return fechaPrueba;
    }

    public void setFechaPrueba(LocalDateTime fechaPrueba) {
        this.fechaPrueba = fechaPrueba;
    }
}
