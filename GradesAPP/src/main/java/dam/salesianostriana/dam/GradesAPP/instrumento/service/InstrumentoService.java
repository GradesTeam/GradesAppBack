package dam.salesianostriana.dam.GradesAPP.instrumento.service;


import dam.salesianostriana.dam.GradesAPP.MyPage;
import dam.salesianostriana.dam.GradesAPP.exception.NotFoundException;
import dam.salesianostriana.dam.GradesAPP.instrumento.dto.GETInstrumentoDTO;
import dam.salesianostriana.dam.GradesAPP.instrumento.model.Instrumento;
import dam.salesianostriana.dam.GradesAPP.instrumento.repository.InstrumentoRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
@RequiredArgsConstructor
public class InstrumentoService {
    private final InstrumentoRepository repo;

    public MyPage<GETInstrumentoDTO> getAllInstrumentosFromAsignatura(UUID id, Pageable pageable){
        Page<Instrumento> result = repo.findAllByAsignatura_Id(id, pageable);
        if(result.isEmpty())
            throw new NotFoundException("Instrumento");
        Page<GETInstrumentoDTO> res = result.map(GETInstrumentoDTO::of);



        return MyPage.of(res);
    }
}
