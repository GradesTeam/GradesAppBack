package dam.salesianostriana.dam.GradesAPP.user.model;

import jakarta.persistence.*;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.NaturalId;
import org.hibernate.annotations.Parameter;
import java.util.Set;
import java.util.UUID;

@NoArgsConstructor
@Inheritance(strategy  = InheritanceType.JOINED)
@Entity
@Getter
public abstract class User {
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

    @NaturalId
    @Column(unique = true, updatable = false)
    private String username;

    private String password;

    private String email;

    private String nombre;
    private String apellidos;

    @ElementCollection(fetch = FetchType.EAGER)
    private Set<UserRole> roles;


}
