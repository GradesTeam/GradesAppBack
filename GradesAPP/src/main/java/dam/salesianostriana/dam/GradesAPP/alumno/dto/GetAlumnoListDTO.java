package dam.salesianostriana.dam.GradesAPP.alumno.dto;

import dam.salesianostriana.dam.GradesAPP.alumno.model.Alumno;

import java.time.LocalDate;

public record GetAlumnoListDTO(
        String nombreApellidos,
        LocalDate fechaNacimiento
) {
    public static GetAlumnoListDTO of(Alumno a){
        return new GetAlumnoListDTO(
                a.getNombre() + " " + a.getApellidos(),
                a.getFechaNacimiento()
        );
    }
}
