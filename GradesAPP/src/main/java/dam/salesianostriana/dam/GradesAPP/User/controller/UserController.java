package dam.salesianostriana.dam.GradesAPP.User.controller;

import dam.salesianostriana.dam.GradesAPP.User.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/auth")
@RequiredArgsConstructor
public class UserController {
    private final UserService userService;
}
