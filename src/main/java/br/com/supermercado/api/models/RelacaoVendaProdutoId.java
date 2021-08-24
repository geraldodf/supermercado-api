package br.com.supermercado.api.models;


import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;

@Getter
@Setter
public class RelacaoVendaProdutoId implements Serializable {

    private Long venda;
    private Long produto;

}
