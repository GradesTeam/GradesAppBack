package dam.salesianostriana.dam.GradesAPP.referenteEvaluacion.controller;

import dam.salesianostriana.dam.GradesAPP.referenteEvaluacion.service.ReferenteService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/referente")
@RequiredArgsConstructor
public class ReferenteController {
    private final ReferenteService service;
}
