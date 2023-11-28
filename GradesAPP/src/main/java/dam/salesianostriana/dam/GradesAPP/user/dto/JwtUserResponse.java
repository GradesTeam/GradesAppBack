package dam.salesianostriana.dam.GradesAPP.user.dto;

import dam.salesianostriana.dam.GradesAPP.user.model.User;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;

@Data
@NoArgsConstructor
@AllArgsConstructor
@SuperBuilder
public class JwtUserResponse extends UserRegister {

    private String token;

    public JwtUserResponse(UserRegister userDtoRegister) {
        id = userDtoRegister.getId();
        username = userDtoRegister.getUsername();
    }


    public static JwtUserResponse of (User user, String token) {
        JwtUserResponse result = new JwtUserResponse(UserRegister.fromUser(user));
        result.setToken(token);
        return result;
    }
}
