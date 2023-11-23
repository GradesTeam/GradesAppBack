package dam.salesianostriana.dam.GradesAPP.profesor.repository;

import dam.salesianostriana.dam.GradesAPP.profesor.model.Profesor;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface ProfesorRepository extends JpaRepository<Profesor, UUID> {
}
