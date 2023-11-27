package dam.salesianostriana.dam.GradesAPP.asignatura.model;

import dam.salesianostriana.dam.GradesAPP.profesor.model.Profesor;
import dam.salesianostriana.dam.GradesAPP.referenteEvaluacion.model.ReferenteEvaluacion;
import jakarta.persistence.*;
import lombok.*;
import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.Parameter;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Builder
public class Asignatura {
    @Id
    @GeneratedValue(generator = "UUID")
    @GenericGenerator(
            name = "UUID",
            strategy = "org.hibernate.id.UUIDGenerator",
            parameters = {
                    @Parameter(
                            name = "uuid_gen_strategy_clas",
                            value = "org.hibernate.id.uuid.CurstomVersionOneStrategy"
                    )
            }
    )
    private UUID id;

    private String nombre;
    private Long horas;
    private String descripcion;
    private String hexColor;


    @Getter
    @ManyToOne(cascade = CascadeType.REMOVE)
    @JoinColumn(name = "profesor_id")
    private Profesor profesor;

    @OneToMany(mappedBy = "asignatura", fetch = FetchType.LAZY, cascade = CascadeType.ALL, orphanRemoval = true)
    @ElementCollection(fetch = FetchType.LAZY)
    @ToString.Exclude
    @Builder.Default
    private List<ReferenteEvaluacion> referentes = new ArrayList<>();

    public void addReferente(ReferenteEvaluacion referenteEvaluacion) {
        this.referentes.add(referenteEvaluacion);
        referenteEvaluacion.setAsignatura(this);
    }

    public void removeReferente(ReferenteEvaluacion ref) {
        this.referentes.remove(ref);
        ref.setAsignatura(null);
    }

    public void addProfesor(Profesor p){
       this.profesor = p;
       p.getAsignaturas().add(this);
    }

    public void removeProfesor(Profesor p){
        this.profesor = null;
        p.getAsignaturas().remove(this);
    }
}
