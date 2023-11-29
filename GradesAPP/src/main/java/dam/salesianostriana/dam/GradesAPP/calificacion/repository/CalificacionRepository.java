package dam.salesianostriana.dam.GradesAPP.calificacion.repository;

import dam.salesianostriana.dam.GradesAPP.calificacion.model.Calificacion;
import dam.salesianostriana.dam.GradesAPP.instrumento.model.Instrumento;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.UUID;

public interface CalificacionRepository extends JpaRepository<Calificacion, UUID> {

    Page<Calificacion> findAllByInstrumento_Id(UUID id, Pageable pageable);
    List<Calificacion> findAllByInstrumento_Id(UUID id);
}
