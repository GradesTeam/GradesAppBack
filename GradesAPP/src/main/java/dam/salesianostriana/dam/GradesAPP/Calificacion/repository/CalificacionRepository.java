package dam.salesianostriana.dam.GradesAPP.Calificacion.repository;

import dam.salesianostriana.dam.GradesAPP.Calificacion.model.Calificacion;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface CalificacionRepository extends JpaRepository<Calificacion, UUID> {
}
