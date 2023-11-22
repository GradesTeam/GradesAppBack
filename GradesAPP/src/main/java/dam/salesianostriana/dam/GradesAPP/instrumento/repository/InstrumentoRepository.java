package dam.salesianostriana.dam.GradesAPP.instrumento.repository;

import dam.salesianostriana.dam.GradesAPP.instrumento.model.Instrumento;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface InstrumentoRepository extends JpaRepository<Instrumento, UUID> {
}
