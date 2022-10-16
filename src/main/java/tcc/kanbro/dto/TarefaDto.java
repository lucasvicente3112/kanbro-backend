package tcc.kanbro.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.*;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@EqualsAndHashCode
@Builder
public class TarefaDto {

    @JsonProperty("id")
    private Long idTarefa;
    private String titulo;
    private String descricao;
    private String responsavel;
    private String status;

    private QuadroDto quadro;
}
