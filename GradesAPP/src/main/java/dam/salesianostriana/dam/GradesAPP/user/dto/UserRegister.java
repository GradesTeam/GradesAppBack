package dam.salesianostriana.dam.GradesAPP.user.dto;

import com.fasterxml.jackson.annotation.JsonView;
import dam.salesianostriana.dam.GradesAPP.user.model.User;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import lombok.*;
import lombok.experimental.SuperBuilder;

import java.time.LocalDate;
import java.util.UUID;

@Data
@NoArgsConstructor
@AllArgsConstructor
@SuperBuilder
public class UserRegister {

    protected UUID id;

    @NotNull
    @JsonView({UserResponse.class})
    @NotEmpty(message = )
    protected String username;

    @NotNull
    @NotEmpty
    @Email
    private String email;

    @NotNull
    @JsonView({UserResponse.class})
    @NotEmpty
    private String password;

    @NotNull
    @NotEmpty
    private String repeatPassword;

    private LocalDate fechaNacimiento;

    public static UserRegister fromUser(User user) {

        return UserRegister.builder()
                .id(user.getId())
                .username(user.getUsername())
                .email(user.getEmail())
                .password(user.getPassword())
                .repeatPassword(user.getPassword())
                .build();
    }

    public static class UserResponse {}
}
