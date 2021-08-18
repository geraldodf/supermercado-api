package br.com.supermercado.api.dtos;


import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ProdutoASerVendidoDTO {

    private Long idDoProduto;
    private Long quantidadeProdutoASerVendido;

}
