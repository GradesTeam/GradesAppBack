package dam.salesianostriana.dam.GradesAPP.user.service;

import dam.salesianostriana.dam.GradesAPP.user.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class UserService {
    private final UserRepository repo;
}
