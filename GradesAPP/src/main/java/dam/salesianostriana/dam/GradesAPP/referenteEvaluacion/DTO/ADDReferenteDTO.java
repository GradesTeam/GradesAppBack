package dam.salesianostriana.dam.GradesAPP.referenteEvaluacion.DTO;

import dam.salesianostriana.dam.GradesAPP.asignatura.model.Asignatura;
import dam.salesianostriana.dam.GradesAPP.referenteEvaluacion.model.ReferenteEvaluacion;
import dam.salesianostriana.dam.GradesAPP.validation.annotation.UniqueCodReferente;
import jakarta.persistence.UniqueConstraint;
import jakarta.validation.constraints.NotEmpty;
import lombok.Builder;

@Builder
public record ADDReferenteDTO(
        @NotEmpty(message = "{ADDreferenteDTO.codReferente.notempty}")
        @UniqueCodReferente
        String codReferente,
        @NotEmpty(message = "{ADDreferenteDTO.descrpcion.notempty}")
        String descripcion

) {
    public static ReferenteEvaluacion from(ADDReferenteDTO referenteDTO, Asignatura as){
        return ReferenteEvaluacion.builder()
                .descripcion(referenteDTO.descripcion())
                .codReferente(referenteDTO.codReferente())
                .asignatura(as)
                .build();
    }
}
