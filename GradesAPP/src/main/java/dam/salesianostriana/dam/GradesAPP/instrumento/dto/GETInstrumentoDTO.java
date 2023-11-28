package dam.salesianostriana.dam.GradesAPP.instrumento.dto;

import com.fasterxml.jackson.annotation.JsonView;
import dam.salesianostriana.dam.GradesAPP.instrumento.jsonViews.InstrumentoViews;
import dam.salesianostriana.dam.GradesAPP.instrumento.model.Instrumento;
import dam.salesianostriana.dam.GradesAPP.referenteEvaluacion.DTO.GETReferenteDTO;
import lombok.Builder;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;
import java.util.UUID;

@Builder
public record GETInstrumentoDTO(
        @JsonView({InstrumentoViews.InstrumentoDetails.class, InstrumentoViews.InstrumentoList.class})
        UUID id,
        @JsonView({InstrumentoViews.InstrumentoDetails.class, InstrumentoViews.InstrumentoList.class})
        String nombre,
        @JsonView({InstrumentoViews.InstrumentoDetails.class, InstrumentoViews.InstrumentoList.class})
        LocalDate fecha,
        @JsonView(InstrumentoViews.InstrumentoDetails.class)
        List<GETReferenteDTO> referentes
) {
    public static GETInstrumentoDTO of(Instrumento i){
        return GETInstrumentoDTO.builder()
                .id(i.getId())
                .nombre(i.getNombre())
                .fecha(i.getFecha())
                .build();
    }
    public static GETInstrumentoDTO ofDetails(Instrumento i){
        return GETInstrumentoDTO.builder()
                .id(i.getId())
                .nombre(i.getNombre())
                .fecha(i.getFecha())
                .referentes(i.getReferentes().stream().map(GETReferenteDTO::of).toList())
                .build();
    }
}
