package br.com.mania.churrasco.maniaChurrasco.application.domain;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "promocao")
@Data
@EqualsAndHashCode
@ToString
public class Promotion implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(generator = "increment")
    @GenericGenerator(name = "increment", strategy = "increment")
    private Long id;

    @Column(name = "desconto", nullable = false)
    private Integer discount;

    @OneToOne
    @JoinColumn(name = "produto_id", referencedColumnName = "id", nullable = false)
    private Product product;
}
