package br.com.supermercado.api.models;

import lombok.Getter;
import lombok.Setter;

import javax.json.bind.annotation.JsonbTransient;
import javax.persistence.*;
import java.util.List;

@Getter
@Setter
@Entity
@Table(name = "tipo_pagamentos")
public class TipoPagamento {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_tipo_pagamento")
    private Long idTipoPagamento;

    @Column(name = "nome_tipo_pagamento")
    private String nomeTipoPagamento;

}
