package org.example.vehiculosData.controllers;

import org.example.vehiculosData.models.Interesados;
import org.example.vehiculosData.services.InteresadoService;
import org.example.vehiculosData.services.ServiceException;

import java.util.List;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@Slf4j
@RestController
@RequestMapping("/api/clientes")
public class InteresadosController {
    private final InteresadoService service;

    @Autowired
    public InteresadosController(InteresadoService service) {
        this.service = service;
    }

    @GetMapping
    public ResponseEntity<Iterable<Interesados>> getAllClientes() {
        return ResponseEntity.ok(service.getAll());
    }

    @GetMapping("/{id}")
    public ResponseEntity<Interesados> getClienteById(@PathVariable Long id) {
        try {
            Interesados found = service.getById(id);
            return ResponseEntity.ok(found);
        } catch (ServiceException e) {
            return ResponseEntity.notFound()
                    .header("Error-Message", e.getMessage())
                    .build();
        }
    }

    @GetMapping("/nombre/{nombre}")
    public ResponseEntity<List<Interesados>> getClienteByNombre(@PathVariable String nombre) {
        return ResponseEntity.ok(service.getByNombre(nombre));
    }

    @PostMapping
    public ResponseEntity<Interesados> createCliente(@RequestBody Interesados cliente) {
        return ResponseEntity.ok(service.create(cliente));
    }

    @PutMapping("/{id}")
    public ResponseEntity<Interesados> updateCliente(@PathVariable Long id, @RequestBody Interesados clienteDetails) {
        try {
            Interesados found = service.getById(id);
            found.setDocumento(clienteDetails.getDocumento());
            found.setNombre(clienteDetails.getNombre());
            found.setApellido(clienteDetails.getApellido());
            found.setLicenciaValidaHasta(clienteDetails.getLicenciaValidaHasta());
            return ResponseEntity.ok(service.update(id, found));
        } catch (ServiceException e) {
            return ResponseEntity.notFound()
                    .header("Error-Message", e.getMessage())
                    .build();
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Interesados> deleteCliente(@PathVariable Long id) {
        try {
            Interesados found = service.getById(id);
            service.delete(id);
            return ResponseEntity.ok(found);
        } catch (ServiceException e) {
            return ResponseEntity.notFound()
                    .header("Error-Message", e.getMessage())
                    .build();
        }
    }
}
