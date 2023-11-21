package dam.salesianostriana.dam.GradesAPP.Profesor.service;

import dam.salesianostriana.dam.GradesAPP.Profesor.repository.ProfesorRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class ProfesorService {
    private final ProfesorRepository repo;
}
