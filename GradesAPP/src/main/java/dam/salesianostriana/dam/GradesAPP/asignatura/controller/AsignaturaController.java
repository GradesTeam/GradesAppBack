package dam.salesianostriana.dam.GradesAPP.asignatura.controller;

import dam.salesianostriana.dam.GradesAPP.asignatura.service.AsignaturaService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import io.swagger.v3.oas.annotations.tags.Tag;

import java.util.List;

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
    public List<Asignatura> GetAll(){
    return service.findAll();
    }
}
