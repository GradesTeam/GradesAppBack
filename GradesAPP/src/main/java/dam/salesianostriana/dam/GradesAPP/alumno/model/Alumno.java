package dam.salesianostriana.dam.GradesAPP.alumno.model;

import dam.salesianostriana.dam.GradesAPP.asignatura.model.Asignatura;
import dam.salesianostriana.dam.GradesAPP.user.model.User;
import jakarta.persistence.*;
import lombok.*;
import lombok.experimental.SuperBuilder;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.LinkedHashSet;
import java.util.Set;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@SuperBuilder
@Getter@Setter
public class Alumno extends User {

    private String telefono;
    private LocalDate fechaNacimiento;

    @Getter
    @ManyToMany
    @JoinTable(name = "Alumno_asignaturas",
            joinColumns = @JoinColumn(name = "alumno_id"),
            inverseJoinColumns = @JoinColumn(name = "asignaturas_id"))
    @ElementCollection(fetch = FetchType.LAZY)
    @Builder.Default
    private Set<Asignatura> asignaturas = new LinkedHashSet<>();

    @Override
    public boolean isAccountNonExpired() {
        return false;
    }

    @Override
    public boolean isAccountNonLocked() {
        return false;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return false;
    }

    @Override
    public boolean isEnabled() {
        return false;
    }
}
