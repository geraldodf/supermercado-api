package br.com.supermercado.api.models;


import lombok.Getter;
import lombok.Setter;

import javax.json.bind.annotation.JsonbTransient;
import javax.persistence.*;

@Getter
@Setter
@Entity
@Table(name = "relacao_vendas_produtos")
@IdClass(RelacaoVendaProdutoId.class)

public class RelacaoVendaProduto {

    @Id
    @ManyToOne
    @JoinColumn(name = "venda_id", referencedColumnName = "venda_id")
    @JsonbTransient
    private Venda venda;

    @Id
    @ManyToOne
    @JoinColumn(name = "produto_id", referencedColumnName = "produto_id")
    @JsonbTransient
    private Produto produto;

    @Column(name = "quantidade")
    private Long quantidade;

}
