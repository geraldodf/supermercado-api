package br.com.supermercado.api.models;


import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Getter
@Setter
@Entity
@Table(name = "relacao_vendas_produtos")
public class RelacaoVendaProduto {

    @Id
    private Long id;

    @ManyToOne
    @JoinColumn(name = "venda_id" )
    private Venda venda;

    @ManyToOne
    @JoinColumn(name = "produto_id")
    private Produto produto;

    @Column(name = "quantidade")
    private Long quantidade;

}
