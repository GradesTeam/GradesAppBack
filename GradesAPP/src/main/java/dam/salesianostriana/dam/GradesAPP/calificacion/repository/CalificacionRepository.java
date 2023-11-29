package dam.salesianostriana.dam.GradesAPP.calificacion.repository;

import dam.salesianostriana.dam.GradesAPP.alumno.model.Alumno;
import dam.salesianostriana.dam.GradesAPP.calificacion.model.Calificacion;
import dam.salesianostriana.dam.GradesAPP.instrumento.model.Instrumento;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;
import java.util.UUID;

public interface CalificacionRepository extends JpaRepository<Calificacion, UUID> {

    Page<Calificacion> findAllByInstrumento_Id(UUID id, Pageable pageable);
    @Query("SELECT c FROM Calificacion c WHERE c.alumno = :alumno")
    List<Calificacion> findByAlumno(@Param("alumno") Alumno alumno);
}
