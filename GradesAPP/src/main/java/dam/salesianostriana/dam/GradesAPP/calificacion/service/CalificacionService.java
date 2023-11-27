package dam.salesianostriana.dam.GradesAPP.calificacion.service;

import dam.salesianostriana.dam.GradesAPP.MyPage;
import dam.salesianostriana.dam.GradesAPP.calificacion.DTO.GETCalificaciónDTO;
import dam.salesianostriana.dam.GradesAPP.calificacion.model.Calificacion;
import dam.salesianostriana.dam.GradesAPP.calificacion.repository.CalificacionRepository;
import dam.salesianostriana.dam.GradesAPP.exception.NotFoundException;
import dam.salesianostriana.dam.GradesAPP.instrumento.model.Instrumento;
import dam.salesianostriana.dam.GradesAPP.instrumento.repository.InstrumentoRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.Optional;
import java.util.UUID;

@Service
@RequiredArgsConstructor
public class CalificacionService {
    private final CalificacionRepository repo;
    private final InstrumentoRepository repoIns;

    public MyPage<GETCalificaciónDTO> getAllCalificacionesFromInstrumento(UUID uuid, Pageable pageable){
        Optional<Instrumento> selected = repoIns.findById(uuid);
        if(selected.isEmpty())
            throw new NotFoundException("Instrumento");
        Page<Calificacion> request = repo.findAllByInstrumento_Id(uuid, pageable);
        Page<GETCalificaciónDTO> toReturn = request.map(GETCalificaciónDTO::of);
        return MyPage.of(toReturn);

    }
}
