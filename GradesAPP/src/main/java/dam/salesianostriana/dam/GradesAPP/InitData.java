package dam.salesianostriana.dam.GradesAPP;

import dam.salesianostriana.dam.GradesAPP.asignatura.model.Asignatura;
import dam.salesianostriana.dam.GradesAPP.asignatura.repository.AsignaturaRepository;
import dam.salesianostriana.dam.GradesAPP.instrumento.model.Instrumento;
import dam.salesianostriana.dam.GradesAPP.instrumento.repository.InstrumentoRepository;
import dam.salesianostriana.dam.GradesAPP.profesor.model.Profesor;
import jakarta.annotation.PostConstruct;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class InitData {
    private final AsignaturaRepository repo;
    private final InstrumentoRepository repoIns;
    @PostConstruct

    public void InitData(){
        Profesor pr = Profesor.builder()
                .build();
        Asignatura as = Asignatura.builder()
                .descripcion("Hola")
                .nombre("Diseño Interfaces")
                .profesor(pr)
                .build();
        repo.save(as);
        Instrumento is = Instrumento.builder()
                .nombre("Examen T1")
                .asignatura(as)
                .contenidos("Hola como estas")
                .build();
        repo.save(is);
    }
}
