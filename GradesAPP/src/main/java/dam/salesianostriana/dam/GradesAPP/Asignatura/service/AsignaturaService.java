package dam.salesianostriana.dam.GradesAPP.Asignatura.service;

import dam.salesianostriana.dam.GradesAPP.Asignatura.repository.AsignaturaRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class AsignaturaService {
    private  final AsignaturaRepository repo;
}
