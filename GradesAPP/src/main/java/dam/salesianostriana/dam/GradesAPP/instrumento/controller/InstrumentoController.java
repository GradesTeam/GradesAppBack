package dam.salesianostriana.dam.GradesAPP.instrumento.controller;

import dam.salesianostriana.dam.GradesAPP.instrumento.service.InstrumentoService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@RequestMapping("/instrumento")
public class InstrumentoController {
    private final InstrumentoService service;
}
