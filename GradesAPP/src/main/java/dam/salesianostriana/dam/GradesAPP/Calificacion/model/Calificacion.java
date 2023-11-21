package dam.salesianostriana.dam.GradesAPP.Calificacion.model;


import dam.salesianostriana.dam.GradesAPP.Alumno.model.Alumno;
import dam.salesianostriana.dam.GradesAPP.Instrumento.model.Instrumento;
import dam.salesianostriana.dam.GradesAPP.ReferenteEvaluacion.model.ReferenteEvaluacion;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.Parameter;

import java.util.UUID;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Data
@Builder
public class Calificacion {
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

    @ManyToOne
    private Instrumento instrumento;

    @ManyToOne
    private ReferenteEvaluacion referente;

    @ManyToOne
    private Alumno alumno;

    private double calificacion;
}
