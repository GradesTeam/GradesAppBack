package dam.salesianostriana.dam.GradesAPP.profesor.repository;

import dam.salesianostriana.dam.GradesAPP.alumno.model.Alumno;
import dam.salesianostriana.dam.GradesAPP.profesor.model.Profesor;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;
import java.util.UUID;

public interface ProfesorRepository extends JpaRepository<Profesor, UUID> {
    @Query("""
            SELECT DISTINCT a FROM Alumno a
            JOIN a.asignatura asi
            JOIN asi.profesor p
            WHERE p.id = :profesorId
            """)
    List<Alumno> findAlumnosByProfesor(@Param("profesorId") UUID profesorId);
}
