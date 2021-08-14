package br.com.supermercado.api.models;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.List;

@Getter
@Setter
@Entity
@Table(name = "pagamentos")
public class Pagamento {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_pagamento")
    private int idPagamento;

    @Column(name = "data_pagamento")
    private String dataPagamento;

    @Column(name = "preco_a_pagar")
    private Double precoAPagar;

    @ManyToMany
    @JoinTable(name = "relacao_pagamentos_tipo_pagamentos", joinColumns = @JoinColumn(name = "pagamento_id"), inverseJoinColumns = @JoinColumn(name = "tipo_pagamento_id"))
    private List<TipoPagamento> tipoPagamento;

    @OneToOne(mappedBy = "pagamento")
    private Venda venda;


}
