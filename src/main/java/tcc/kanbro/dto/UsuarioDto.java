package tcc.kanbro.dto;

import lombok.*;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@EqualsAndHashCode
@Builder
public class UsuarioDto {

    private String email;
    private String nome;
    private String senha;
}
