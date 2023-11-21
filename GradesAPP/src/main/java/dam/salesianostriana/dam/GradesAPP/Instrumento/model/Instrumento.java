package dam.salesianostriana.dam.GradesAPP.Instrumento.model;

import dam.salesianostriana.dam.GradesAPP.Asignatura.model.Asignatura;
import dam.salesianostriana.dam.GradesAPP.ReferenteEvaluacion.model.ReferenteEvaluacion;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.Parameter;

import java.time.LocalDateTime;
import java.util.HashSet;
import java.util.Set;
import java.util.UUID;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Data
@Builder
public class Instrumento {
    @Id
    @GeneratedValue(generator = "UUID")
    @GenericGenerator(
            name = "UUID",
            strategy = "org.hibernate.id.UUIDGenerator",
            parameters = {
                    @Parameter(
                            name = "uuid_gen_strategy_clas",
                            value = "org.hibernate.id.uuid.CurstomVersionOneStrategy"
                    )
            }
    )
    private UUID id;

    private String nombre;

    private LocalDateTime fecha;

    private String contenidos;

    @ManyToOne
    private Asignatura asignatura;

    @ManyToMany(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    @ElementCollection(fetch = FetchType.EAGER)
    private Set<ReferenteEvaluacion> referentes = new HashSet<>();
}
