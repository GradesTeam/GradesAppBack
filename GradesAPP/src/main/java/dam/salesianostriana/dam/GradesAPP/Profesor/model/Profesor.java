package dam.salesianostriana.dam.GradesAPP.Profesor.model;

import dam.salesianostriana.dam.GradesAPP.Asignatura.model.Asignatura;
import dam.salesianostriana.dam.GradesAPP.User.model.User;
import jakarta.persistence.*;
import lombok.*;
import lombok.experimental.SuperBuilder;

import java.util.LinkedHashSet;
import java.util.Set;

@Entity
@Getter@Setter
@AllArgsConstructor
@NoArgsConstructor
@SuperBuilder
public class Profesor extends User {
    private String titulacion;
    private boolean esJefeEstudios;

    @OneToMany(mappedBy = "profesor", cascade = CascadeType.REMOVE, orphanRemoval = true)
    @ElementCollection(fetch = FetchType.LAZY)
    private Set<Asignatura> asignaturas = new LinkedHashSet<>();

}
