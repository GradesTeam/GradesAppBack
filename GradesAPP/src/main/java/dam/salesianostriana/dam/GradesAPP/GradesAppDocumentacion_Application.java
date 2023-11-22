package dam.salesianostriana.dam.GradesAPP;

import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.info.Contact;
import io.swagger.v3.oas.annotations.info.Info;
import io.swagger.v3.oas.annotations.info.License;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@OpenAPIDefinition(info =
                    @Info(description= "Esto es una aplicación que suple la necesidad que tienen tanto profesores como alumnos de un curso para organizar las notas, asignaturas...",
                        version= "1.0",
                        contact= @Contact(email= "mmgmolina03@gamil.com, name= Manuel Molina García"),
                        license= @License(name= ""),
                        title= "Api sobre una aplicación de gestión de un curso"
                    )
)
public class GradesAppDocumentacion_Application {
    public static void main (String[] args){
        SpringApplication.run(GradesAppDocumentacion_Application.class, args);
    }
}
