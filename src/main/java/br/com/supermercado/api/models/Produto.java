package br.com.supermercado.api.models;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.List;

@Getter
@Setter
@Entity
@Table(name = "produtos")
public class Produto {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "produto_id")
    private Long id;

    @Column(name = "produto_nome")
    private String nome;

    @Column(name = "produto_preco")
    private Double preco;

    @OneToMany(mappedBy = "produto", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    private List<RelacaoVendaProduto> relacaoVendaProdutos;


}
