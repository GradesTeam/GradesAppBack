package dam.salesianostriana.dam.GradesAPP;

import dam.salesianostriana.dam.GradesAPP.alumno.model.Alumno;
import dam.salesianostriana.dam.GradesAPP.user.model.User;
import dam.salesianostriana.dam.GradesAPP.user.model.UserRole;
import dam.salesianostriana.dam.GradesAPP.user.service.UserService;
import jakarta.annotation.PostConstruct;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Set;

@Component
@RequiredArgsConstructor
public class InitData {

    private final UserService userService;

    @PostConstruct
    public void initDada(){



        User u = Alumno.builder()
                .telefono("666952522")
                .fechaNacimiento(LocalDate.of(2004,6,11))
                .email("jimenezalejandro505@gmail.com")
                .nombre("Alejandro")
                .apellidos("Jimenez")
                .roles(Set.of(UserRole.USER))
                .password("1234")
                .username("jimenez.feale23")
                .build();


        userService.save(u);


    }
}