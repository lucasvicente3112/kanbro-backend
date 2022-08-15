package tcc.kanbro.dto;

import lombok.*;
import tcc.kanbro.model.Time;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@EqualsAndHashCode
@Builder
public class UsuarioDto {

    private Time time;

    private String email;
    private String nome;
    private String senha;
}
