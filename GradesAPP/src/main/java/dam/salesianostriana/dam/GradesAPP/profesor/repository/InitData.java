package dam.salesianostriana.dam.GradesAPP.profesor.repository;

import dam.salesianostriana.dam.GradesAPP.alumno.model.Alumno;
import dam.salesianostriana.dam.GradesAPP.alumno.repository.AlumnoRepository;
import dam.salesianostriana.dam.GradesAPP.asignatura.model.Asignatura;
import dam.salesianostriana.dam.GradesAPP.asignatura.repository.AsignaturaRepository;
import dam.salesianostriana.dam.GradesAPP.profesor.model.Profesor;
import jakarta.annotation.PostConstruct;
import lombok.RequiredArgsConstructor;
import org.springframework.cglib.core.Local;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;
import java.util.HashSet;
import java.util.LinkedHashSet;

@Component
@RequiredArgsConstructor
public class InitData {

    private final AlumnoRepository alumnoRepository;
    private final ProfesorRepository profesorRepository;
    private final AsignaturaRepository asignaturaRepository;

    @PostConstruct
    public void init(){

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
        profesorRepository.save(p1);
        asignaturaRepository.save(asig1);

        alumnoRepository.save(a1);
    }
}
