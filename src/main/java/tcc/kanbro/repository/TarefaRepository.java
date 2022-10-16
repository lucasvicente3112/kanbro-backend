package tcc.kanbro.repository;

import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import tcc.kanbro.model.Quadro;
import tcc.kanbro.model.Tarefa;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.List;

public interface TarefaRepository extends JpaRepository<Tarefa, Integer> {
    List<Tarefa> findAllByQuadro(Quadro quadro);

    @Modifying
    @Query("UPDATE Tarefa t SET t.status = :STATUS WHERE t.idTarefa = :ID_TAREFA AND t.quadro = :ID_QUADRO")
    void atualizaStatus(@Param("ID_TAREFA") Long idTarefa, @Param("ID_QUADRO") Quadro quadro, @Param("STATUS") String status);
}
