package dam.salesianostriana.dam.GradesAPP.asignatura.service;

import dam.salesianostriana.dam.GradesAPP.MyPage;
import dam.salesianostriana.dam.GradesAPP.asignatura.model.Asignatura;
import dam.salesianostriana.dam.GradesAPP.asignatura.repository.AsignaturaRepository;
import dam.salesianostriana.dam.GradesAPP.exception.NotFoundException;
import dam.salesianostriana.dam.GradesAPP.referenteEvaluacion.DTO.GETReferenteDTO;
import dam.salesianostriana.dam.GradesAPP.referenteEvaluacion.model.ReferenteEvaluacion;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import dam.salesianostriana.dam.GradesAPP.asignatura.model.Asignatura;

import java.util.List;

import java.util.Optional;
import java.util.UUID;

@Service
@RequiredArgsConstructor
public class AsignaturaService {
    private  final AsignaturaRepository repo;

    public List<Asignatura> findAll(){
        List<Asignatura> subjectList= repo.findAll();

        if(subjectList.isEmpty()){
            throw new NotFoundException("Subject");
        }
        return subjectList;

    }





    public MyPage<GETReferenteDTO> getReferentesFromAsignatura(UUID id, Pageable pageable){
        Optional<Asignatura> selected = repo.findById(id);
        if (selected.isEmpty())
            throw new NotFoundException("Asignatura");

        Page<ReferenteEvaluacion> pageSelected = repo.getReferentesFromAsignatura(id, pageable);
        if(pageSelected.isEmpty())
            throw new NotFoundException("Referente Evaluacion");
        return MyPage.of(pageSelected.map(GETReferenteDTO::of));

    }
}
