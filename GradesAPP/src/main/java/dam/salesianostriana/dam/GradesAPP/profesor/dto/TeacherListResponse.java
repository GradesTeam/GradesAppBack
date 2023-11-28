package dam.salesianostriana.dam.GradesAPP.profesor.dto;

import dam.salesianostriana.dam.GradesAPP.profesor.model.Profesor;
import lombok.Builder;

import java.time.LocalDate;


public record TeacherListResponse(String nombre, String titulacion) {

    public static TeacherListResponse of (Profesor profesor){
        return new TeacherListResponse(
                profesor.getNombre(),
                profesor.getTitulacion()
        );
    }
}
