package dam.salesianostriana.dam.GradesAPP;

import dam.salesianostriana.dam.GradesAPP.profesor.model.Profesor;
import dam.salesianostriana.dam.GradesAPP.profesor.repository.ProfesorRepository;
import dam.salesianostriana.dam.GradesAPP.referenteEvaluacion.repository.ReferenteRepository;
import dam.salesianostriana.dam.GradesAPP.user.model.UserRole;
import jakarta.annotation.PostConstruct;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import dam.salesianostriana.dam.GradesAPP.asignatura.repository.AsignaturaRepository;
import dam.salesianostriana.dam.GradesAPP.asignatura.model.Asignatura;
import java.util.Set;

@Component
@RequiredArgsConstructor
public class InitData {
    private final AsignaturaRepository asignaturaRepo;
    private final ProfesorRepository profesorRepo;
    private final ReferenteRepository referenteRepo;
    @PostConstruct
    public void InitData(){
        Profesor profe= Profesor.builder()
                .nombre("Pepe")
                .apellidos("Perez")
                .roles(Set.of(UserRole.ADMIN))
                .email("holamundoi@triana.com")
                .password("123")
                .username("Pepeillo")
                .titulacion("Fracasado que no vale para el sector privado")
                .esJefeEstudios(true)
                .build();
        Asignatura asig= Asignatura.builder()
                .nombre("AD")
                .horas(12L)
                .descripcion("Esta es una buena asignatura")
                .hexColor("#0000ff")
                .build();
        asig.addProfesor(profe);
        profesorRepo.save(profe);
        asignaturaRepo.save(asig);
    }
}
