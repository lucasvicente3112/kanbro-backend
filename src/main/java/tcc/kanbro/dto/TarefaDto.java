package tcc.kanbro.dto;

import lombok.*;
import tcc.kanbro.model.Quadro;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@EqualsAndHashCode
@Builder
public class TarefaDto {

    private String descricao;
    private String responsavel;

    private Quadro quadro;
}
