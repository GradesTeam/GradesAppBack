package dam.salesianostriana.dam.GradesAPP.asignatura.controller;

import dam.salesianostriana.dam.GradesAPP.MyPage;
import dam.salesianostriana.dam.GradesAPP.asignatura.service.AsignaturaService;
import dam.salesianostriana.dam.GradesAPP.instrumento.model.Instrumento;
import dam.salesianostriana.dam.GradesAPP.referenteEvaluacion.DTO.GETReferenteDTO;
import dam.salesianostriana.dam.GradesAPP.referenteEvaluacion.model.ReferenteEvaluacion;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.ArraySchema;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.ExampleObject;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.UUID;

@RestController
@RequestMapping("/asignatura")
@RequiredArgsConstructor
@Tag(name= "RestController para Asignatura", description = "Controlador para la gestión de Asignaturas ")
public class AsignaturaController {

    private final AsignaturaService service;



















    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Obtiene todos los referentes de la Asigantura con Id dado", content = {
                    @Content(mediaType = "application/json",
                            array = @ArraySchema(schema = @Schema(implementation = ReferenteEvaluacion.class)),
                            examples = {@ExampleObject(
                                    value = """
                                                {
                                                     "content": [
                                                         {
                                                             "codReferente": "Ad.2",
                                                             "descripcion": "Hola mundo"
                                                         }
                                                     ],
                                                     "size": 10,
                                                     "totalElements": 1,
                                                     "pageNumber": 0,
                                                     "first": true,
                                                     "last": true
                                                 }
                                            """
                            )}
                    )}),
            @ApiResponse(responseCode = "404",
                    description = "No se ha encontrado la Asignatura o está no tiene Referentes asociados",
                    content = @Content(mediaType = "application/json",
                            array = @ArraySchema(schema = @Schema(implementation = ReferenteEvaluacion.class)),
                            examples = {@ExampleObject(
                                    """
                                        {
                                            "error": "The Referente/Asignatura or the list of it could not be found" 
                                        }       
                                    """
                            )
                            }))
    })
    @Operation(summary = "Buscar todas los Referentes de una Asigantura", description = "Devuelve una lista de Referentes de evaluacion paginados")
    @GetMapping("/{id}/referentes")
    public MyPage<GETReferenteDTO> getAllReferentesFromAsignatura(@PathVariable UUID id, @PageableDefault(size = 10, page = 0) Pageable pageable){
        return service.getReferentesFromAsignatura(id, pageable);
    }
}
