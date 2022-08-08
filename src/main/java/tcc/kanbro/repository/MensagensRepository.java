package tcc.kanbro.repository;

import tcc.kanbro.model.Mensagens;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MensagensRepository extends JpaRepository<Mensagens, Integer> {
}
