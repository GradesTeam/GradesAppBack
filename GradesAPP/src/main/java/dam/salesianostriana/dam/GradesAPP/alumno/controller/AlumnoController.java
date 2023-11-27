package dam.salesianostriana.dam.GradesAPP.alumno.controller;

import dam.salesianostriana.dam.GradesAPP.alumno.dto.GetAlumnoDTO;
import dam.salesianostriana.dam.GradesAPP.alumno.dto.PostAlumnoDTO;
import dam.salesianostriana.dam.GradesAPP.alumno.model.Alumno;
import dam.salesianostriana.dam.GradesAPP.alumno.service.AlumnoService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/alumno")
@RequiredArgsConstructor
public class AlumnoController {
    private final AlumnoService service;

    @PostMapping("/")
    public ResponseEntity<GetAlumnoDTO> agregarAlumno(@Valid @RequestBody PostAlumnoDTO nuevo){
        Alumno a = service.save(nuevo);
        return ResponseEntity
                .status(HttpStatus.CREATED)
                .body(GetAlumnoDTO.of(a));
    }
}
