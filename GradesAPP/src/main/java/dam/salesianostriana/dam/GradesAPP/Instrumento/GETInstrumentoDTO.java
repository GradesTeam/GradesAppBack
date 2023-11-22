package dam.salesianostriana.dam.GradesAPP.Instrumento;

import dam.salesianostriana.dam.GradesAPP.Instrumento.model.Instrumento;
import lombok.Builder;

import java.time.LocalDateTime;
import java.util.UUID;

@Builder
public record GETInstrumentoDTO(
        UUID id,
        String nombre,
        LocalDateTime fecha
) {
    public static GETInstrumentoDTO of(Instrumento i){
        return GETInstrumentoDTO.builder()
                .id(i.getId())
                .nombre(i.getNombre())
                .fecha(i.getFecha())
                .build();
    }
}
