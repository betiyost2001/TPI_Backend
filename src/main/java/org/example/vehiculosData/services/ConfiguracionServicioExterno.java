//conexión al servicio externo
package org.example.vehiculosData.services;

import org.example.vehiculosData.models.Configuracion;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class ConfiguracionServicioExterno {

    private final RestTemplate restTemplate;

    @Autowired
    public ConfiguracionServicioExterno(RestTemplate restTemplate) {
        this.restTemplate = restTemplate;
    }

    public Configuracion obtenerConfiguracion() {
        String url = "http://api.servicioexterno.com/configuracion";  // Cambia esto por la URL real
        return restTemplate.getForObject(url, Configuracion.class);
    }
}
