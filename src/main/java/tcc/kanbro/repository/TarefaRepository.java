package tcc.kanbro.repository;

import tcc.kanbro.model.Quadro;
import tcc.kanbro.model.Tarefa;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface TarefaRepository extends JpaRepository<Tarefa, Integer> {
    List<Tarefa> findAllByQuadro(Quadro quadro);
}
