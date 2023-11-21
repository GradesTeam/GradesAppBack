package dam.salesianostriana.dam.GradesAPP.Calificacion.service;

import dam.salesianostriana.dam.GradesAPP.Calificacion.repository.CalificacionRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class CalificacionService {
    private final CalificacionRepository repo;
}
