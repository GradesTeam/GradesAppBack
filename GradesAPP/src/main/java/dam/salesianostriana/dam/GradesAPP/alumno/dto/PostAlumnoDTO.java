package dam.salesianostriana.dam.GradesAPP.alumno.dto;

import dam.salesianostriana.dam.GradesAPP.alumno.model.Alumno;
import dam.salesianostriana.dam.GradesAPP.validation.validator.LocalDateNotNull;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;

import java.time.LocalDate;

public record PostAlumnoDTO(

        @NotEmpty @NotNull
        String nombre,
        @NotEmpty @NotNull
        String apellidos,
        @LocalDateNotNull
        LocalDate fechaNacimiento,
        @NotEmpty @NotNull
        String email,
        @NotEmpty @NotNull
        String telefono,
        @NotEmpty @NotNull
        String username,
        @NotEmpty @NotNull
        String password

) {
    public static Alumno from(PostAlumnoDTO a){
        return Alumno.builder()
                .nombre(a.nombre)
                .apellidos(a.apellidos)
                .fechaNacimiento(a.fechaNacimiento)
                .email(a.email)
                .telefono(a.telefono)
                .username(a.username)
                .password(a.password)
                .build();
    }

}
