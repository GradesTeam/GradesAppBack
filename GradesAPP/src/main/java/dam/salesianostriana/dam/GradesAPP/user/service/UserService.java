package dam.salesianostriana.dam.GradesAPP.user.service;

import dam.salesianostriana.dam.GradesAPP.alumno.model.Alumno;
import dam.salesianostriana.dam.GradesAPP.user.dto.UserDtoRegister;
import dam.salesianostriana.dam.GradesAPP.user.model.User;
import dam.salesianostriana.dam.GradesAPP.user.model.UserRole;
import dam.salesianostriana.dam.GradesAPP.user.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Optional;
import java.util.Set;
import java.util.UUID;

@Service
@RequiredArgsConstructor
public class UserService {
    private final UserRepository repo;

    public Optional<User> findById(UUID userId) {
        return repo.findById(userId);
    }

    public Optional<User> findByUserName(String name){
        return repo.findFirstByUsername(name);
    }

    public Optional<User> saveAlumno (UserDtoRegister u){
        return Optional.of(repo.save(Alumno.builder()
                .nombre(u.getNombre())
                .apellidos(u.getApellidos())
                .password(u.getPassword())
                .roles(Set.of(UserRole.USER))
                .fechaNacimiento(u.getFechaNacimiento())
                .build()
        ));
    }
}
