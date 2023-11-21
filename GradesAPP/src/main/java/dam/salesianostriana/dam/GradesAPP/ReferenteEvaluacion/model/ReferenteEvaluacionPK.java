package dam.salesianostriana.dam.GradesAPP.ReferenteEvaluacion.model;

import dam.salesianostriana.dam.GradesAPP.Asignatura.model.Asignatura;
import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.UUID;

@Data
@AllArgsConstructor
public class ReferenteEvaluacionPK {
    private Asignatura asignatura;

    private UUID codReferente;

    private ReferenteEvaluacionPK() {}
}
