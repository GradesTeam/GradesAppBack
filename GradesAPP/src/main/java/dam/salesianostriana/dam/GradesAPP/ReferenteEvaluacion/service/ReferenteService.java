package dam.salesianostriana.dam.GradesAPP.ReferenteEvaluacion.service;

import dam.salesianostriana.dam.GradesAPP.ReferenteEvaluacion.repository.ReferenteRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Service
@RequiredArgsConstructor
public class ReferenteService {
    private final ReferenteRepository repo;
}
