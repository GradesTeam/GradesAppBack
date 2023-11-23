package dam.salesianostriana.dam.GradesAPP.asignatura.service;

import dam.salesianostriana.dam.GradesAPP.asignatura.repository.AsignaturaRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class AsignaturaService {
    private  final AsignaturaRepository repo;
}
