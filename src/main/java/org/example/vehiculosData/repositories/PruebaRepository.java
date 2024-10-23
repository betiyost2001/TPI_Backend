package org.example.vehiculosData.repositories;

import org.example.vehiculosData.models.Prueba;
import org.springframework.data.repository.CrudRepository;

import java.time.LocalDateTime;

public interface PruebaRepository extends CrudRepository<Prueba, Long> {
    boolean existsByVehiculoAndFechaPrueba(Long vehiculoId, LocalDateTime fechaPrueba);
}
