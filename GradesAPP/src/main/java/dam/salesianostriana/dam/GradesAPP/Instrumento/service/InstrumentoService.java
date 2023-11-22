package dam.salesianostriana.dam.GradesAPP.Instrumento.service;

import dam.salesianostriana.dam.GradesAPP.Instrumento.GETInstrumentoDTO;
import dam.salesianostriana.dam.GradesAPP.Instrumento.model.Instrumento;
import dam.salesianostriana.dam.GradesAPP.Instrumento.repository.InstrumentoRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.data.crossstore.ChangeSetPersister;
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
            throw ;
        return result.stream().map(GETInstrumentoDTO::of).toList();
    }
}
