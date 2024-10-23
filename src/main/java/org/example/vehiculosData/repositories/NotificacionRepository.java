package org.example.vehiculosData.repositories;

import org.example.vehiculosData.models.Notificacion;
import org.springframework.data.jpa.repository.JpaRepository;

public interface NotificacionRepository extends JpaRepository<Notificacion, Long> {
}
