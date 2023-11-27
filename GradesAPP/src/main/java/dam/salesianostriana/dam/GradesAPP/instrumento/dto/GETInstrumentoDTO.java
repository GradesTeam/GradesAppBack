package dam.salesianostriana.dam.GradesAPP.instrumento.dto;

import dam.salesianostriana.dam.GradesAPP.instrumento.model.Instrumento;
import lombok.Builder;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.UUID;

@Builder
public record GETInstrumentoDTO(
        UUID id,
        String nombre,
        LocalDate fecha
) {
    public static GETInstrumentoDTO of(Instrumento i){
        return GETInstrumentoDTO.builder()
                .id(i.getId())
                .nombre(i.getNombre())
                .fecha(i.getFecha())
                .build();
    }
}
