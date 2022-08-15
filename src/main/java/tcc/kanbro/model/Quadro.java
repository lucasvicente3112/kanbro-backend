package tcc.kanbro.model;

import lombok.*;

import javax.persistence.*;
import java.util.List;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@EqualsAndHashCode
@Builder
public class Quadro {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idQuadro;

    @OneToOne
    private Time time;

    @OneToMany
    private List<Tarefa> tarefas;
}
