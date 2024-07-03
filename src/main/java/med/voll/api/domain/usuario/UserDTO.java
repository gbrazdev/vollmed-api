package med.voll.api.domain.usuario;

import jakarta.validation.constraints.NotBlank;
import org.apache.catalina.User;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

public record UserDTO(
        @NotBlank(message = "{login.obrigatorio}")
        String login,

        @NotBlank(message = "{senha.obrigatorio}")
        String senha) {



}
