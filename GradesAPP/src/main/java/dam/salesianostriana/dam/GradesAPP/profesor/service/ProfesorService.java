package dam.salesianostriana.dam.GradesAPP.profesor.service;

import dam.salesianostriana.dam.GradesAPP.alumno.dto.GetAlumnoListDTO;
import dam.salesianostriana.dam.GradesAPP.profesor.repository.ProfesorRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class ProfesorService {
    private final ProfesorRepository repo;

    public List<GetAlumnoListDTO> obtenerAlumnosPorProfesor(UUID profesorId){
        return repo.findAlumnosByProfesor(profesorId)
                .stream()
                .map(a -> new GetAlumnoListDTO(
                                a.getNombre() + " " + a.getApellidos(),
                                a.getFechaNacimiento().toLocalDate()))
                .collect(Collectors.toList());
    }
}
