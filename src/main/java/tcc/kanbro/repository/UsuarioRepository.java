package tcc.kanbro.repository;

import tcc.kanbro.model.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface UsuarioRepository extends JpaRepository<Usuario, Integer> {
    Usuario findAByNome(String nome);

    Optional<Usuario> findByEmail(String email);
}
