package dam.salesianostriana.dam.GradesAPP.Instrumento.repository;

import dam.salesianostriana.dam.GradesAPP.Instrumento.model.Instrumento;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface InstrumentoRepository extends JpaRepository<Instrumento, UUID> {
}
