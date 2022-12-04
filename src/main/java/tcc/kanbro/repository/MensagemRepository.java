package tcc.kanbro.repository;

import tcc.kanbro.model.Mensagem;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface MensagemRepository extends JpaRepository<Mensagem, Integer> {
    List<Mensagem> findAllBySala(String sala);
}
