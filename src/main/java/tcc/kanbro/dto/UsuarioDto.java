package tcc.kanbro.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
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

    @JsonProperty(access = JsonProperty.Access.WRITE_ONLY)
    private String senha;
}
