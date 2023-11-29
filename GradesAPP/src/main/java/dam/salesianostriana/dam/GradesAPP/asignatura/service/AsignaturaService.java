package dam.salesianostriana.dam.GradesAPP.asignatura.service;

import dam.salesianostriana.dam.GradesAPP.MyPage;
import dam.salesianostriana.dam.GradesAPP.asignatura.AsignaturaDTO.GetAsignaturaDTO;
import dam.salesianostriana.dam.GradesAPP.asignatura.AsignaturaDTO.PostAsignaturaDTO;
import dam.salesianostriana.dam.GradesAPP.asignatura.model.Asignatura;
import dam.salesianostriana.dam.GradesAPP.asignatura.repository.AsignaturaRepository;
import dam.salesianostriana.dam.GradesAPP.exception.NotFoundException;
import dam.salesianostriana.dam.GradesAPP.profesor.model.Profesor;
import dam.salesianostriana.dam.GradesAPP.profesor.repository.ProfesorRepository;
import dam.salesianostriana.dam.GradesAPP.referenteEvaluacion.DTO.ADDReferenteDTO;
import dam.salesianostriana.dam.GradesAPP.referenteEvaluacion.DTO.GETReferenteDTO;
import dam.salesianostriana.dam.GradesAPP.referenteEvaluacion.DTO.PUTReferenteDTO;
import dam.salesianostriana.dam.GradesAPP.referenteEvaluacion.model.ReferenteEvaluacion;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import dam.salesianostriana.dam.GradesAPP.asignatura.model.Asignatura;

import java.util.*;

import java.util.List;

@Service
@RequiredArgsConstructor
public class AsignaturaService {
    private  final AsignaturaRepository repo;
    private final ProfesorRepository proRepo;

    public MyPage<GetAsignaturaDTO> findAll(Pageable pageable){
        Page<GetAsignaturaDTO> subjectList= repo.obtenerTodasConNumeroAlumnos(pageable);
        if (subjectList.isEmpty())
            throw new NotFoundException("Asignatura");

        return MyPage.of(subjectList);
    }

public MyPage<GetAsignaturaDTO> getAsignaturasByProfesor(Pageable pageable, UUID profesorId){
        Page<GetAsignaturaDTO> asignaturaListProfe= repo.getAsignaturasByProfesor(profesorId, pageable);
        if (asignaturaListProfe.isEmpty())
            throw new NotFoundException("Asignatura");

        return MyPage.of(asignaturaListProfe);
}

    public GetAsignaturaDTO createAsignatura (PostAsignaturaDTO nuevoAsig){
        UUID profesorUUID = UUID.fromString(nuevoAsig.idProfesor());
        Optional<Profesor> profeSeleccion= proRepo.findById(profesorUUID);
        if(profeSeleccion.isEmpty()) {
            throw new NotFoundException("Profesor");
        }
        Profesor profe= profeSeleccion.get();
        Asignatura asignaturaNueva= PostAsignaturaDTO.from(nuevoAsig, profe);
        return GetAsignaturaDTO.of(repo.save(asignaturaNueva));
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

    public GETReferenteDTO editReferente(UUID idAsig, String id, PUTReferenteDTO referenteDTO) {
        Optional<Asignatura> selected = repo.findByIdWithRefrerente(idAsig);
        if (selected.isEmpty())
            throw new NotFoundException("Asignatura");
        Asignatura selectedAs = selected.get();
        Optional<ReferenteEvaluacion> selectedR = repo.getReferenteById(id);
        if(selectedR.isEmpty())
            throw new NotFoundException("Referente");
        ReferenteEvaluacion toEdit = selectedR.get();
        selectedAs.removeReferente(toEdit);
        selectedAs.addReferente(PUTReferenteDTO.from(toEdit, referenteDTO));
        repo.save(selectedAs);
        return GETReferenteDTO.of(PUTReferenteDTO.from(toEdit, referenteDTO));


    }
    public GETReferenteDTO getReferenteById(String id){
        Optional<ReferenteEvaluacion> ref = repo.getReferenteById(id);
        if(ref.isEmpty())
            throw new NotFoundException("Referente");
        return GETReferenteDTO.of(ref.get());
    }
}
