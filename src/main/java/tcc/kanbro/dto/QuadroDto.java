package tcc.kanbro.dto;

import lombok.*;
import tcc.kanbro.model.Tarefa;
import tcc.kanbro.model.Time;

import java.util.List;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@EqualsAndHashCode
@Builder
public class QuadroDto {

    private Time time;
    private List<Tarefa> tarefas;
}
