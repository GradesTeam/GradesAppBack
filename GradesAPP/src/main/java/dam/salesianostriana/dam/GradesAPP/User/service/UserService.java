package dam.salesianostriana.dam.GradesAPP.User.service;

import dam.salesianostriana.dam.GradesAPP.User.model.User;
import dam.salesianostriana.dam.GradesAPP.User.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@RequiredArgsConstructor
public class UserService {
    private final UserRepository repo;
}
