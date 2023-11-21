package dam.salesianostriana.dam.GradesAPP.Asignatura.repository;

import dam.salesianostriana.dam.GradesAPP.Asignatura.model.Asignatura;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface AsignaturaRepository extends JpaRepository<Asignatura, UUID> {
}
