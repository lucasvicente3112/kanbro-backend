package tcc.kanbro.dto;

import lombok.*;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@EqualsAndHashCode
@Builder
public class TarefaDto {

    private String descricao;
    private String responsavel;

    private QuadroDto quadro;
}
