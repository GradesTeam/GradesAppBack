package dam.salesianostriana.dam.GradesAPP.alumno.controller;

import dam.salesianostriana.dam.GradesAPP.alumno.service.AlumnoService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/alumno")
@RequiredArgsConstructor
public class AlumnoController {
    private final AlumnoService service;
}
