package org.example.vehiculosData.controllers;

import org.example.vehiculosData.models.Vehiculo;
import org.example.vehiculosData.services.VehiculoService;
import org.example.vehiculosData.services.ServiceException;

import java.util.List;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
@Slf4j
@RestController
@RequestMapping("/api/vehiculos")
public class VehiculoController {
    private final VehiculoService service;

    @Autowired
    public VehiculoController(VehiculoService service) {
        this.service = service;
    }

    @GetMapping
    public ResponseEntity<Iterable<Vehiculo>> getAllVehiculos() {
        return ResponseEntity.ok(service.getAll());
    }

    @GetMapping("/{id}")
    public ResponseEntity<Vehiculo> getVehiculoById(@PathVariable Long id) {
        try {
            Vehiculo vehiculo = service.getById(id);
            return ResponseEntity.ok(vehiculo);
        } catch (ServiceException e) {
            log.error("Error al obtener el vehículo con ID: {}", id, e);
            return ResponseEntity.notFound().build();
        }
    }
}

