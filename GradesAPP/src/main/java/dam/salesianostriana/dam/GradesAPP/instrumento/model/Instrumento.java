package dam.salesianostriana.dam.GradesAPP.instrumento.model;

import dam.salesianostriana.dam.GradesAPP.asignatura.model.Asignatura;
import dam.salesianostriana.dam.GradesAPP.referenteEvaluacion.model.ReferenteEvaluacion;
import jakarta.persistence.*;
import lombok.*;
import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.Parameter;

import java.time.LocalDateTime;
import java.util.HashSet;
import java.util.Set;
import java.util.UUID;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
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
    @Builder.Default
    private Set<ReferenteEvaluacion> referentes = new HashSet<>();

}
