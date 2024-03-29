package tcc.kanbro.repository;

import tcc.kanbro.model.Time;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TimeRepository extends JpaRepository<Time, Integer> {
    Time findAByNome(String nome);
    Time findByIdTime(Long idTime);
}
