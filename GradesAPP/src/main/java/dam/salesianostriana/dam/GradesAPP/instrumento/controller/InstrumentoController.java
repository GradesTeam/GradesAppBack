package dam.salesianostriana.dam.GradesAPP.instrumento.controller;

import dam.salesianostriana.dam.GradesAPP.instrumento.dto.GETInstrumentoDTO;
import dam.salesianostriana.dam.GradesAPP.instrumento.service.InstrumentoService;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
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
    public Page<GETInstrumentoDTO> getAllInstrumentosFromAsignatura(@PathVariable UUID id, @PageableDefault(page = 0, size = 10)Pageable pageable){
        return service.getAllInstrumentosFromAsignatura(id, pageable);
    }
}
