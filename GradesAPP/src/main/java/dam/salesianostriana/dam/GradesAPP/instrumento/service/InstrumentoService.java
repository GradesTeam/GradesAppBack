package dam.salesianostriana.dam.GradesAPP.instrumento.service;


import dam.salesianostriana.dam.GradesAPP.MyPage;
import dam.salesianostriana.dam.GradesAPP.asignatura.model.Asignatura;
import dam.salesianostriana.dam.GradesAPP.asignatura.repository.AsignaturaRepository;
import dam.salesianostriana.dam.GradesAPP.exception.NotFoundException;
import dam.salesianostriana.dam.GradesAPP.instrumento.dto.GETInstrumentoDTO;
import dam.salesianostriana.dam.GradesAPP.instrumento.dto.POSTInstrumentoDTO;
import dam.salesianostriana.dam.GradesAPP.instrumento.model.Instrumento;
import dam.salesianostriana.dam.GradesAPP.instrumento.repository.InstrumentoRepository;
import dam.salesianostriana.dam.GradesAPP.referenteEvaluacion.model.ReferenteEvaluacion;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.Optional;
import java.util.Set;
import java.util.UUID;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class InstrumentoService {
    private final InstrumentoRepository repo;
    private final AsignaturaRepository repoAs;

    public MyPage<GETInstrumentoDTO> getAllInstrumentosFromAsignatura(UUID id, Pageable pageable){
        Optional<Asignatura> selectedAs = repoAs.findById(id);
        if (selectedAs.isEmpty())
            throw new NotFoundException("Asignatura");
        Page<Instrumento> result = repo.findAllByAsignatura_Id(id, pageable);
        if(result.isEmpty())
            throw new NotFoundException("Instrumento");
        Page<GETInstrumentoDTO> res = result.map(GETInstrumentoDTO::of);



        return MyPage.of(res);
    }

    public GETInstrumentoDTO createInstrumento( UUID id ,POSTInstrumentoDTO newIns){
        Optional<Asignatura> selectedAs = repoAs.findById(id);
        if (selectedAs.isEmpty())
            throw new NotFoundException("Asignatura");
        Instrumento created = POSTInstrumentoDTO.from(newIns, selectedAs.get());
        Set<ReferenteEvaluacion> toSave = created.getReferentes();
        repoAs.getAllReferentes().forEach(ref -> {
            if (newIns.referentes().contains(ref.getCodReferente()))
                toSave.add(ref);
        });
        created.setReferentes(toSave);


        return GETInstrumentoDTO.of(repo.save(created));
    }

    public boolean intrumentoExists(String s){
        return repo.findByNombre(s).isPresent();
    }
}
