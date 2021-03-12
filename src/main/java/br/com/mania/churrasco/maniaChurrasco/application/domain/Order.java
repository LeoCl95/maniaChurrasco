package br.com.mania.churrasco.maniaChurrasco.application.domain;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Entity
@Table(name = "pedido")
@Data
@EqualsAndHashCode
@ToString
public class Order implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(generator = "increment")
    @GenericGenerator(name = "increment", strategy = "increment")
    private Long id;

    @ManyToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    @JoinTable(name="produto_pedido",
            joinColumns={@JoinColumn(name="produto_id")},
            inverseJoinColumns={@JoinColumn(name="pedido_id")})
    private List<Product> products = new ArrayList<>();

    @Column(name = "valor_total", nullable = false)
    private Double amount;

    @Column(name = "quantidade_de_itens", nullable = false)
    private Integer quantityOfItens;

    @ElementCollection(fetch = FetchType.LAZY)
    @CollectionTable(name = "sugestoes_venda",
            joinColumns = @JoinColumn(name = "sugestao_venda_id"))
    private List<String> suggestiveSales = new ArrayList<>();

    @Column(name = "numero_do_pedido", nullable = false)
    private String orderNumber;

    @Column(name = "mesa",nullable = false)
    private String table;

    @Column(name = "data_criacao", nullable = false)
    @Temporal(TemporalType.TIMESTAMP)
    private Date createDate;

    @Column(name = "data_atualizacao", nullable = false)
    @Temporal(TemporalType.TIMESTAMP)
    private Date updateDate;

    @Column(name = "nome_usuario", nullable = false)
    private String userName;

    @ElementCollection(fetch = FetchType.LAZY)
    @CollectionTable(name = "notas",
            joinColumns = @JoinColumn(name = "notas_id"))
    private List<String> notes = new ArrayList<>();

    @PreUpdate
    public void preUpdate () {
        updateDate = new Date();
    }

    @PrePersist
    public void prePersist () {
        final Date actualDate = new Date();
        createDate = actualDate;
        updateDate = actualDate;
    }

}
