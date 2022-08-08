package tcc.kanbro.model;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
@NoArgsConstructor
@AllArgsConstructor
public class Quadros {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idQuadro;
}
