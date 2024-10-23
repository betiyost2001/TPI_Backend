package org.example.vehiculosData.models;

import lombok.Data;
import lombok.NoArgsConstructor;
import jakarta.persistence.*;
import org.antlr.v4.runtime.misc.NotNull;

import java.time.LocalDate;

@Data
@NoArgsConstructor
@Entity
@Table(name = "Interesados")
public class Interesados {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotNull
    private String tipoDocumento;

    @NotNull
    private Long documento;

    @NotNull
    private String nombre;

    @NotNull
    private String apellido;

    @NotNull
    private String residencia;

    @NotNull
    private Boolean restringido;

    @NotNull
    private String nroLicencia;


    @NotNull
    @Temporal(TemporalType.DATE)
    private LocalDate fechaVencimientoLicencia;

    @Temporal(TemporalType.DATE)
    private LocalDate licenciaValidaHasta;

    public boolean isRestringido() {
        return restringido;
    }
}
