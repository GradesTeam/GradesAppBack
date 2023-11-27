package dam.salesianostriana.dam.GradesAPP.asignatura.service;

import dam.salesianostriana.dam.GradesAPP.MyPage;
import dam.salesianostriana.dam.GradesAPP.asignatura.AsignaturaDTO.GetAsignaturaDTO;
import dam.salesianostriana.dam.GradesAPP.asignatura.model.Asignatura;
import dam.salesianostriana.dam.GradesAPP.asignatura.repository.AsignaturaRepository;
import dam.salesianostriana.dam.GradesAPP.exception.NotFoundException;
import dam.salesianostriana.dam.GradesAPP.referenteEvaluacion.DTO.ADDReferenteDTO;
import dam.salesianostriana.dam.GradesAPP.referenteEvaluacion.DTO.GETReferenteDTO;
import dam.salesianostriana.dam.GradesAPP.referenteEvaluacion.model.ReferenteEvaluacion;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import dam.salesianostriana.dam.GradesAPP.asignatura.model.Asignatura;

import java.util.List;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
@RequiredArgsConstructor
public class AsignaturaService {
    private  final AsignaturaRepository repo;

    /*public MyPage<GetAsignaturaDTO> findAll(Pageable pageable){
       Page<Asignatura> subjectList= repo.findAll(pageable);

        if(subjectList.isEmpty()){
            throw new NotFoundException("Asignatura");
        }
        Page<GetAsignaturaDTO> AsignaturaDTO= subjectList.map(GetAsignaturaDTO::of);
        return MyPage.of(AsignaturaDTO);

    }*/
    public MyPage<GetAsignaturaDTO> findAll(Pageable pageable){
        Page<GetAsignaturaDTO> subjectList= repo.obtenerTodasConNumeroAlumnos(pageable);
        if (subjectList.isEmpty()){
            throw new NotFoundException("Asignatura");
        }
        return MyPage.of(subjectList);
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

    public ReferenteEvaluacion addReferente(UUID id , ADDReferenteDTO ref){
        Optional<Asignatura> selected = repo.findById(id);
        if (selected.isEmpty())
            throw new NotFoundException("Asignatura");
        Asignatura selectedAs = selected.get();
        ReferenteEvaluacion toSave = ADDReferenteDTO.from(ref, selectedAs);
        toSave.setId(toSave.getId());
        List<ReferenteEvaluacion> toSet = repo.getNonPagedReferentesFromAsignatura(id);
        toSet.add(toSave);
        selectedAs.setReferentes(toSet);
        repo.save(selectedAs);
        return toSave;
    }
    public boolean referenteExists(String s ) {
        return repo.getAllReferentes().stream().map(ReferenteEvaluacion::getCodReferente).toList().contains(s);
    }
}
