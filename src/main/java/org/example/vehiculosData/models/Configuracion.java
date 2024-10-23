// clase que represente la respuesta del servicio externo
package org.example.vehiculosData.models;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Configuracion {
    private double latitudAgencia;
    private double longitudAgencia;
    private double radioMaximo;
    private List<ZonaPeligrosa> zonasPeligrosas;
}

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ZonaPeligrosa {
    private double latitudNoroeste;
    private double longitudNoroeste;
    private double latitudSureste;
    private double longitudSureste;
}
