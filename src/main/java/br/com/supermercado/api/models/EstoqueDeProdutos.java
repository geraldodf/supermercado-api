package br.com.supermercado.api.models;


import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Getter
@Setter
@Entity
@Table(name = "estoque_produtos")
public class EstoqueDeProdutos {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "estoque_produtos")
    private Long id;

    @Column(name = "quantidade")
    private Long quantidade;

    @OneToOne
    @JoinColumn(name = "produtofk")
    private Produto produto;



}
