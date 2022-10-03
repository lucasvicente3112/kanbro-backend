package tcc.kanbro.model;

import lombok.*;
import java.util.List;

import javax.persistence.*;

@Entity(name = "TIME")
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@EqualsAndHashCode
@Builder
public class Time {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idTime;

    private String nome;

    @OneToMany(mappedBy = "idUsuario", fetch = FetchType.LAZY)
    private List<Usuario> usuarios;

    @OneToOne
    private Quadro quadro;
}
