package dam.salesianostriana.dam.GradesAPP.profesor.service;

import dam.salesianostriana.dam.GradesAPP.profesor.repository.ProfesorRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class ProfesorService {
    private final ProfesorRepository repo;
}
