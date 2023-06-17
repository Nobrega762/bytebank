package br.com.unpbankdigital.domain.entity;

import lombok.*;

import javax.persistence.*;
import java.math.BigDecimal;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
@Data
@Builder
public class Conta {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Long id;
    private Integer numero;
    private Float saldo;
    @ManyToOne
    @JoinColumn(name = "titular_id")
    private Cliente titular;


}
