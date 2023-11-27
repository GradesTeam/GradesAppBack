package dam.salesianostriana.dam.GradesAPP.calificacion.DTO;

import dam.salesianostriana.dam.GradesAPP.calificacion.model.Calificacion;
import lombok.Builder;

import java.util.UUID;

@Builder
public record GETCalificaciónDTO(
        UUID id,
        double calificacion
) {
    public static GETCalificaciónDTO of(Calificacion calificacion){
        return GETCalificaciónDTO.builder()
                .id(calificacion.getId())
                .calificacion(calificacion.getCalificacion())
                .build();
    }
}
