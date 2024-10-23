package org.example.vehiculosData.repositories;

import org.example.vehiculosData.models.Interesados;
import java.util.List;
import org.springframework.data.repository.CrudRepository;

public interface InteresadoRepository extends CrudRepository<Interesados, Long> {
    List<Interesados> findByNombre(String nombre);
}
