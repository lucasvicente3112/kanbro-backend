package tcc.kanbro.dto;

import lombok.*;
import java.util.List;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@EqualsAndHashCode
@Builder
public class TimeDto {

    private String nome;
    private List<UsuarioDto> usuarios;

}
