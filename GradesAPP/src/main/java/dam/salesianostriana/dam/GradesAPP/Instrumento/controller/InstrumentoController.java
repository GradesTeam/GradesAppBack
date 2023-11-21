package dam.salesianostriana.dam.GradesAPP.Instrumento.controller;

import dam.salesianostriana.dam.GradesAPP.Instrumento.service.InstrumentoService;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@RequestMapping("/instrumento")
public class InstrumentoController {
    private final InstrumentoService service;
}
