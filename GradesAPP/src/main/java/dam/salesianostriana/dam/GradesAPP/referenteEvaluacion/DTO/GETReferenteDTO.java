package dam.salesianostriana.dam.GradesAPP.referenteEvaluacion.DTO;

import dam.salesianostriana.dam.GradesAPP.referenteEvaluacion.model.ReferenteEvaluacion;
import lombok.Builder;

@Builder
public record GETReferenteDTO(
        String codReferente,
        String descripcion
) {
    public static GETReferenteDTO of(ReferenteEvaluacion ref){
        return GETReferenteDTO.builder()
                .codReferente(ref.getCodReferente())
                .descripcion(ref.getDescripcion())
                .build();
    }

}
