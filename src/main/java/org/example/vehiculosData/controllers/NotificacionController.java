package org.example.vehiculosData.controllers;

import org.example.vehiculosData.models.Notificacion;
import org.example.vehiculosData.services.NotificacionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/notificaciones")
public class NotificacionController {
    private final NotificacionService service;

    @Autowired
    public NotificacionController(NotificacionService service) {
        this.service = service;
    }

    @GetMapping
    public ResponseEntity<List<Notificacion>> getAllNotificaciones() {
        return ResponseEntity.ok(service.getAll());
    }

    @PostMapping
    public ResponseEntity<Notificacion> createNotificacion(@RequestBody Notificacion notificacion) {
        return ResponseEntity.ok(service.create(notificacion));
    }
}
