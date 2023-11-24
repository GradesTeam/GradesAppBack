package dam.salesianostriana.dam.GradesAPP.profesor.service;

import dam.salesianostriana.dam.GradesAPP.MyPage;
import dam.salesianostriana.dam.GradesAPP.alumno.dto.GetAlumnoListDTO;
import dam.salesianostriana.dam.GradesAPP.alumno.model.Alumno;
import dam.salesianostriana.dam.GradesAPP.profesor.repository.ProfesorRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class ProfesorService {
    private final ProfesorRepository repo;

    public MyPage<GetAlumnoListDTO> obtenerAlumnosPorProfesor(UUID profesorId, Pageable pageable){
        Page<Alumno> result = repo.findAlumnosByProfesor(profesorId, pageable);
        Page<GetAlumnoListDTO> resDto = result.map(GetAlumnoListDTO::of);
        return MyPage.of(resDto);
    }
}
