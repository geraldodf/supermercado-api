package br.com.supermercado.api.models;

import javax.persistence.*;
import javax.validation.constraints.NotNull;

@Table(name = "produtos")
@Entity
public class Produto {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "produto_id")
    private Long id;


    @Column(name = "produto_nome")
    private String nome;

    @NotNull(message = "Preco do produto nao pode ser null")
    @Column(name = "produto_preco")
    private Double preco;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public Double getPreco() {
        return preco;
    }

    public void setPreco(Double preco) {
        this.preco = preco;
    }
}
