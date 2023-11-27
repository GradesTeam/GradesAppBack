package dam.salesianostriana.dam.GradesAPP.asignatura.controller;

import dam.salesianostriana.dam.GradesAPP.asignatura.AsignaturaDTO.GetAsignaturaDTO;
import dam.salesianostriana.dam.GradesAPP.asignatura.service.AsignaturaService;
import dam.salesianostriana.dam.GradesAPP.MyPage;
import dam.salesianostriana.dam.GradesAPP.asignatura.model.Asignatura;
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
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import io.swagger.v3.oas.annotations.tags.Tag;

import java.util.List;
import java.util.UUID;
@RestController
@RequestMapping("/asignatura")
@RequiredArgsConstructor
@Tag(name= "Asignatura", description= "Este es el controlador de las asignaturas, en el cual se gestionan y se enlazan las rutas con los métodos de esta entidad")
public class AsignaturaController {

    private final AsignaturaService service;
@Operation(summary= "Obtiene todas las asignaturas")
@ApiResponses(value= {
        @ApiResponse(responseCode = "200",
                    description= "Se han encontrado todas las asignaturas",
                    content = { @Content(mediaType = "application/json",
                    array = @ArraySchema(schema = @Schema(implementation = Asignatura.class)),
                    examples = { @ExampleObject(
                            value = """
                                    []
                                    """
                    )}
                    )}),
        @ApiResponse(responseCode = "404",
        description = "No se ha encontrado ninguna asignatura",
        content = @Content),
})
    @GetMapping("/")
    public MyPage<GetAsignaturaDTO> GetAll(@PageableDefault(size = 12, page = 0) Pageable pageable){
    return service.findAll(pageable);
    }
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
