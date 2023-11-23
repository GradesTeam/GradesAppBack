package dam.salesianostriana.dam.GradesAPP.instrumento.controller;

import dam.salesianostriana.dam.GradesAPP.instrumento.service.InstrumentoService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.UUID;

@RestController
@RequiredArgsConstructor
public class InstrumentoController {
    private final InstrumentoService service;


    @GetMapping("/asignatura/{id}/instrumentos")
    public List<GETInstrumentoDTO> getAllInstrumentosFromAsignatura(@PathVariable UUID id){
        return service.getAllInstrumentosFromAsignatura(id);
    }
}
