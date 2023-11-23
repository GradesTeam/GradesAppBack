package dam.salesianostriana.dam.GradesAPP.profesor.controller;

import dam.salesianostriana.dam.GradesAPP.profesor.service.ProfesorService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/profesor")
@RequiredArgsConstructor
public class ProfesorController {
    private final ProfesorService service;
}
