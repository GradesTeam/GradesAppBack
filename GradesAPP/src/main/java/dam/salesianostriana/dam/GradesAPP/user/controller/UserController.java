package dam.salesianostriana.dam.GradesAPP.user.controller;

import com.fasterxml.jackson.annotation.JsonView;
import dam.salesianostriana.dam.GradesAPP.security.jwt.access.JwtProvider;
import dam.salesianostriana.dam.GradesAPP.user.dto.JwtUserResponse;
import dam.salesianostriana.dam.GradesAPP.user.dto.UserRegister;
import dam.salesianostriana.dam.GradesAPP.user.model.User;
import dam.salesianostriana.dam.GradesAPP.user.service.UserService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.security.core.Authentication;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/student")
@RequiredArgsConstructor
public class UserController {

    private final JwtProvider jwtProvider;
    private final AuthenticationManager authManager;
    private final UserService userService;

    @JsonView(UserRegister.UserResponse.class)
    @PostMapping("/register")
    public ResponseEntity<UserRegister> save (@Valid @RequestBody UserRegister u){
        userService.saveAlumno(u);

        /*
        Authentication authentication = authManager.authenticate(
                new UsernamePasswordAuthenticationToken(
                        u.getUsername(),
                        u.getPassword()
                )
        );

        SecurityContextHolder.getContext().setAuthentication(authentication);

        String token = jwtProvider.generateToken(authentication);

        User user = (User) authentication.getPrincipal();

         */

        return ResponseEntity.status(HttpStatus.CREATED).body(u);
    }

}
