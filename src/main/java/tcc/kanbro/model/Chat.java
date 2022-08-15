package tcc.kanbro.model;

import lombok.*;

import javax.persistence.*;

@Entity(name = "chat")
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@EqualsAndHashCode
public class Chat {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idChat;

}
