package dam.salesianostriana.dam.GradesAPP.alumno.repository;

import dam.salesianostriana.dam.GradesAPP.alumno.model.Alumno;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.UUID;

public interface AlumnoRepository extends JpaRepository<Alumno, UUID> {

}
