package br.com.supermercado.api.dtos;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class CriacaoProdutoEstoqueDTO {

    private Long quantidade;
    private Long idDoProduto;

}
