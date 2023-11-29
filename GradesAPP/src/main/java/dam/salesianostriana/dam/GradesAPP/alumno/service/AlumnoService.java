package dam.salesianostriana.dam.GradesAPP.alumno.service;

import dam.salesianostriana.dam.GradesAPP.alumno.dto.EditAlumnoDTO;
import dam.salesianostriana.dam.GradesAPP.alumno.dto.GetAlumnoDTO;
import dam.salesianostriana.dam.GradesAPP.alumno.dto.PostAlumnoDTO;
import dam.salesianostriana.dam.GradesAPP.alumno.model.Alumno;
import dam.salesianostriana.dam.GradesAPP.alumno.repository.AlumnoRepository;
import dam.salesianostriana.dam.GradesAPP.exception.NotFoundException;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Optional;
import java.util.UUID;

@Service
@RequiredArgsConstructor
public class AlumnoService {
    private final AlumnoRepository repo;

    public GetAlumnoDTO save(@Valid PostAlumnoDTO nuevo){
        Alumno a = PostAlumnoDTO.from(nuevo);
        return GetAlumnoDTO.of(repo.save(a));
    }

    public GetAlumnoDTO edit(UUID id, @Valid EditAlumnoDTO aEditar){
        if(repo.existsById(id)){
            Optional<Alumno> result = repo.findById(id);
            Alumno editado = result.get();
            editado.setEmail(aEditar.email());
            editado.setTelefono(aEditar.telefono());
            editado.setUsername(aEditar.username());
            editado.setPassword(aEditar.password());
            return GetAlumnoDTO.of(repo.save(editado));
        }else {
            throw new NotFoundException("Alumno");
        }
    }

    public GetAlumnoDTO details(UUID id){
        Optional<Alumno> alumnoOptional = repo.findById(id);
        if(alumnoOptional.isEmpty())
            throw new NotFoundException("Alumno");

        return GetAlumnoDTO.of(alumnoOptional.get());
    }
}
