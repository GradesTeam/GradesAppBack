package dam.salesianostriana.dam.GradesAPP.asignatura.repository;

import dam.salesianostriana.dam.GradesAPP.asignatura.model.Asignatura;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface AsignaturaRepository extends JpaRepository<Asignatura, UUID> {
}
