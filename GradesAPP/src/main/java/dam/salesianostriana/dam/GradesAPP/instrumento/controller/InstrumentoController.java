package dam.salesianostriana.dam.GradesAPP.instrumento.controller;

import dam.salesianostriana.dam.GradesAPP.MyPage;
import dam.salesianostriana.dam.GradesAPP.instrumento.dto.GETInstrumentoDTO;
import dam.salesianostriana.dam.GradesAPP.instrumento.model.Instrumento;
import dam.salesianostriana.dam.GradesAPP.instrumento.service.InstrumentoService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.ArraySchema;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.ExampleObject;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.UUID;

@RestController
@RequiredArgsConstructor
@Tag(name= "RestController para Instrumento", description = "Controlador para la gestión de Instrumentos ")
public class InstrumentoController {
    private final InstrumentoService service;

    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Obtiene todos los instrumentos de la Asigantura con Id dado", content = {
                    @Content(mediaType = "application/json",
                            array = @ArraySchema(schema = @Schema(implementation = Instrumento.class)),
                            examples = {@ExampleObject(
                                    value = """
                                                {
                                                    "content": [
                                                        {
                                                            "id": "1724fc40-512a-42d1-8495-f8eae0967e9e",
                                                            "nombre": "Examen T1",
                                                            "fecha": "2023-11-03T12:30:00"
                                                        },
                                                        {
                                                            "id": "299d93b4-c8f0-4e09-ada5-740ea6ea86f3",
                                                            "nombre": "Proyecto T1",
                                                            "fecha": "2023-12-09T12:30:00"
                                                        }
                                                    ],
                                                    "size": 10,
                                                    "totalElements": 2,
                                                    "pageNumber": 0,
                                                    "first": true,
                                                    "last": true
                                                }
                                            """
                            )}
                    )}),
            @ApiResponse(responseCode = "404",
                    description = "No se ha encontrado la Asignatura o está no tiene Instrumentos asociados",
                    content = @Content(mediaType = "application/json",
                    array = @ArraySchema(schema = @Schema(implementation = Instrumento.class)),
                    examples = {@ExampleObject(
                            """
                                {
                                    "error": "The Instrumento or the list of it could not be found" 
                                }       
                            """
                    )
                    }))
    })
    @Operation(summary = "Buscar todas los Instrumentos de una Asigantura", description = "It returns the list of all the Alumnos")
    @GetMapping("/asignatura/{id}/instrumentos")
    public MyPage<GETInstrumentoDTO> getAllInstrumentosFromAsignatura(@PathVariable UUID id, @PageableDefault(page = 0, size = 10)Pageable pageable){
        return service.getAllInstrumentosFromAsignatura(id, pageable);
    }
}
