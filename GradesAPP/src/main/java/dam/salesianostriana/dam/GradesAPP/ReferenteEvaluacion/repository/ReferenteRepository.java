package dam.salesianostriana.dam.GradesAPP.ReferenteEvaluacion.repository;

import dam.salesianostriana.dam.GradesAPP.Instrumento.model.Instrumento;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface ReferenteRepository extends JpaRepository<Instrumento, UUID> {
}
