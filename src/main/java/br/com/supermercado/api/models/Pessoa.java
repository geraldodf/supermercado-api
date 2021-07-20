package br.com.supermercado.api.models;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Table(name = "pessoas")
@Entity
public class Pessoa {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "pessoa_id")
    private Long id;

    @Column(name = "pessoa_nome")
    private String nome;

    @Column(name = "pessoa_cpf")
    private Long cpf;

    @OneToMany(mappedBy = "pessoa")
    private List<Venda> venda;

    public Long getId() {
        return id;
    }


    public List<Venda> getVenda() {
        return venda;
    }

    public void setVenda(List<Venda> venda) {
        this.venda = venda;
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

    public Long getCpf() {
        return cpf;
    }

    public void setCpf(Long cpf) {
        this.cpf = cpf;
    }
}
