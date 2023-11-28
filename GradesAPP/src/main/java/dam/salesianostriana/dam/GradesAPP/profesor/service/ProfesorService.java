package dam.salesianostriana.dam.GradesAPP.profesor.service;

import dam.salesianostriana.dam.GradesAPP.MyPage;
import dam.salesianostriana.dam.GradesAPP.alumno.dto.GetAlumnoListDTO;
import dam.salesianostriana.dam.GradesAPP.alumno.model.Alumno;
import dam.salesianostriana.dam.GradesAPP.exception.NotFoundException;
import dam.salesianostriana.dam.GradesAPP.profesor.model.Profesor;
import dam.salesianostriana.dam.GradesAPP.profesor.repository.ProfesorRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class ProfesorService {
    private final ProfesorRepository repo;

    public MyPage<GetAlumnoListDTO> obtenerAlumnosPorProfesor(UUID profesorId, Pageable pageable) {
        Page<Alumno> result = repo.findAlumnosByProfesor(profesorId, pageable);
        if (result.isEmpty())
            throw new NotFoundException("Profesor");
        Page<GetAlumnoListDTO> resDto = result.map(GetAlumnoListDTO::of);
        return MyPage.of(resDto);
    }

    public Optional<Profesor> findById (UUID id){
        return repo.findById(id);
    }

}