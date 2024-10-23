package org.example.vehiculosData.services;

import org.example.vehiculosData.models.*;
import org.example.vehiculosData.repositories.PruebaRepository;
import org.example.vehiculosData.repositories.InteresadoRepository;
import org.example.vehiculosData.repositories.VehiculoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.LocalDateTime;

@Service
public class PruebaService {

    @Autowired
    private InteresadoRepository interesadoRepository; // Repositorio para interesados
    @Autowired
    private VehiculoRepository vehiculoRepository; // Repositorio para vehículos
    @Autowired
    private PruebaRepository pruebaRepository; // Repositorio para pruebas

    public Prueba crearPrueba(Long interesadoId, Long vehiculoId, LocalDateTime fechaPrueba) {
        Interesados interesado = interesadoRepository.findById(interesadoId)
                .orElseThrow(() -> new RuntimeException("Interesado no encontrado"));

        // Validar licencia
        if (interesado.isRestringido()) {
            throw new RuntimeException("El interesado está restringido para probar vehículos.");
        }

        if (interesado.getFechaVencimientoLicencia().isBefore(LocalDate.now())) {
            throw new RuntimeException("La licencia del interesado está vencida.");
        }

        // Verificar si el vehículo ya está en uso
        if (pruebaRepository.existsByVehiculoAndFechaPrueba(vehiculoId, fechaPrueba)) {
            throw new RuntimeException("El vehículo ya está siendo probado en esa fecha.");
        }

        // Crear y guardar la nueva prueba
        Prueba nuevaPrueba = new Prueba();
        nuevaPrueba.setVehiculo(vehiculoRepository.findById(vehiculoId)
                .orElseThrow(() -> new RuntimeException("Vehículo no encontrado")));
        nuevaPrueba.setInteresados(interesado);
        nuevaPrueba.setFechaPrueba(fechaPrueba);
        nuevaPrueba.setFechaInicio(fechaPrueba); // Asigna la fecha de inicio
        nuevaPrueba.setFechaFin(fechaPrueba.plusHours(1)); // Ejemplo: dura 1 hora

        return pruebaRepository.save(nuevaPrueba);
    }
}
