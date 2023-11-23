package dam.salesianostriana.dam.GradesAPP.instrumento.repository;

import dam.salesianostriana.dam.GradesAPP.instrumento.model.Instrumento;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;
import java.util.UUID;

public interface InstrumentoRepository extends JpaRepository<Instrumento, UUID> {
    @Query("""
            select a from Instrumento i
                join fetch i.asignatura asig
                where asig.id = id_asignatura
            """)
    List<Instrumento> getAllInstrumentosByAsignaturaId(UUID id_asignatura);
}
