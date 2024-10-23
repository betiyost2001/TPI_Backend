package org.example.vehiculosData.repositories;

import org.example.vehiculosData.models.Vehiculo;
import org.springframework.data.repository.CrudRepository;

public interface VehiculoRepository extends CrudRepository<Vehiculo, Long> {
    Vehiculo findByPatente(String patente);
}
