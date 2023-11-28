package dam.salesianostriana.dam.GradesAPP.asignatura.repository;

import dam.salesianostriana.dam.GradesAPP.asignatura.AsignaturaDTO.GetAsignaturaDTO;
import dam.salesianostriana.dam.GradesAPP.asignatura.model.Asignatura;
import dam.salesianostriana.dam.GradesAPP.referenteEvaluacion.model.ReferenteEvaluacion;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;
import java.util.Optional;
import java.util.Set;
import java.util.UUID;

public interface AsignaturaRepository extends JpaRepository<Asignatura, UUID> {

    @Query("""
            select a.referentes from Asignatura a
            where a.id = :id
            """)
    Page<ReferenteEvaluacion> getReferentesFromAsignatura(UUID id, Pageable pageable);

    Page<Asignatura> findAll(Pageable pageable);

    @Query("""
            select a.referentes from Asignatura a
            where a.id = :id
            """)
    List<ReferenteEvaluacion> getNonPagedReferentesFromAsignatura(UUID id);

    @Query("""
            select a.referentes from Asignatura a
            """)
    List<ReferenteEvaluacion> getAllReferentes();
    @Query(
            """
            select r from ReferenteEvaluacion r
            where r.codReferente = :id        
            """
    )
    Optional<ReferenteEvaluacion> getReferenteById(String id);
    @Query("""
        select new dam.salesianostriana.dam.GradesAPP.asignatura.AsignaturaDTO.GetAsignaturaDTO(
            a.nombre, a.descripcion, concat(a.profesor.nombre,' ', a.profesor.apellidos), a.hexColor, (
                select case 
                    when count(al) > 0 then count(al)
                    else 0
                end
                from Alumno al
                where a member of al.asignaturas
            )
        )
        from Asignatura a            
        """)
    Page<GetAsignaturaDTO> obtenerTodasConNumeroAlumnos(Pageable pageable);
}
