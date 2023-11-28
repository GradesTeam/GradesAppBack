package dam.salesianostriana.dam.GradesAPP.alumno.service;

import dam.salesianostriana.dam.GradesAPP.alumno.dto.GetAlumnoDTO;
import dam.salesianostriana.dam.GradesAPP.alumno.dto.PostAlumnoDTO;
import dam.salesianostriana.dam.GradesAPP.alumno.model.Alumno;
import dam.salesianostriana.dam.GradesAPP.alumno.repository.AlumnoRepository;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class AlumnoService {
    private final AlumnoRepository repo;

    public GetAlumnoDTO save(@Valid PostAlumnoDTO nuevo){
        Alumno a = PostAlumnoDTO.from(nuevo);
        return GetAlumnoDTO.of(repo.save(a));
    }
}
