package med.voll.api.domain.usuario;

import org.springframework.security.core.GrantedAuthority;

import java.util.Collection;

public interface UsuarioDetalhes {
    Collection<? extends GrantedAuthority> getAuthorities();

    String getSenha();

    String getLogin();

    String getPassword();

    String getUsername();

    boolean isAccountNonExpired();

    boolean isAccountNonLocked();

    boolean isCredentialsNonExpired();

    boolean isEnabled();
}
