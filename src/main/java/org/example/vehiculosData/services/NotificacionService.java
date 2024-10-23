package org.example.vehiculosData.services;

import org.example.vehiculosData.models.Notificacion;
import org.example.vehiculosData.repositories.NotificacionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class NotificacionService {
    private final NotificacionRepository repository;

    @Autowired
    public NotificacionService(NotificacionRepository repository) {
        this.repository = repository;
    }

    public List<Notificacion> getAll() {
        return repository.findAll();
    }

    public Notificacion create(Notificacion notificacion) {
        return repository.save(notificacion);
    }
}
