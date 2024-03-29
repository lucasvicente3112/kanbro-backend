package tcc.kanbro.repository;

import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import tcc.kanbro.model.Time;
import tcc.kanbro.model.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface UsuarioRepository extends JpaRepository<Usuario, Integer> {
    Usuario findAByNome(String nome);

    Optional<Usuario> findByEmail(String email);

    @Modifying
    @Query("UPDATE USUARIO u SET u.time = :ID_TIME WHERE u.idUsuario = :ID_USUARIO")
    void atualizaTimeDoUsuario(@Param("ID_USUARIO") Long idUsuario, @Param("ID_TIME") Time idTime);

    @Modifying
    @Query("UPDATE USUARIO u SET u.time = null WHERE u.idUsuario = :ID_USUARIO")
    void removeUsuarioDoTime(@Param("ID_USUARIO") Long idUsuario);

    @Query("SELECT u.time FROM USUARIO u WHERE u.email = :EMAIL")
    Time retornaIdTimePorEmail(@Param("EMAIL") String email);

    @Query("SELECT u FROM USUARIO u WHERE u.time = :ID_TIME")
    List<Usuario> retornaUsuariosPorTime(@Param("ID_TIME") Time idTime);
}
