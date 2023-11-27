package dam.salesianostriana.dam.GradesAPP.calificacion.controller;

import dam.salesianostriana.dam.GradesAPP.MyPage;
import dam.salesianostriana.dam.GradesAPP.calificacion.DTO.GETCalificaciónDTO;
import dam.salesianostriana.dam.GradesAPP.calificacion.service.CalificacionService;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.UUID;

@RestController
@RequiredArgsConstructor
public class CalificacionController {
    private final CalificacionService service;

    @GetMapping("/teacher/asignatura/{id}/instrumento/{id_ins}/calificaciones")
    public MyPage<GETCalificaciónDTO> getAllCalificacionesfromInstrumento(@PathVariable UUID id, @PathVariable UUID id_ins, @PageableDefault(size = 10, page = 0)Pageable pageable){
        return service.getAllCalificacionesFromInstrumento(id_ins, pageable);
    }
}
