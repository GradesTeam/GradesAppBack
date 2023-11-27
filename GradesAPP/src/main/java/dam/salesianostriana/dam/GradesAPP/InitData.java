package dam.salesianostriana.dam.GradesAPP;

import dam.salesianostriana.dam.GradesAPP.alumno.model.Alumno;
import dam.salesianostriana.dam.GradesAPP.alumno.repository.AlumnoRepository;
import dam.salesianostriana.dam.GradesAPP.asignatura.model.Asignatura;
import dam.salesianostriana.dam.GradesAPP.asignatura.repository.AsignaturaRepository;
import dam.salesianostriana.dam.GradesAPP.instrumento.model.Instrumento;
import dam.salesianostriana.dam.GradesAPP.instrumento.repository.InstrumentoRepository;
import dam.salesianostriana.dam.GradesAPP.profesor.model.Profesor;
import dam.salesianostriana.dam.GradesAPP.profesor.repository.ProfesorRepository;
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
    private final AsignaturaRepository repoAs;
    private final InstrumentoRepository repoIns;
    private final ProfesorRepository repoPrf;
    private final AlumnoRepository alumnoRepository;
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
        ReferenteEvaluacion ref1 = ReferenteEvaluacion.builder()
                .codReferente("Ad.2")
                .descripcion("Hola mundo")
                .asignatura(as)
                .build();
        ref1.setId(ref1.getId());
        as.addReferente(ref1);
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

        Alumno a1 = new Alumno();
        a1.setNombre("Paco");
        a1.setApellidos("Paquito Pacazo");
        a1.setTelefono("658425963");
        a1.setFechaNacimiento(LocalDateTime.now());
        a1.setUsername("user");
        a1.setPassword("1");
        a1.setEmail("paco@paco.paco");

        Profesor p1 = new Profesor();
        p1.setNombre("Luismi");
        p1.setApellidos("Lopez Magaña");
        p1.setEmail("luismi@luismi.api");
        p1.setTitulacion("Crack");
        p1.setUsername("admin");
        p1.setPassword("1");
        p1.setEsJefeEstudios(true);

        Asignatura asig1 = new Asignatura();
        asig1.setNombre("Masa madre");
        asig1.setDescripcion("Cositas varias");
        asig1.setHoras(14L);
        asig1.setProfesor(p1);

        a1.getAsignaturas().add(asig1);
        repoPrf.save(p1);
        repoAs.save(asig1);

        alumnoRepository.save(a1);

    }
}
