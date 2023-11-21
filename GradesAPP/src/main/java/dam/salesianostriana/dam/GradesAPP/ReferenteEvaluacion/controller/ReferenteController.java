package dam.salesianostriana.dam.GradesAPP.ReferenteEvaluacion.controller;

import dam.salesianostriana.dam.GradesAPP.ReferenteEvaluacion.service.ReferenteService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/referente")
@RequiredArgsConstructor
public class ReferenteController {
    private final ReferenteService service;
}
