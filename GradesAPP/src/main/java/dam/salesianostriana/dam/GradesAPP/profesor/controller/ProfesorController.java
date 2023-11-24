package dam.salesianostriana.dam.GradesAPP.profesor.controller;

import dam.salesianostriana.dam.GradesAPP.MyPage;
import dam.salesianostriana.dam.GradesAPP.alumno.dto.GetAlumnoListDTO;
import dam.salesianostriana.dam.GradesAPP.alumno.model.Alumno;
import dam.salesianostriana.dam.GradesAPP.profesor.service.ProfesorService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.ArraySchema;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.ExampleObject;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import org.springframework.data.domain.Pageable;
import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/profesor")
@RequiredArgsConstructor
@Tag(name = "Categoria", description = "Controlador de la entidad Profesor")
public class ProfesorController {
    private final ProfesorService service;

    @Operation(summary = "Obtiene la lista de alumnos de un profesor")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200",
                    description = "Se han encontrado alumnos",
                    content = { @Content(mediaType = "application/json",
                            array = @ArraySchema(schema = @Schema(implementation = Alumno.class)),
                            examples = {@ExampleObject(
                                    value = """
                                            [
                                                {
                                                    "nombreApellidos": "Paco Paquito Pacazo",
                                                    "fechaNacimiento": "2023-11-24"
                                                }
                                            ]                                        
                                            """
                            )}
                    )}),
            @ApiResponse(responseCode = "404",
                    description = "No se ha encontrado ningun alumno asociado a este profesor",
                    content = @Content),
    })
    @GetMapping("/{id}/alumnos")
    public ResponseEntity<MyPage<GetAlumnoListDTO>> obtenerAlumnosPorProfesor(
            @PathVariable UUID id,
            @PageableDefault(page = 0, size = 10)Pageable pageable
    ){
        MyPage<GetAlumnoListDTO> data = service.obtenerAlumnosPorProfesor(id, pageable);



        return ResponseEntity.ok(data);
    }
}
