package dam.salesianostriana.dam.GradesAPP.profesor.controller;

import dam.salesianostriana.dam.GradesAPP.alumno.dto.GetAlumnoListDTO;
import dam.salesianostriana.dam.GradesAPP.profesor.service.ProfesorService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/profesor")
@RequiredArgsConstructor
public class ProfesorController {
    private final ProfesorService service;

    @GetMapping("/profesor/{id}/alumnos")
    public ResponseEntity<List<GetAlumnoListDTO>> obtenerAlumnosPorProfesor(
            @PathVariable UUID id
    ){
        List<GetAlumnoListDTO> alumnos = service.obtenerAlumnosPorProfesor(id);
        return ResponseEntity.ok(alumnos);
    }
}
