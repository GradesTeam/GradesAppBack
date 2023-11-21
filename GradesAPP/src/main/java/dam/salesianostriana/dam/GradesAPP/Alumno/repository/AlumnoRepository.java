package dam.salesianostriana.dam.GradesAPP.Alumno.repository;

import dam.salesianostriana.dam.GradesAPP.Alumno.model.Alumno;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface AlumnoRepository extends JpaRepository<Alumno, UUID> {
}
