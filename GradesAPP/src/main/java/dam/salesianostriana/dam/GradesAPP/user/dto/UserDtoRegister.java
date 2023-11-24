package dam.salesianostriana.dam.GradesAPP.user.dto;

import dam.salesianostriana.dam.GradesAPP.user.model.UserRole;
import jakarta.validation.constraints.NotEmpty;
import lombok.Builder;
import lombok.Value;

import java.time.LocalDate;
import java.util.UUID;

@Value
@Builder
public class UserDtoRegister {

    private UUID id;

    @NotEmpty
    private String username;

    @NotEmpty
    private String nombre;

    @NotEmpty
    private String apellidos;

    private UserRole rol;

    @NotEmpty
    private String password;

    private LocalDate fechaNacimiento;
}
