package dam.salesianostriana.dam.GradesAPP.Calificacion.controller;

import dam.salesianostriana.dam.GradesAPP.Calificacion.service.CalificacionService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/alumno")
@RequiredArgsConstructor
public class CalificacionController {
    private final CalificacionService service;
}
