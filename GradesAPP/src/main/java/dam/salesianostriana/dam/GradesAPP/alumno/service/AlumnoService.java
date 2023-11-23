package dam.salesianostriana.dam.GradesAPP.alumno.service;

import dam.salesianostriana.dam.GradesAPP.alumno.repository.AlumnoRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class AlumnoService {
    private final AlumnoRepository repo;
}
