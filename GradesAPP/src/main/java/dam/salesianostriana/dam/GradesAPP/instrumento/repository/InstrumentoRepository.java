package dam.salesianostriana.dam.GradesAPP.instrumento.repository;

import dam.salesianostriana.dam.GradesAPP.instrumento.model.Instrumento;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.Optional;
import java.util.UUID;

public interface InstrumentoRepository extends JpaRepository<Instrumento, UUID> {

    Page<Instrumento> findAllByAsignatura_Id(UUID id, Pageable pageable);
    Optional<Instrumento> findByNombre(String name);
    @Override
    @Query("""
            Select i from Instrumento i
            where i.id = :id
            """)
    Optional<Instrumento> findById(UUID id);
}
