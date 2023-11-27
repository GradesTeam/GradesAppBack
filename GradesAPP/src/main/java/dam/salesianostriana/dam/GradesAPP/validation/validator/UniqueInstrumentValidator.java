package dam.salesianostriana.dam.GradesAPP.validation.validator;

import dam.salesianostriana.dam.GradesAPP.instrumento.service.InstrumentoService;
import dam.salesianostriana.dam.GradesAPP.validation.annotation.UniqueCodReferente;
import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;

public class UniqueInstrumentValidator implements ConstraintValidator<UniqueCodReferente, String> {
    @Autowired
    private InstrumentoService service;


    @Override
    public boolean isValid(String s, ConstraintValidatorContext constraintValidatorContext) {
        return service.intrumentoExists(s);
    }
}
