package dam.salesianostriana.dam.GradesAPP.Instrumento.service;

import dam.salesianostriana.dam.GradesAPP.Instrumento.repository.InstrumentoRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class InstrumentoService {
    private final InstrumentoRepository repo;
}
