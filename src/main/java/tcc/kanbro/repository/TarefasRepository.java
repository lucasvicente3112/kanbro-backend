package tcc.kanbro.repository;

import tcc.kanbro.model.Tarefas;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TarefasRepository extends JpaRepository<Tarefas, Integer> {
}
