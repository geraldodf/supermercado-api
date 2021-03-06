package br.com.supermercado.api.models;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.List;

@Getter
@Setter
@Entity
@Table(name = "vendas")
public class Venda {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "venda_id")
    private Long id;

    @Column(name = "venda_data")
    private String data;

    @ManyToOne
    @JoinColumn(name = "pessoafk")
    private Pessoa pessoa;

    @Column(name = "valor_a_pagar")
    private Double valorAPagar;

   /* @ManyToMany
    @JoinTable(name = "relacao_vendas_produtos", joinColumns = @JoinColumn(name = "venda_id"), inverseJoinColumns = @JoinColumn(name = "produto_id"))
    private List<Produto> produtos;*/

    @OneToOne
    @JoinColumn(name = "pagamentofk")
    private Pagamento pagamento;

    @OneToMany(mappedBy = "venda", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    private List<RelacaoVendaProduto> relacaoVendaProdutos;



}
