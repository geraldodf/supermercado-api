package br.com.supermercado.api.models;

import javax.json.bind.annotation.JsonbTransient;
import javax.persistence.*;
import java.util.List;

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
    @JsonbTransient
    private Pessoa pessoa;

    @ManyToMany
    @JoinTable(name = "relacao_vendas_produtos", joinColumns = @JoinColumn(name = "venda_id"), inverseJoinColumns = @JoinColumn(name = "produto_id"))
    private List<Produto> produto;

    public List<Produto> getProduto() {
        return produto;
    }

    public void setProduto(List<Produto> produto) {
        this.produto = produto;
    }

    public Pessoa getPessoa() {
        return pessoa;
    }

    public void setPessoa(Pessoa pessoa) {
        this.pessoa = pessoa;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getData() {
        return data;
    }

    public void setData(String data) {
        this.data = data;
    }


}
