package dam.salesianostriana.dam.GradesAPP.instrumento.repository;

import dam.salesianostriana.dam.GradesAPP.instrumento.model.Instrumento;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;
import java.util.UUID;

public interface InstrumentoRepository extends JpaRepository<Instrumento, UUID> {
   /* @Query("""
            select i from Instrumento i
                join fetch i.asignatura asig
                where asig.id = id_asignatura
            """)
    List<Instrumento> getAllInstrumentosByAsignaturaId(@Param("id_asignatura") UUID id_asignatura);*/

    List<Instrumento> findAllByAsignatura_id(UUID id);
}
