package tcc.kanbro.dto;

import lombok.*;
import tcc.kanbro.model.Quadro;
import tcc.kanbro.model.Usuario;

import java.util.List;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@EqualsAndHashCode
@Builder
public class TimeDto {

    private String nome;
    private List<Usuario> usuarios;
    private Quadro quadro;
}
