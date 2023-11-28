package dam.salesianostriana.dam.GradesAPP.alumno.controller;

import dam.salesianostriana.dam.GradesAPP.alumno.dto.GetAlumnoDTO;
import dam.salesianostriana.dam.GradesAPP.alumno.dto.PostAlumnoDTO;
import dam.salesianostriana.dam.GradesAPP.alumno.model.Alumno;
import dam.salesianostriana.dam.GradesAPP.alumno.service.AlumnoService;
import dam.salesianostriana.dam.GradesAPP.instrumento.model.Instrumento;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.ArraySchema;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.ExampleObject;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;

@RestController
@RequestMapping("/alumno")
@RequiredArgsConstructor
@Tag(name= "Alumno", description = "Controlador para la gestión de alumnos")
public class AlumnoController {
    private final AlumnoService service;

    @ApiResponses(value = {
            @ApiResponse(responseCode = "201", description = "El Alumno se ha creado de forma correcta", content = {
                    @Content(mediaType = "application/json",
                            array = @ArraySchema(schema = @Schema(implementation = Instrumento.class)),
                            examples = {@ExampleObject(
                                    value = """
                                                {
                                                    "id": "07bc8d93-1fa6-4438-95f4-38f1c8b63e66",
                                                    "nombre": "Nombre del Alumno",
                                                    "apellido": "Apellidos del Alumno",
                                                    "fechaNacimiento": "2000-01-01",
                                                    "telefono": "123456789",
                                                    "email": "correo@example.com"
                                                }
                                            """
                            )}
                    )}),
            @ApiResponse(responseCode = "400",
                    description = "No se han aportado los datos correctamente",
                    content = @Content)
    })
    @Operation(summary = "Crear un nuevo Alumno")
    @PostMapping("/")
    public ResponseEntity<GetAlumnoDTO> agregarAlumno(@Valid @RequestBody PostAlumnoDTO nuevo){
        GetAlumnoDTO a = service.save(nuevo);
        URI createdUri = ServletUriComponentsBuilder
                .fromCurrentRequest()
                .path("/{id}")
                .buildAndExpand(a.id()).toUri();

        return ResponseEntity
                .created(createdUri)
                .body(a);
    }
}
