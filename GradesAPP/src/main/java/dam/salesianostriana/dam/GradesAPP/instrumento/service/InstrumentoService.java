package dam.salesianostriana.dam.GradesAPP.instrumento.service;

import dam.salesianostriana.dam.GradesAPP.exception.NotFoundException;
import dam.salesianostriana.dam.GradesAPP.instrumento.dto.GETInstrumentoDTO;
import dam.salesianostriana.dam.GradesAPP.instrumento.model.Instrumento;
import dam.salesianostriana.dam.GradesAPP.instrumento.repository.InstrumentoRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
@RequiredArgsConstructor
public class InstrumentoService {
    private final InstrumentoRepository repo;

    public List<GETInstrumentoDTO> getAllInstrumentosFromAsignatura(UUID id){
        List<Instrumento> result = repo.getAllInstrumentosByAsignaturaId(id);
        if(result.isEmpty())
            throw new NotFoundException("Instrumento");
        return result.stream().map(GETInstrumentoDTO::of).toList();
    }
}
