package dam.salesianostriana.dam.GradesAPP.alumno.dto;

import dam.salesianostriana.dam.GradesAPP.validation.annotation.PasswordLength;
import jakarta.validation.constraints.Email;

public record EditAlumnoDTO(
        @Email
        String email,
        String telefono,
        String username,
        @PasswordLength
        String password
){

}
