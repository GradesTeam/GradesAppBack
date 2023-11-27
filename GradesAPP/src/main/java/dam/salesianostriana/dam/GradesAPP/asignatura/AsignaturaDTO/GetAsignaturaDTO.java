package dam.salesianostriana.dam.GradesAPP.asignatura.AsignaturaDTO;

import dam.salesianostriana.dam.GradesAPP.asignatura.model.Asignatura;
import dam.salesianostriana.dam.GradesAPP.profesor.model.Profesor;
import lombok.Builder;

@Builder
public record GetAsignaturaDTO(
        String asigNombre,
        String asigDescripcion,
        String nombreProfesor,
        String color) {
    public static GetAsignaturaDTO of (Asignatura asig){
        return GetAsignaturaDTO.builder()
                .asigNombre(asig.getNombre())
                .asigDescripcion(asig.getDescripcion())
                .nombreProfesor(asig.getProfesor().getNombre())
                .color(asig.getHexColor())
                .build();
    }

}
