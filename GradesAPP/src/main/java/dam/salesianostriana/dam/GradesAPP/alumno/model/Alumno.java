package dam.salesianostriana.dam.GradesAPP.alumno.model;

import dam.salesianostriana.dam.GradesAPP.asignatura.model.Asignatura;
import dam.salesianostriana.dam.GradesAPP.user.model.User;
import jakarta.persistence.*;
import lombok.*;
import lombok.experimental.SuperBuilder;

import java.time.LocalDateTime;
import java.util.LinkedHashSet;
import java.util.Set;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@SuperBuilder
@Getter@Setter
@EqualsAndHashCode
public class Alumno extends User {

    private String telefono;
    private LocalDateTime fechaNacimiento;

    @Getter
    @ManyToMany
    @JoinTable(name = "Alumno_asignaturas",
            joinColumns = @JoinColumn(name = "alumno_id"),
            inverseJoinColumns = @JoinColumn(name = "asignaturas_id"))
    @ElementCollection(fetch = FetchType.LAZY)
    private Set<Asignatura> asignaturas = new LinkedHashSet<>();

}
