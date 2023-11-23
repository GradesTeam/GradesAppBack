package dam.salesianostriana.dam.GradesAPP.calificacion.service;

import dam.salesianostriana.dam.GradesAPP.calificacion.repository.CalificacionRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class CalificacionService {
    private final CalificacionRepository repo;
}
