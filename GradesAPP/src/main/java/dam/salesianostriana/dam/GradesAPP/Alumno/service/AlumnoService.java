package dam.salesianostriana.dam.GradesAPP.Alumno.service;

import dam.salesianostriana.dam.GradesAPP.Alumno.repository.AlumnoRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class AlumnoService {
    private final AlumnoRepository repo;
}
