//permite obtener la configuracion del servicio externo
package org.example.vehiculosData.controllers;

import org.example.vehiculosData.models.Configuracion;
import org.example.vehiculosData.services.ConfiguracionServicioExterno;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/configuracion")
public class ConfiguracionController {

    private final ConfiguracionServicioExterno configuracionServicioExterno;

    @Autowired
    public ConfiguracionController(ConfiguracionServicioExterno configuracionServicioExterno) {
        this.configuracionServicioExterno = configuracionServicioExterno;
    }

    @GetMapping
    public ResponseEntity<Configuracion> obtenerConfiguracion() {
        Configuracion configuracion = configuracionServicioExterno.obtenerConfiguracion();
        return ResponseEntity.ok(configuracion);
    }
}
