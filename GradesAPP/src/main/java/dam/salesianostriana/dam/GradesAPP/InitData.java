package dam.salesianostriana.dam.GradesAPP;

import dam.salesianostriana.dam.GradesAPP.profesor.model.Profesor;
import dam.salesianostriana.dam.GradesAPP.profesor.repository.ProfesorRepository;
import dam.salesianostriana.dam.GradesAPP.asignatura.model.Asignatura;
import dam.salesianostriana.dam.GradesAPP.asignatura.repository.AsignaturaRepository;
import dam.salesianostriana.dam.GradesAPP.instrumento.model.Instrumento;
import dam.salesianostriana.dam.GradesAPP.instrumento.repository.InstrumentoRepository;
import dam.salesianostriana.dam.GradesAPP.referenteEvaluacion.model.ReferenteEvaluacion;
import dam.salesianostriana.dam.GradesAPP.user.model.UserRole;
import jakarta.annotation.PostConstruct;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import java.time.LocalDateTime;
import java.util.Set;

@Component
@RequiredArgsConstructor
public class InitData {
    private final AsignaturaRepository asignaturaRepo;
    private final InstrumentoRepository repoIns;
    private final ProfesorRepository profesorRepo;
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
        ReferenteEvaluacion ref1 = ReferenteEvaluacion.builder()
                .codReferente("Ad.2")
                .descripcion("Hola mundo")
                .asignatura(as)
                .build();
        ref1.setId(ref1.getId());
        as.addReferente(ref1);
        as.addProfesor(pr);
        profesorRepo.save(pr);
        asignaturaRepo.save(as);
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
}

