package dam.salesianostriana.dam.GradesAPP.user.service;

import dam.salesianostriana.dam.GradesAPP.security.PasswordEncoderConfig;
import dam.salesianostriana.dam.GradesAPP.user.model.User;
import dam.salesianostriana.dam.GradesAPP.user.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.factory.PasswordEncoderFactories;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.beans.Encoder;
import java.util.Optional;
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

    public Optional<User> save (User u){
        return Optional.of(repo.save(u));
    }
}
