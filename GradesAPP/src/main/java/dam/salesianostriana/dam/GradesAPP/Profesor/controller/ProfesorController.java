package dam.salesianostriana.dam.GradesAPP.Profesor.controller;

import dam.salesianostriana.dam.GradesAPP.Profesor.service.ProfesorService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/profesor")
@RequiredArgsConstructor
public class ProfesorController {
    private final ProfesorService service;
}
