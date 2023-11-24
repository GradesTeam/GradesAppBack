/*package dam.salesianostriana.dam.GradesAPP;

import dam.salesianostriana.dam.GradesAPP.asignatura.model.Asignatura;
import dam.salesianostriana.dam.GradesAPP.asignatura.repository.AsignaturaRepository;
import dam.salesianostriana.dam.GradesAPP.instrumento.model.Instrumento;
import dam.salesianostriana.dam.GradesAPP.instrumento.repository.InstrumentoRepository;
import dam.salesianostriana.dam.GradesAPP.profesor.model.Profesor;
import dam.salesianostriana.dam.GradesAPP.profesor.repository.ProfesorRepository;
import dam.salesianostriana.dam.GradesAPP.user.model.UserRole;
import jakarta.annotation.PostConstruct;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;
import java.util.Set;

@Component
@RequiredArgsConstructor
public class InitData {
    private final AsignaturaRepository repoAs;
    private final InstrumentoRepository repoIns;
    private final ProfesorRepository repoPrf;
    @PostConstruct
    public void InitData(){
        Profesor pr = Profesor.builder()
                .nombre("Juan")
                .apellidos("Paquito")
                .roles(Set.of(UserRole.ADMIN))
                .password("1")
                .username("Juanito")
                .build();
        Asignatura as = Asignatura.builder()
                .descripcion("Hola")
                .nombre("Diseño Interfaces")
                .build();
        as.addProfesor(pr);
        repoPrf.save(pr);
        repoAs.save(as);
        Instrumento is = Instrumento.builder()
                .nombre("Examen T1")
                .asignatura(as)
                .contenidos("Hola como estas")
                .fecha(LocalDateTime.of(2023, 11, 03, 12, 30))
                .build();
        repoIns.save(is);
        Instrumento is1 = Instrumento.builder()
                .nombre("Proyecto T1")
                .asignatura(as)
                .contenidos("Hola como estas")
                .fecha(LocalDateTime.of(2023, 12, 9, 12, 30))
                .build();
        repoIns.save(is1);
    }
}*/
