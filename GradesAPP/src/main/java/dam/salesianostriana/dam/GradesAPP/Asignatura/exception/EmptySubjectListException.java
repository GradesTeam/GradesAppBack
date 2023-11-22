package dam.salesianostriana.dam.GradesAPP.Asignatura.exception;

import jakarta.persistence.EntityNotFoundException;

public class EmptySubjectListException extends EntityNotFoundException {

    public EmptySubjectListException(){
        super("The list of subjects is empty");
    }
}
