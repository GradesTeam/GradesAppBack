package dam.salesianostriana.dam.GradesAPP.Asignatura.controller;

import dam.salesianostriana.dam.GradesAPP.Asignatura.service.AsignaturaService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/asignatura")
@RequiredArgsConstructor
public class AsignaturaController {

    private final AsignaturaService service;
}
