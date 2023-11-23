package dam.salesianostriana.dam.GradesAPP.referenteEvaluacion.service;

import dam.salesianostriana.dam.GradesAPP.referenteEvaluacion.repository.ReferenteRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class ReferenteService {
    private final ReferenteRepository repo;
}
