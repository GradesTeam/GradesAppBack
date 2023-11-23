package dam.salesianostriana.dam.GradesAPP.Asignatura.service;

import dam.salesianostriana.dam.GradesAPP.Asignatura.exception.EmptySubjectListException;
import dam.salesianostriana.dam.GradesAPP.asignatura.repository.AsignaturaRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import dam.salesianostriana.dam.GradesAPP.asignatura.model.Asignatura;

import java.util.List;

@Service
@RequiredArgsConstructor
public class AsignaturaService {
    private  final AsignaturaRepository repo;

    public List<Asignatura> findAll(){
        List<Asignatura> subjectList= repo.findAll();

        if(subjectList.isEmpty()){
            throw new EmptySubjectListException();
        }
        return subjectList;
    }
}
