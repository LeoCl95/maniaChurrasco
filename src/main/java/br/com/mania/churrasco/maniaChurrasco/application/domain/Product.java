package br.com.mania.churrasco.maniaChurrasco.application.domain;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;
import java.util.List;

@Entity
@Table(name = "produto")
@Data
@EqualsAndHashCode
@ToString
public class Product implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(generator = "increment")
    @GenericGenerator(name = "increment", strategy = "increment")
    private Long id;

    @Column(name = "codigo", nullable = false, unique = true)
    private String code;

    @Column(name = "nome", nullable = false)
    private String name;

    @Column(name = "descricao", nullable = false)
    private String description;

    @Column(name = "preco", nullable = false)
    private Double price;

    @Column(name = "molho")
    private String sauce;

    @Column(name = "pao")
    private String bread;

    @Column(name = "ponto_carne")
    private String meatSpot;

    @Column(name = "categoria")
    private String category;

    @ManyToMany(mappedBy="products", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private List<Order> orders;

    @Column(name = "data_criacao", nullable = false)
    @Temporal(TemporalType.TIMESTAMP)
    private Date createDate;

    @Column(name = "data_atualizacao", nullable = false)
    @Temporal(TemporalType.TIMESTAMP)
    private Date updateDate;

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
