package org.example.vehiculosData.controllers;

import org.example.vehiculosData.models.Prueba;
import org.example.vehiculosData.services.PruebaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;

@RestController
@RequestMapping("/api/pruebas")
public class PruebaController {

    @Autowired
    private PruebaService pruebaService;

    @PostMapping
    public ResponseEntity<Prueba> crearPrueba(@RequestParam Long interesadoId, @RequestParam Long vehiculoId, @RequestParam LocalDateTime fechaPrueba) {
        Prueba nuevaPrueba = pruebaService.crearPrueba(interesadoId, vehiculoId, fechaPrueba);
        return ResponseEntity.ok(nuevaPrueba);
    }
}

