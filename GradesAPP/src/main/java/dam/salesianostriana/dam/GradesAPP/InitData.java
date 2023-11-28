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
<<<<<<< HEAD
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
=======
        private final AsignaturaRepository asignaturaRepo;
        private final InstrumentoRepository repoIns;
        private final ProfesorRepository repoPrf;
        private final AlumnoRepository alumnoRepository;
        private final CalificacionRepository repoCalf;
>>>>>>> main

        @PostConstruct
        public void InitData() {
                Profesor profe = Profesor.builder()
                                .nombre("Pepe")
                                .apellidos("Perez")
                                .roles(Set.of(UserRole.ADMIN))
                                .email("holamundoi@triana.com")
                                .password("123")
                                .username("Pepeillo")
                                .titulacion("FICO")
                                .esJefeEstudios(true)
                                .build();
                Asignatura asig = Asignatura.builder()
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

                Asignatura as = Asignatura.builder()
                                .horas(10L)
                                .descripcion("Hola")
                                .nombre("Diseño Interfaces")
                                .hexColor("#77dd77")
                                .build();
                ReferenteEvaluacion ref1 = ReferenteEvaluacion.builder()
                                .codReferente("Ad.2")
                                .descripcion("Hola mundo")
                                .build();
                ref1.setId(ref1.getId());
                ReferenteEvaluacion ref2 = ReferenteEvaluacion.builder()
                                .codReferente("Ad.3")
                                .descripcion("Hola mundo")
                                .build();
                ref2.setId(ref2.getId());
                as.addReferente(ref2);
                as.addReferente(ref1);
                as.addProfesor(pr);
                repoPrf.save(pr);
                asignaturaRepo.save(as);
                Instrumento is = Instrumento.builder()
                                .nombre("Examen T1")
                                .asignatura(as)
                                .contenidos("Hola como estas")
                                .fecha(LocalDate.of(2023, 11, 3))
                                .build();
                is.addReferente(ref1);
                is.addReferente(ref2);
                repoIns.save(is);
                Instrumento is1 = Instrumento.builder()
                                .nombre("Proyecto T1")
                                .asignatura(as)
                                .contenidos("Hola como estas")
                                .fecha(LocalDate.of(2023, 12, 9))
                                .build();
                repoIns.save(is1);

                Alumno a1 = new Alumno();
                a1.setNombre("Paco");
                a1.setApellidos("Paquito Pacazo");
                a1.setTelefono("658425963");
                a1.setFechaNacimiento(LocalDate.now());
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
                asig1.setHexColor("#ff6961");
                asig1.setHoras(14L);
                asig1.setProfesor(p1);

                a1.getAsignaturas().add(asig1);
                repoPrf.save(p1);
                asignaturaRepo.save(asig1);

                alumnoRepository.save(a1);
                Asignatura asig2 = Asignatura.builder()
                                .descripcion("Hola")
                                .nombre("Diseño Interfaces")
                                .hexColor("#77dd77")
                                .build();
                asig2.addProfesor(pr);
                asignaturaRepo.save(asig2);

                Asignatura asig3 = Asignatura.builder()
                                .descripcion("Hola")
                                .nombre("Diseño Interfaces")
                                .hexColor("#fdfd96")
                                .build();
                asig3.addProfesor(pr);
                asignaturaRepo.save(asig3);

                Asignatura asig4 = Asignatura.builder()
                                .descripcion("Hola")
                                .nombre("Diseño Interfaces")
                                .hexColor("#84b6f4")
                                .build();
                asig4.addProfesor(pr);
                asignaturaRepo.save(asig4);

                Asignatura asig5 = Asignatura.builder()
                                .descripcion("Hola")
                                .nombre("Diseño Interfaces")
                                .hexColor("#fdcae1")
                                .build();
                asig5.addProfesor(pr);
                asignaturaRepo.save(asig5);

                Asignatura asig6 = Asignatura.builder()
                                .descripcion("Hola")
                                .nombre("Diseño Interfaces")
                                .hexColor("#77dd77")
                                .build();
                asig6.addProfesor(pr);
                asignaturaRepo.save(asig6);

                Asignatura asig7 = Asignatura.builder()
                                .descripcion("Hola")
                                .nombre("Diseño Interfaces")
                                .hexColor("#b0c2f2")
                                .build();
                asig7.addProfesor(pr);
                asignaturaRepo.save(asig7);

                Asignatura asig8 = Asignatura.builder()
                                .descripcion("Hola")
                                .nombre("Diseño Interfaces")
                                .hexColor("#fdf9c4")
                                .build();
                asig8.addProfesor(pr);
                asignaturaRepo.save(asig8);
                Calificacion cal = Calificacion.builder()
                                .alumno(a1)
                                .calificacion(9.2)
                                .instrumento(is)
                                .referente(ref1)
                                .build();
                repoCalf.save(cal);
        }
}
