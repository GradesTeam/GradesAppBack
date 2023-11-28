package dam.salesianostriana.dam.GradesAPP;

import dam.salesianostriana.dam.GradesAPP.alumno.model.Alumno;
import dam.salesianostriana.dam.GradesAPP.alumno.repository.AlumnoRepository;
import dam.salesianostriana.dam.GradesAPP.asignatura.model.Asignatura;
import dam.salesianostriana.dam.GradesAPP.asignatura.repository.AsignaturaRepository;
import dam.salesianostriana.dam.GradesAPP.calificacion.model.Calificacion;
import dam.salesianostriana.dam.GradesAPP.calificacion.repository.CalificacionRepository;
import dam.salesianostriana.dam.GradesAPP.instrumento.model.Instrumento;
import dam.salesianostriana.dam.GradesAPP.instrumento.repository.InstrumentoRepository;
import dam.salesianostriana.dam.GradesAPP.profesor.model.Profesor;
import dam.salesianostriana.dam.GradesAPP.profesor.repository.ProfesorRepository;
import dam.salesianostriana.dam.GradesAPP.referenteEvaluacion.model.ReferenteEvaluacion;
import dam.salesianostriana.dam.GradesAPP.user.model.UserRole;
import jakarta.annotation.PostConstruct;
import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;
import java.time.LocalDate;
import java.util.Set;

@Component
@RequiredArgsConstructor
public class InitData {
    private final AsignaturaRepository asignaturaRepo;
    private final InstrumentoRepository repoIns;
    private final ProfesorRepository repoPrf;
    private final AlumnoRepository alumnoRepository;
    private final PasswordEncoder passwordEncoder;
    @PostConstruct
    public void InitData(){
        Profesor profe= Profesor.builder()
                .nombre("Pepe")
                .apellidos("Perez")
                .roles(Set.of(UserRole.ADMIN))
                .email("holamundoi@triana.com")
                .password(passwordEncoder.encode("123456789"))
                .username("Pepeillo")
                .titulacion("FICO")
                .esJefeEstudios(true)
                .build();
        Asignatura asig= Asignatura.builder()
                .nombre("AD")
                .horas(12L)
                .descripcion("Esta es una buena asignatura")
                .hexColor("#ff6961")
                .build();
        asig.addProfesor(profe);
        repoPrf.save(profe);
        asignaturaRepo.save(asig);
        Profesor pr = Profesor.builder()
                .nombre("Juan")
                .apellidos("Paquito")
                .roles(Set.of(UserRole.ADMIN))
                .password("1")
                .username("Juanito")
                .build();
        }
}
