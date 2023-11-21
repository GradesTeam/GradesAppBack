package dam.salesianostriana.dam.GradesAPP.Profesor.repository;

import dam.salesianostriana.dam.GradesAPP.Profesor.model.Profesor;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface ProfesorRepository extends JpaRepository<Profesor, UUID> {
}
