package tcc.kanbro.model;

import lombok.*;

import javax.persistence.*;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@EqualsAndHashCode
@Builder
public class Tarefa {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idTarefa;
    private String titulo;
    private String descricao;
    private String responsavel;
    private String status;

    @ManyToOne
    private Quadro quadro;
}
