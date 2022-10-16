package tcc.kanbro.repository;

import tcc.kanbro.model.Quadro;
import org.springframework.data.jpa.repository.JpaRepository;
import tcc.kanbro.model.Time;

public interface QuadroRepository extends JpaRepository<Quadro, Integer> {

    Quadro findByTime(Time time);
    Quadro findByIdQuadro(Long id);
}
