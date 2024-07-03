package med.voll.api.controller;

import jakarta.validation.Valid;
import med.voll.api.domain.medico.DadosCadastroMedico;
import med.voll.api.domain.medico.DadosDetalhamentoMedico;
import med.voll.api.domain.medico.Medico;
import med.voll.api.domain.usuario.UserDTO;
import med.voll.api.domain.usuario.Usuario;
import med.voll.api.domain.usuario.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.util.UriComponentsBuilder;

@RestController
@RequestMapping("user")
public class UserController {

    @Autowired
    UsuarioRepository repository;

    @PostMapping
    @Transactional
    public ResponseEntity cadastrar(@RequestBody @Valid UserDTO dados, UriComponentsBuilder uribuildder) {
        var user = new Usuario(dados);
        user.setSenha(dados.senha());
        System.out.println(user);
        repository.save(user);
        var uri = uribuildder.path("/medicos/{id").buildAndExpand(user.getId()).toUri();
        return ResponseEntity.created(uri).body(user);
    }
}
