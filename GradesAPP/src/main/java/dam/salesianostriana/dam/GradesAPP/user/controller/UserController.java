package dam.salesianostriana.dam.GradesAPP.user.controller;

import dam.salesianostriana.dam.GradesAPP.user.dto.UserDtoRegister;
import dam.salesianostriana.dam.GradesAPP.user.model.User;
import dam.salesianostriana.dam.GradesAPP.user.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/student")
@RequiredArgsConstructor
public class UserController {
    private final UserService userService;

    @PostMapping("/register")
    public ResponseEntity<UserDtoRegister> save (@RequestBody UserDtoRegister u){
        userService.saveAlumno(u);
        return ResponseEntity.status(201).body(u);
    }

}
