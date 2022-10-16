package tcc.kanbro.model;

import lombok.*;

import javax.persistence.*;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Builder
public class Mensagem extends ModeloBaseMensagem{

    @Enumerated(EnumType.STRING)
    private TipoMensagem tipoMensagem;

    private String conteudo;
    private String sala;

    private String usuario;
}
