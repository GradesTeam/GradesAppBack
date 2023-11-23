package dam.salesianostriana.dam.GradesAPP.referenteEvaluacion.repository;

import dam.salesianostriana.dam.GradesAPP.instrumento.model.Instrumento;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface ReferenteRepository extends JpaRepository<Instrumento, UUID> {
}
