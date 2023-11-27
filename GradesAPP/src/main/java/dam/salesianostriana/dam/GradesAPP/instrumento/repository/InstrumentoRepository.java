package dam.salesianostriana.dam.GradesAPP.instrumento.repository;

import dam.salesianostriana.dam.GradesAPP.instrumento.model.Instrumento;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.UUID;

public interface InstrumentoRepository extends JpaRepository<Instrumento, UUID> {

    Page<Instrumento> findAllByAsignatura_Id(UUID id, Pageable pageable);
}
